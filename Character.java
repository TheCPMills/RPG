package builder;
import java.util.*;
import javax.swing.*;
import java.math.*;
import main.*;
import tools.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version 5.3.2
 * @since 12 June 2018
 */

public abstract class Character extends UniversalCharacter
{   public Archetype itsClass;
    public Income itsIncome;
    public int itsCoins;
    public Attribute[] itsAttributes = new Attribute[9];
    public int[] itsAttributeModifiers = new int[9];
    public Skill[] itsSkills = new Skill[6];
    public List<Spell> itsSpells = new ArrayList<Spell>();
    public Power itsPower;
    public HitPoints itsHitPoints;
    public int itsSizeModifier;
    public int itsLevel;
    public int itsExperience;
    public Character()
    {   Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        itsName = sc.nextLine();
        itsSizeModifier = setItsSizeModifier();
        System.out.println("\nEnter Class");
        try
        {   itsClass = Convert.toArchetype(sc.nextLine());
        }
        catch(IllegalEnumException e)
        {   
        }
        System.out.println("\nEnter Income");
        try
        {   itsIncome = Convert.toIncome(sc.nextLine());
        }
        catch(IllegalEnumException e)
        {   
        }
        itsCoins = Income.getStartingMoney(itsIncome);
        int points = 50;
        System.out.println("\nAttributes:");
        for(int i = 0; i < 9; i++)
        {   if(points != 0)
            {   if(i > 0)
                {   System.out.println("\n" + points + " Points Left");
                }
                System.out.println("Enter Value for " + Attributes.getAttribute(i) + " (between Values 0 and 9)");
                int a = sc.nextInt();
                while(a > points || a < 0 || a > 9)
                {   System.out.println("Not Acceptable Value. Try Again.");
                    a = sc.nextInt();
                }
                itsAttributes[i] = new Attribute(Attributes.getAttribute(i), a + 6);
                points -= a;
            }
            else
            {   itsAttributes[i] = new Attribute(Attributes.getAttribute(i), 6);
            }
        }
        itsAttributeModifiers = Attribute.getItsAttributeModifiers(itsAttributes);
        System.out.println("\nSkills:");
        int point = 12;
        for(int i = 0; i < 6; i++)
        {   if(point != 0)
            {   if(i > 0)
                {   System.out.println("\n" + point + " Points Left");
                }
                System.out.println("Enter Value for " + Skills.getSkill(i) + " (between Values 0 and 3)");
                int b = sc.nextInt();
                while(b > point || b < 0 || b > 3)
                {   System.out.println("Not Acceptable Value. Try Again.");
                    b = sc.nextInt();
                }
                if(i == 0)
                {   int average = (int) ((itsAttributeModifiers[1] + itsAttributeModifiers[5] + itsAttributeModifiers[7]) / 3.0);
                    itsSkills[i] = new Skill(Skills.getSkill(i), b + average);
                }
                else if(i == 1)
                {   int average = (int) ((itsAttributeModifiers[0] + itsAttributeModifiers[2]) / 2.0);
                    itsSkills[i] = new Skill(Skills.getSkill(i), b + average);
                }
                else if(i == 2)
                {   int average = (int) ((itsAttributeModifiers[3] + itsAttributeModifiers[8]) / 2.0);
                    itsSkills[i] = new Skill(Skills.getSkill(i), b + average);
                }
                else if(i == 3)
                {   int average = (int) ((itsAttributeModifiers[4] + itsAttributeModifiers[6]) / 2.0);
                    itsSkills[i] = new Skill(Skills.getSkill(i), b + average);
                }
                else if(i == 4)
                {   int average = (int) ((itsAttributeModifiers[6] + itsAttributeModifiers[8]) / 2.0);
                    itsSkills[i] = new Skill(Skills.getSkill(i), b + average);
                }
                else
                {   int average = (int) ((itsAttributeModifiers[4] + itsAttributeModifiers[5] + itsAttributeModifiers[8]) / 3.0);
                    itsSkills[i] = new Skill(Skills.getSkill(i), b + average);
                }
                point -= b;
            }
            else
            {     itsSkills[i] = new Skill(Skills.getSkill(i), 6);
            }
        }
        itsPower = getItsPower();
        itsArmourClass = 0;
        itsLevel = 0;
        itsExperience = 0;
        itsHitPoints = getClass().getSuperclass().toString().equals("class builder.Good") ? new GoodHitPoints((Good) (this)) : new BadHitPoints((Evil) (this));
        try
        {   itsWeapons.add(new Fist());
        }
        catch(IllegalEnumException e)
        {   
        }
        System.out.println();
    }

    public Character(String name, Archetype archetype, Attribute[] attributes, Skill[] skills)
    {   itsName = name;
        itsClass = archetype;
        itsAttributes = attributes;
        itsSkills = skills;
        itsCoins = 0;
        itsArmourClass = 0;
        itsLevel = 0;
        itsExperience = 0;
        itsHitPoints = getClass().getSuperclass().toString().equals("class builder.Good") ? new GoodHitPoints((Good) (this)) : new BadHitPoints((Evil) (this));
        System.out.println();
    }
    
    public String toString()
    {   if(isAlive)
        {   String s = itsClass + " " + itsName + "'s Information:\n";
            s += "\nCoins: " + itsCoins + " Quantium\n";
            s += "\nAttributes:\n";
            for(int i = 0; i < 9; i++)
            {   s +=  itsAttributes[i].getItsAttribute() + ": " + itsAttributes[i].getItsPoints() + "\n";
            }
            s += "\nSkills:\n";
            for(int i = 0; i < 6; i++)
            {   s +=  itsSkills[i].getItsSkill() + ": " + itsSkills[i].getItsPoints() + "\n";
            }
            s +=  "\nEquipment:\n";
            for(Equipment e : itsEquipment)
            {   s += e.toString() + "\n";
            }
            s +=  "\nWeapons:\n";
            for(main.Weapon w : itsWeapons)
            {   s +=  w.toString() + "\n";
            }
            s +=  "\nSpells:\n";
            for(Spell sp : itsSpells)
            {   s +=  sp.toString() + "\n";
            }
            s +=  "\nConditions:\n";
            for(main.Condition c : itsConditions)
            {   s +=  c.toString() + "\n";
            }
            itsHitPoints.displayHealthBar();
            displayProfile();
            return s;
        }
        return "";
    }

    public abstract void attack(Item item, UniversalCharacter c);

    public abstract void use(Item item, UniversalCharacter c);
    
    public void voodooMagic()
    {   if(isAlive)
        {   if(itsConditions.indexOf(main.Condition.Amnesia) != -1)
            {   itsConditions.remove(main.Condition.Amnesia);
            }
            addCondition("Darkvision");
            addCondition("Enraaged");
            addCondition("Slowness");
            addCondition("Weakness");
            addCondition("Hunger");
        }
    }

    public abstract int setItsSizeModifier();
    
    public abstract Power getItsPower();

    public abstract void displayProfile();

    public abstract void addHitPoints(int i);

    public abstract void loseHitPoints(int i);

    public void addCondition(String s)
    {   if(isAlive)
        {   main.Condition c = Condition.Healing;
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
            {   if(c != Condition.Healing)
                {   itsConditions.add(c);
                }
                if(c.toString().equals("Stunned"))
                {   System.out.println(itsName + " is Now Dead");
                    isAlive = false;
                }
                else if(c.toString().equals("Radioactivity"))
                {   System.out.println(itsName + " is Now Radioactive\nYou Must Convert Them to Evil");
                }
                else if(c.toString().equals("Paralysis"))
                {   System.out.println(itsName + " is Now Paralyzed");
                }
                else if(c.toString().equals("Poison"))
                {   System.out.println(itsName + " is Now Poisoned");
                }
                else if(c.toString().equals("Fatigue"))
                {   System.out.println(itsName + " is Now Fatigued");
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

    public void addWeapon(Weapon w)
    {   if(isAlive)
        {   String s = itsClass.toString();
            if(w.getClass().toString().equals("tools.Melee"))
            {   if(!(s.equals("Warrior") || s.equals("Paladin") || s.equals("Rogue") || s.equals("Swashbuckler")))
                {   System.out.println("Your Class Forbids Adding " + w.itsName + " to Your Inventory");
                }
            }
            else if(w.getClass().toString().equals("tools.Ranged"))
            {   if(!(s.equals("Ranger") || s.equals("Rogue") || s.equals("Swashbuckler")))
                {   System.out.println("Your Class Forbids Adding " + w.itsName + " to Your Inventory");
                }
            }
            else if(w.getClass().toString().equals("tools.Magical"))
            {   if(!(s.equals("Paladin") || s.equals("Wizard") || s.equals("Sage")))
                {   System.out.println("Your Class Forbids Adding " + w.itsName + " to Your Inventory");
                }
            }
            else if(itsWeapons.size() != 0)
            {   int i = -1;
                for(int j = 0; j < itsWeapons.size(); j++)
                {   if(w.getClass().toString().compareTo(itsWeapons.get(j).getClass().toString()) == 0 && itsWeapons.get(j).equals(w))
                    {   i = j;
                    }
                }
                if(i == -1)
                {   itsWeapons.add(w);
                }
            }
            else
            {   itsWeapons.add(w);
            }
        }
    }

    public void addSpell(Spell s)
    {   if(isAlive)
        {   String st = itsClass.toString();
            if(s.getClass().toString().equals("tools.Spell"))
            {   if(!(st.equals("Wizard")))
                {   System.out.println("Your Class Forbids Adding " + s.getItsName() + " to Your Inventory");
                }
            }
            else if(s.getClass().toString().equals("tools.Ritual"))
            {   if(!(st.equals("Cleric") || st.equals("Sage")))
                {   System.out.println("Your Class Forbids Adding " + s.getItsName() + " to Your Inventory");
                }
            }
            else if(itsSpells.size() != 0)
            {   int i = -1;
                for(int j = 0; j < itsSpells.size(); j++)
                {   if(itsSpells.get(j).equals(s))
                    {   i = j;
                    }
                }
                if(i == -1)
                {   itsSpells.add(s);
                }
            }
            else
            {   itsSpells.add(s);
            }
        }
    }

    public void addEquipment(Equipment e)
    {   if(isAlive)
        {   if(itsEquipment.size() != 0)
            {   int i = -1;
                for(int j = 0; j < itsEquipment.size(); j++)
                {   if(e.getClass().toString().compareTo(itsEquipment.get(j).getClass().toString()) == 0 && itsEquipment.get(j).equals(e))
                    {   i = j;
                    }
                }
                if(i == -1)
                {   itsEquipment.add(e);
                }
                else
                {   for(int j = e.getItsAmount(); j > 0; j--)
                    {   itsEquipment.get(i).incrementItsAmount();
                    }
                }
            }
            else
            {   itsEquipment.add(e);
            }
        }
    }

    public void addExperience(int i)
    {   if(isAlive)
        {   itsExperience += i;
            levelUp();
        }
    }
    
    public void changeCoins(int i)
    {   itsCoins += i;
    }

    private void levelUp()
    {   if(isAlive)
        {   if(itsLevel < 50)
            {   if(itsExperience / (itsLevel + 1) >= 300)
                {   itsLevel++;
                    System.out.println(itsName + " Leveled Up\n" + itsName + " is Now Level " + itsLevel + "\n");
                    itsHitPoints.levelUp(((itsLevel - 1) / 2) + 5);
                }
            }
        }
    }
    
    public void necromance()
    {   if(!isAlive)
        {   int amount = (Math.abs(itsArmourClass) * itsSizeModifier) + itsHitPoints.size();
            if(amount > itsCoins)
            {   System.out.println(itsName + " Did Not Have Enough Quantium to Revive Themself");
            }
            else
            {   changeCoins(-amount);
                itsConditions.remove(Condition.Stunned);
                int i = getClass().getSuperclass().toString().equals("class builder.Good") ? ((GoodHitPoints) (itsHitPoints)).firstRadiation - 1 : ((BadHitPoints) (itsHitPoints)).size() - 1;
                while(i > -1)
                {   itsHitPoints.addHealth();
                    i--;
                }
                itsHitPoints.displayHealthBar();
                isAlive = true;
            }
        }
        else
        {   System.out.println(itsName + " is Alive\nNo Need to Revive Them\n");
        }
    }

    public void getStats()
    {   if(isAlive)
        {   System.out.println(this);
        }
    }
}