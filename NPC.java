package dlc;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import tools.*;
import builder.*;
import character.*;
import main.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class NPC extends UniversalCharacter
{   Career itsJob;
    int itsMaxHitPoints;
    int itsHitPoints;
    public NPC(String name, String career, Equipment[] equipment, Weapon[] weapons, Condition[] conditions)
    {   itsName = name;
        try
        {   itsJob = Convert.toCareer(career);
        }
        catch(IllegalEnumException e)
        {   
        }
        if(equipment != null) {
            for(Equipment e : equipment)
            {   itsEquipment.add(e);
            }
        }
        if(weapons != null) {
            for(Weapon w : weapons)
            {   itsWeapons.add(w);
            }
        }
        if(conditions != null) {
            for(Condition c : conditions)
            {   itsConditions.add(c);
            }
        }
        itsMaxHitPoints = (int) (Math.random() * 45) + 5;
        itsHitPoints = itsMaxHitPoints;
        try
        {   itsWeapons.add(new Fist());
        }
        catch(IllegalEnumException e)
        {   
        }
        isAlive = true;
    }
    
    public void attack(Item item, UniversalCharacter c)
    {   if(isAlive)
        {   if(itsConditions.indexOf(Condition.Stunned) != -1)
            {   System.out.println(itsName + "Cannot Attack\nThey Are Stunned");
            }
            else 
            {   System.out.println(itsName + " Attacks");
                if(itsConditions.indexOf(Condition.Fatigue) != -1)
                {   System.out.println(itsName + " Was Stopped By Their Fatigue");
                }
                else if(itsConditions.indexOf(Condition.Paralysis) != -1)
                {   System.out.println(itsName + " Was Stopped By Paralysis");
                }
                else 
                {   boolean attack = false;
                    String s = item.getClass().getSuperclass().toString();
                    String st = item.getClass().toString();
                    if(s.equals("class rpg.Weapon"))
                    {   attackWithWeapon((Weapon) (item), c);
                        attack = true;
                    }
                    if(st.equals("class tools.Throwing"))
                    {   attackWithThrowing((Throwing) (item), c);
                        attack = true;
                    }
                    if(!attack)
                    {   System.out.println("Error: Cannot Attack With " + item.getItsName());
                    }
                }
            }
        }
        System.out.println();
    }
    
    private void attackWithWeapon(Weapon w, UniversalCharacter c)
    {   if(isAlive)
        {   int a = new Dice(20).roll();
            int b = damageInfo(w);
            if(a > c.itsArmourClass && b > 0)
            {   if(a == 20)
                {   System.out.println("Critical Hit");
                }
                c.loseHitPoints(b);
                if(Utilities.inList(c.itsConditions, Condition.Stunned) && w.getClass().toString().equals("class Magical") && ((Magical) (w)).effect() != null)
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
    }
    
    private void attackWithThrowing(Throwing t, UniversalCharacter c)
    {   if(isAlive)
        {   int a = new Dice(20).roll();
            if(a > c.itsArmourClass)
            {   if(a == 20)
                {   System.out.println("Critical Hit");
                }
                int b = damageInfo(t);
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
        {   if(i > itsMaxHitPoints)
            {   i = itsMaxHitPoints;
            }
            for(int count = 0; count < i; count++)
            {   itsHitPoints++;
            }
            System.out.println(itsName + " Healed " + i + " Hit Points");
        }
    }
    
    public void loseHitPoints(int i)
    {   if(isAlive)
        {   if(i > itsHitPoints)
            {   i = itsHitPoints;
            }
            for(int count = 0; count < i; count++)
            {   itsHitPoints--;
            }
            System.out.println(itsName + " Lost " + i + " Hit Points");
            if(itsHitPoints <= 0)
            {   addCondition("Stunned");
            }
        }
    }
    
    public void addCondition(String s)
    {   if(isAlive)
        {   Condition c = Condition.Healing;
            try
            {   c = Convert.toCondition(s);
            }
            catch(IllegalEnumException e)
            {   
            }
            int i = -1;
            for(int j = 0; j < itsConditions.size(); j++)
            {   if(!itsConditions.get(j).toString().equals(c.toString()))
                {   i = j;
                }
            }
            if(i == -1 && c != null)
            {   itsConditions.add(c);
                if(c.toString().equals("Stunned"))
                {   System.out.println(itsName + " is Now Dead");
                    isAlive = false;
                }
                else if(c.toString().equals("Paralysis"))
                {   System.out.println(itsName + " is Now Paralyzed");
                }
                else if(c.toString().equals("Poison"))
                {   System.out.println(itsName + " is Now Poisoned");
                }
                else if(c.toString().equals("Healing"))
                {   System.out.println(itsName + " is Now Healed");
                }
                else if(c.toString().equals("Enraged"))
                {   System.out.println(itsName + " is Now Enraged");
                }
                else
                {   System.out.println(itsName + " is Now Inflicted With " + c);
                }
            }
        }
    }
}