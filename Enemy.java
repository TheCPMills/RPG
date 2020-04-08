package dlc;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import tools.*;
import builder.*;
import character.*;
import main.*;

/**
 * @version Version
 * @since 
 */

public class Enemy extends UniversalCharacter {
    Race itsRace;
    Difficulty itsDifficulty;
    int itsMaxHitPoints;
    int itsHitPoints;
    trilean enemyType = new trilean("Common", "Leader", "Boss", 1);
    public Enemy(String race, String difficulty, int type, Equipment[] equipment, Weapon[] weapons, Condition[] conditions) {
        itsName = race.toString();
        try {
            itsRace = Convert.toRace(race);
        }
        catch(IllegalEnumException e) {   
        }
        try {
            itsDifficulty = Convert.toDifficulty(difficulty);
        }
        catch(IllegalEnumException e) {   
        }
        if(equipment != null) {
            for(Equipment e : equipment) {
                itsEquipment.add(e);
            }
        }
        if(equipment != null) {
            for(Weapon w : weapons) {
                itsWeapons.add(w);
            }
        }
        if(equipment != null) {
            for(Condition c : conditions) {
                itsConditions.add(c);
            }
        }
        setHitPoints(itsDifficulty);
        if(type == 2 || type == 3) {
            convertToMasterEnemy(type); 
        }
        itsHitPoints = itsMaxHitPoints;
        try
        {   itsWeapons.add(new Fist());
        }
        catch(IllegalEnumException e)
        {   
        }
        isAlive = true;
    }
    
    public Enemy(String name, String difficulty, String race, int type, Equipment[] equipment, Weapon[] weapons, Condition[] conditions) {
        itsName = name + " the " + race.toString();
        try {
            itsRace = Convert.toRace(race);
        }
        catch(IllegalEnumException e) {   
        }
        if(equipment != null) {
            for(Equipment e : equipment) {
                itsEquipment.add(e);
            }
        }
        if(equipment != null) {
            for(Weapon w : weapons) {
                itsWeapons.add(w);
            }
        }
        if(equipment != null) {
            for(Condition c : conditions) {
                itsConditions.add(c);
            }
        }
        setHitPoints(itsDifficulty);
        if(type == 2 || type == 3) {
            convertToMasterEnemy(type); 
        }
        itsHitPoints = itsMaxHitPoints;
        try
        {   itsWeapons.add(new Fist());
        }
        catch(IllegalEnumException e)
        {   
        }
        isAlive = true;
    }
    
    private void setHitPoints(Difficulty difficulty) {
        switch(difficulty) {
            case Peaceful:
                itsMaxHitPoints = (int) (Math.random() * 5) + 1;
                break;
            case Beginner:
                itsMaxHitPoints = (int) (Math.random() * 15) + 6;
                break;
            case Easy:
                itsMaxHitPoints = (int) (Math.random() * 25) + 21;
                break;
            case Novice:
                itsMaxHitPoints = (int) (Math.random() * 35) + 46;
                break;
            case Intermediate:
                itsMaxHitPoints = (int) (Math.random() * 90) + 81;
                break;
            case Advanced:
                itsMaxHitPoints = (int) (Math.random() * 35) + 171;
                break;
            case Expert:
                itsMaxHitPoints = (int) (Math.random() * 25) + 206;
                break;
            case Insane:
                itsMaxHitPoints = (int) (Math.random() * 15) + 231;
                break;
            case Hellacious:
                itsMaxHitPoints = (int) (Math.random() * 5) + 246;
                break;
        }
    }
    
    private void convertToMasterEnemy(int type) {
        enemyType.updateActiveValue(type);
        itsName = itsName + " " + enemyType.toString();
        itsMaxHitPoints = enemyType.toString().equals("Leader") ? (int) (itsMaxHitPoints * 1.5 + 0.5) : itsMaxHitPoints * 2;
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