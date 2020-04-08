package builder;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import tools.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public abstract class Evil extends Character
{   public Evil()
    {   
    }
    
    public Evil(Good g)
    {   super(g.itsName, g.itsClass, g.itsAttributes, g.itsSkills);
        itsCoins = g.itsCoins;
        for(Armour a : g.itsArmour)
        {   dress(a);
        }
        itsExtraArmour = g.itsExtraArmour;
        itsEquipment = g.itsEquipment;
        itsWeapons = g.itsWeapons;
        itsSpells = g.itsSpells;
        itsConditions = g.itsConditions;
        itsExtraArmour = g.itsExtraArmour;
        itsConditions.remove(main.Condition.Stunned);
    }
    
    public void attack(Item item, UniversalCharacter c)
    {   if(isAlive)
        {   System.out.println(itsName + " Attacks");
            if(itsConditions.indexOf(Condition.Paralysis) != -1)
            {   System.out.println(itsName + " Was Stopped By Paralysis");
            }
            else
            {   boolean attack = false;
                String s = item.getClass().getSuperclass().toString();
                String st = item.getClass().toString();
                if(s.equals("class main.Weapon"))
                {   attackWithWeapon((Weapon) (item), c);
                    attack = true;
                }
                if(st.equals("class tools.Spell") || s.equals("class tools.Spell"))
                {   attackWithSpell((Spell) (item), c);
                    attack = true;
                }
                if(st.equals("class tools.Throwing") || st.equals("class tools.Potion"))
                {   attackWithEquipment((Equipment) (item), c);
                    attack = true;
                }
                if(!attack)
                {   System.out.println("Error: Cannot Attack With " + item.getItsName());
                }
            }
        }
        System.out.println();
    }

    private void attackWithWeapon(Weapon w, UniversalCharacter c)
    {   int a = new Dice(20).roll();
        int b = damageInfo(w);
        if(a > c.itsArmourClass && b > 0)
        {   if(a == 20)
            {   System.out.println("Critical Hit");
            }
            c.loseHitPoints(b);
            if(!Utilities.inList(c.itsConditions, Condition.Stunned) && w.getClass().toString().equals("class tools.Magical") && ((Magical) (w)).effect() != null)
            {   c.addCondition(((Magical) (w)).effect().toString());
            }
        }
        else if(a == 1)
        {   System.out.println("Critical Miss");
        }
        else
        {   System.out.println("Miss");
        }
    }

    private void attackWithSpell(Spell s, UniversalCharacter c)
    {   boolean q = true;
        java.util.List<Equipment> list = new ArrayList<Equipment>();
        int a = new Dice(20).roll();
        if(s.getClass().toString().compareTo("class tools.Ritual") == 0)
        {   java.util.List<String> comp = ((Ritual) (s)).getItsComponents();
            for(String g : comp)
            {   if(!g.equals("Verbal Component") && !g.equals("Somatic Component"))
                {   java.util.List<String> l = new ArrayList<String>();
                    for(Equipment e : itsEquipment)
                    {   l.add(e.getItsName());
                    }
                    if(Utilities.inList(l, g))
                    {   list.add(itsEquipment.get(l.indexOf(g)));
                    }
                    else
                    {   q = false;
                    }
                }
            }
            if(q)
            {   for(Equipment g : list)
                {   itsEquipment.get(itsEquipment.indexOf(g)).decrementItsAmount();
                    if(itsEquipment.get(itsEquipment.indexOf(g)).getItsAmount() == 0)
                    {   itsEquipment.remove(itsEquipment.get(itsEquipment.indexOf(g)));
                    }
                }
            }
            else
            {   System.out.println("The Ritual Could Not Be Completed");
            }
        }
        if(q)
        {   if(a > c.itsArmourClass)
            {   if(a == 20)
                {   System.out.println("Critical Hit");
                }
                int b = damageInfo(s);
                c.loseHitPoints(b);
                if(!Utilities.inList(c.itsConditions, Condition.Stunned) && s.effect() != Condition.Healing)
                {   c.addCondition(s.effect().toString());
                }
                else if(s.effect() == Condition.Healing)
                {   int i = new Dice(4).roll() + new Dice(4).roll() + 2;
                    addHitPoints(i);
                }
            }
            else if(a == 1)
            {   System.out.println("Critical Miss");
            }
            else
            {   System.out.println("Miss");
            }
        }
    }

    private void attackWithEquipment(Equipment e, UniversalCharacter c)
    {   if(e.getClass().toString().equals("class tools.Throwing"))
        {   int a = new Dice(20).roll();
            if(a > c.itsArmourClass)
            {   if(a == 20)
                {   System.out.println("Critical Hit");
                }
                int b = damageInfo(e);
                c.loseHitPoints(b);
                System.out.println(c.itsName + " Lost " + b + " Hit Points");
            }
            else if(a == 1)
            {   System.out.println("Critical Miss");
            }
            else
            {   System.out.println("Miss");
            }
        }
        if(e.getClass().toString().compareTo("class tools.Potion") == 0)
        {   Condition[] cons = ((Potion) (e)).inflict();
            for(Condition con : cons)
            {   c.addCondition(con.toString());
            }
            e.decrementItsAmount();
            if(e.getItsAmount() == 0)
            {   itsEquipment.remove(e);
            }
        }
    }

    public void use(Item item, UniversalCharacter c)
    {   if(isAlive)
        {   if(item.getClass().toString().compareTo("class tools.Spell") == 0 || item.getClass().toString().compareTo("class tools.Ritual") == 0)
            {   useSpell((Spell) (item), c);
            }
            else if(item.getClass().toString().compareTo("class tools.Throwing") == 0 || item.getClass().toString().compareTo("class tools.Potion") == 0 || item.getClass().toString().equals("class ElectromagneticRadiationRemovalKit"))
            {   useEquipment((Equipment) (item));
            }
            System.out.println();
        }
    }

    private void useSpell(Spell s, UniversalCharacter c)
    {   System.out.println(itsName + " Used " + s.getItsName());
        boolean r = true;
        if(s.getClass().toString().compareTo("class tools.Ritual") == 0)
        {   java.util.List<String> comp = ((Ritual) (s)).getItsComponents();
            java.util.List<Equipment> list = new ArrayList<Equipment>();
            for(String g : comp)
            {   if(g.compareTo("Verbal Component") != 0 && g.compareTo("Somatic Component") != 0)
                {   Equipment equ = null;
                    for(Equipment e : itsEquipment)
                    {   if(e.getItsName().compareTo(g) == 0)
                        {   equ = e;
                        }
                    }
                    if(equ != null)
                    {   list.add(equ);
                    }
                    else
                    {   r = false;
                    }
                }
            }
            if(r)
            {   for(Equipment g : list)
                {   itsEquipment.get(itsEquipment.indexOf(g)).decrementItsAmount();
                    if(itsEquipment.get(itsEquipment.indexOf(g)).getItsAmount() == 0)
                    {   itsEquipment.remove(itsEquipment.get(itsEquipment.indexOf(g)));
                    }
                }
            }
            else
            {   System.out.println("The Ritual Could Not Be Completed");
            }
        }
        if(r)
        {   if(!Utilities.inList(c.itsConditions, Condition.Stunned) && s.effect() != Condition.Healing)
            {   c.addCondition(s.effect().toString());
            }
            else if(s.effect() == Condition.Healing)
            {   int i = new Dice(4).roll() + new Dice(4).roll() + 2;
                addHitPoints(i);
            }
        }
    }

    private void useEquipment(Equipment e)
    {   System.out.println(itsName + " Used " + e.getItsName());
        if(e.getClass().toString().compareTo("class tools.Potion") == 0)
        {   Condition[] cons = ((Potion) (e)).inflict();
            String s = itsName + " is Inflicted With ";
            for(Condition con : cons)
            {   if(!Utilities.inList(itsConditions, Condition.Stunned) && con != Condition.Healing)
                {   addCondition(con.toString());
                }
                else if(con == Condition.Healing)
                {   int i = new Dice(4).roll() + new Dice(4).roll() + 2;
                    addHitPoints(i);
                    if(itsConditions.indexOf(Condition.Ataxia) != -1)
                    {   itsConditions.remove(Condition.Ataxia);
                    }
                }
            }
            System.out.println(s.substring(0, s.length() - 2));
        }
        if(e.getClass().toString().compareTo("class tools.ElectromagneticRadiationRemovalKit") == 0)
        {   if(itsConditions.indexOf(Condition.Asphyxia) != -1)
            {   itsConditions.remove(Condition.Asphyxia);
            }
            if(itsConditions.indexOf(Condition.Psychosis) != -1)
            {   itsConditions.remove(Condition.Psychosis);
                addCondition("Akathisia");
            }
        }
        e.decrementItsAmount();
        if(e.getItsAmount() == 0)
        {   itsEquipment.remove(e);
        }
    }

    private int damageInfo(Item i)
    {   if(isAlive)
        {   switch(i.getClass().toString())
            {   case "class tools.Melee":
                int b = Utilities.inList(itsConditions, Condition.Darkvision) ? ((Weapon) (i)).damage() * 2 : ((Weapon) (i)).damage();
                if(Utilities.inList(itsConditions, Condition.Enhanced_Leaping))
                {   b *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Speed))
                {   b *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Enraged))
                {   b *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Asthenia))
                {   b /= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Slowness))
                {   b /= 2;
                }
                return b;
                case "class tools.Fist":
                int g = Utilities.inList(itsConditions, Condition.Darkvision) ? ((Weapon) (i)).damage() * 2 : ((Weapon) (i)).damage();
                if(Utilities.inList(itsConditions, Condition.Enhanced_Leaping))
                {   g *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Speed))
                {   g *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Enraged))
                {   g *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Asthenia))
                {   g /= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Slowness))
                {   g /= 2;
                }
                return g;
                case "class tools.Ranged":
                int c = Utilities.inList(itsConditions, Condition.Darkvision) ? ((Weapon) (i)).damage() * 2 : ((Weapon) (i)).damage();
                if(Utilities.inList(itsConditions, Condition.Enhanced_Leaping))
                {   c *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Speed))
                {   c *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Enraged))
                {   c *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Asthenia))
                {   c /= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Slowness))
                {   c /= 2;
                }
                return c;
                case "class tools.Magical":
                int d = Utilities.inList(itsConditions, Condition.Darkvision) ? ((Weapon) (i)).damage() * 2 : ((Weapon) (i)).damage();
                if(Utilities.inList(itsConditions, Condition.Enhanced_Leaping))
                {   d *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Speed))
                {   d *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Enraged))
                {   d *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Asthenia))
                {   d /= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Slowness))
                {   d /= 2;
                }
                return d;
                case "class tools.Spell":
                int e = Utilities.inList(itsConditions, Condition.Darkvision) ? ((Spell) (i)).cast() * 2 : ((Spell) (i)).cast();
                if(Utilities.inList(itsConditions, Condition.Enhanced_Leaping))
                {   e *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Speed))
                {   e *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Enraged))
                {   e *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Asthenia))
                {   e /= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Slowness))
                {   e /= 2;
                }
                return e;
                case "class tools.Throwing":
                int f = Utilities.inList(itsConditions, Condition.Darkvision) ? ((Throwing) (i)).damage() * 2 : ((Throwing) (i)).damage();
                if(Utilities.inList(itsConditions, Condition.Enhanced_Leaping))
                {   f *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Speed))
                {   f *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Enraged))
                {   f *= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Asthenia))
                {   f /= 2;
                }
                if(Utilities.inList(itsConditions, Condition.Slowness))
                {   f /= 2;
                }
                return f;
            }
        }
        return -1;
    }

    public void addHitPoints(int i)
    {   if(isAlive)
        {   int b = ((BadHitPoints) (itsHitPoints)).size() - ((BadHitPoints) (itsHitPoints)).itsIrradiatedPoints;
            if(i > b)
            {   i = b;
            }
            for(int count = 0; count < i; count++)
            {   itsHitPoints.addHealth();
            }
            System.out.println(itsName + " Healed " + i + " Hit Points");
        }
    }

    public void loseHitPoints(int i)
    {   if(isAlive)
        {   int b = ((BadHitPoints) (itsHitPoints)).itsIrradiatedPoints;
            if(i > b)
            {   i = b;
            }
            for(int count = 0; count < i; count++)
            {   itsHitPoints.loseHealth();
            }
            System.out.println(itsName + " Lost " + i + " Hit Points");
            if(((BadHitPoints) (itsHitPoints)).itsIrradiatedPoints == 0)
            {   addCondition("Stunned");
                System.out.println("Appease the Gods and Pay for Their Revival or Leave Them Here to Rot Away, Rendering Them Usless for the Rest of the Campaign");
            }
        }
    }
}