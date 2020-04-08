package main;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import tools.*;
import builder.*;
import character.*;
import dlc.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Convert
{   public static Condition toCondition(String s) throws IllegalEnumException
    {   if(s.equals("Ageusia"))
        {   return Condition.Ageusia;
        }
        else if(s.equals("Akathisia"))
        {  return Condition.Akathisia;
        }
        else if(s.equals("Amnesia"))
        {   return Condition.Amnesia;
        }
        else if(s.equals("Anosmia"))
        {   return Condition.Anosmia;
        } 
        else if(s.equals("Aphasia"))
        {   return Condition.Aphasia;
        }
        else if(s.equals("Asphyxia"))
        {   return Condition.Asphyxia;
        }
        else if(s.equals("Asthenia"))
        {   return Condition.Asthenia;
        }
        else if(s.equals("Ataxia"))
        {   return Condition.Ataxia;
        }
        else if(s.equals("Agnosia"))
        {   return Condition.Agnosia;
        }
        else if(s.equals("Blindness"))
        {   return Condition.Blindness;
        }
        else if(s.equals("Darkvision"))
        {   return Condition.Darkvision;
        }
        else if(s.equals("Deafness"))
        {   return Condition.Deafness;
        }
        else if(s.equals("Enhanced Leaping"))
        {   return Condition.Enhanced_Leaping;
        }
        else if(s.equals("Enraged"))
        {   return Condition.Enraged;
        }
        else if(s.equals("Fatigue"))
        {   return Condition.Fatigue;
        }
        else if(s.equals("Healing"))
        {   return Condition.Healing;
        }
        else if(s.equals("Hunger"))
        {   return Condition.Hunger;
        }
        else if(s.equals("Insomnia"))
        {   return Condition.Insomnia;
        }
        else if(s.equals("Levitation"))
        {   return Condition.Levitation;
        }
        else if(s.equals("Paralysis"))
        {   return Condition.Paralysis;
        }
        else if(s.equals("Psychosis"))
        {   return Condition.Psychosis;
        }
        else if(s.equals("Poison"))
        {   return Condition.Poison;
        }
        else if(s.equals("Radioactivity"))
        {   return Condition.Radioactivity;
        }
        else if(s.equals("Slowness"))
        {   return Condition.Slowness;
        }
        else if(s.equals("Speed"))
        {   return Condition.Speed;
        }
        else if(s.equals("Stunned"))
        {   return Condition.Stunned;
        }
        else
        {   throw new IllegalEnumException("Condition:" + s + " Could Not Be Found");
        }
    }

    public static Rarity toRarity(String s) throws IllegalEnumException
    {   if(s.equals("Common"))
        {   return Rarity.Common;
        }
        else if(s.equals("Uncommon"))
        {   return Rarity.Uncommon;
        }
        else if(s.equals("Rare"))
        {   return Rarity.Rare;
        }
        else if(s.equals("Epic"))
        {   return Rarity.Epic;
        }
        else if(s.equals("Arcane"))
        {   return Rarity.Arcane;
        }
        else if(s.equals("Elite"))
        {   return Rarity.Elite;
        }
        else if(s.equals("Legendary"))
        {   return Rarity.Legendary;
        }
        else
        {   throw new IllegalEnumException("Rarity:" + s + " Could Not Be Found");
        }
    }

    public static ArmourType toArmourType(String s) throws IllegalEnumException
    {   if(s.equals("Headgear"))
        {   return ArmourType.Headgear;
        }
        else if(s.equals("Spectacles"))
        {   return ArmourType.Spectacles;
        }
        else if(s.equals("Tunic"))
        {   return ArmourType.Tunic;
        }
        else if(s.equals("Trinket"))
        {   return ArmourType.Trinket;
        }
        else if(s.equals("Leggings"))
        {   return ArmourType.Leggings;
        }
        else if(s.equals("Footwear"))
        {   return ArmourType.Footwear;
        }
        else if(s.equals("Accessory"))
        {   return ArmourType.Accessory;
        }
        else
        {   throw new IllegalEnumException("ArmourType:" + s + " Could Not Be Found");
        }
    }

    public static Difficulty toDifficulty(String s) throws IllegalEnumException
    {   if(s.equals("Peaceful"))
        {   return Difficulty.Peaceful;
        }
        else if(s.equals("Beginner"))
        {   return Difficulty.Beginner;
        }
        else if(s.equals("Easy"))
        {   return Difficulty.Easy;
        }
        else if(s.equals("Novice"))
        {   return Difficulty.Novice;
        }
        else if(s.equals("Intermediate"))
        {   return Difficulty.Intermediate;
        }
        else if(s.equals("Advanced"))
        {   return Difficulty.Advanced;
        }
        else if(s.equals("Expert"))
        {   return Difficulty.Expert;
        }
        else if(s.equals("Insane"))
        {   return Difficulty.Insane;
        }
        else if(s.equals("Hellacious"))
        {   return Difficulty.Hellacious;
        }
        else
        {   throw new IllegalEnumException("Difficulty:" + s + " Could Not Be Found");
        }     
    }

    public static Archetype toArchetype(String s) throws IllegalEnumException
    {   if(s.equals("Warrior"))
        {   return Archetype.Warrior;
        }
        else if(s.equals("Paladin"))         
        {   return Archetype.Paladin;
        }
        else if(s.equals("Ranger"))
        {   return Archetype.Ranger;
        }
        else if(s.equals("Wizard"))
        {   return Archetype.Wizard;
        }
        else if(s.equals("Cleric"))
        {   return Archetype.Cleric;
        }
        else if(s.equals("Rogue"))
        {   return Archetype.Rogue;
        }
        else if(s.equals("Swashbuckler"))
        {   return Archetype.Swashbuckler;
        }
        else if(s.equals("Sage"))
        {   return Archetype.Sage;
        }
        else
        {   throw new IllegalEnumException("Archetype:" + s + " Could Not Be Found");
        }
    }

    public static Income toIncome(String s) throws IllegalEnumException
    {   if(s.equals("Affluent"))
        {   return Income.Affluent;
        }
        else if(s.equals("Upper Middle Class"))
        {   return Income.UpMid;
        }
        else if(s.equals("Lower Middle Class"))
        {   return Income.LowMid;
        }
        else if(s.equals("Working Class"))
        {   return Income.Working;
        }
        else if(s.equals("Poverty"))
        {   return Income.Poverty;
        }
        else
        {   throw new IllegalEnumException("Income:" + s + " Could Not Be Found");
        }
    }

    public static Career toCareer(String s) throws IllegalEnumException
    {   if(s.equals("Architect"))
        {   return Career.Architect;
        }
        else if(s.equals("Armorer"))         
        {   return Career.Armorer;
        }
        else if(s.equals("Blacksmith"))
        {   return Career.Blacksmith;
        }
        else if(s.equals("Brewer"))
        {   return Career.Brewer;
        }
        else if(s.equals("Commonfolk"))
        {   return Career.Commonfolk;
        }
        else if(s.equals("Culinarian"))
        {   return Career.Culinarian;
        }
        else if(s.equals("Educator"))
        {   return Career.Educator;
        }
        else if(s.equals("Engineer"))
        {   return Career.Engineer;
        }
        else if(s.equals("Entertainer"))
        {   return Career.Entertainer;
        }
        else if(s.equals("Farmer"))
        {   return Career.Farmer;
        }
        else if(s.equals("Guard"))
        {   return Career.Guard;
        }
        else if(s.equals("Huntsman"))
        {   return Career.Huntsman;
        }
        else if(s.equals("Merchant"))
        {   return Career.Merchant;
        }
        else if(s.equals("Miner"))
        {   return Career.Miner;
        }
        else if(s.equals("Physician"))
        {   return Career.Physician;
        }
        else if(s.equals("Priest"))
        {   return Career.Priest;
        }
        else if(s.equals("Tinkerer"))
        {   return Career.Tinkerer;
        }
        else
        {   throw new IllegalEnumException("Career:" + s + " Could Not Be Found");
        }
    }
     
    public static Race toRace(String s) throws IllegalEnumException
    {   if(s.equals("Demon"))
        {   return Race.Demon;
        }
        else if(s.equals("Angel"))
        {   return Race.Angel;
        }
        else
        {   throw new IllegalEnumException("Race:" + s + " Could Not Be Found");
        }
    }

    public static Condition[] toConditionArray(String[] s) throws IllegalEnumException
    {   Condition[] c = new Condition[s.length];
        for(int i = 0; i < s.length; i++)
        {   c[i] = toCondition(s[i]);
        }         
        return c;
    }

    public static String[] toStringArray(Condition[] c)
    {   String[] s = new String[c.length];
        for(int i = 0; i < c.length; i++)
        {   s[i] = c[i].toString();
        }
        return s;
    }
}