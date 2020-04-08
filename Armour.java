package tools;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import builder.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Armour implements Comparable
{   public String itsName;
    public int itsArmourPoints;
    public Rarity itsRarity;
    public ArmourType itsArmourType;
    public ArrayList<Condition> itsEffects;
    public Armour(String name, int armourPoints, String rarity, String armourType, String... conditions) throws IllegalEnumException
    {   itsName = name;
        itsArmourPoints = armourPoints;
        itsRarity = Convert.toRarity(rarity);
        itsArmourType = Convert.toArmourType(armourType);
        itsEffects = new ArrayList<Condition>();
        for(String c : conditions)
        {   itsEffects.add(Convert.toCondition(c));
        }
    }
    
    public void enchant(String... conditions) throws IllegalEnumException
    {   for(String c : conditions)
        {   itsEffects.add(Convert.toCondition(c));
        }
    }
    
    public String toString() {
        String s = itsRarity + " " + itsName + " (" + itsArmourType + "): "  + itsArmourPoints;
        if(itsEffects.size() != 0) {
            s += "[Gives Wearer ";
            for(Condition c : itsEffects) {
                s += c + ", ";
            }
            s = s.substring(0, s.length() - 2) + "]";
        }
        return s;
    }
    
    public int compareTo(Object a) {
        ArmourType type = ((Armour) (a)).itsArmourType;
        switch(type) {
            case Headgear:
                if(itsArmourType == ArmourType.Headgear) {
                    return 0;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return 1;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return 2;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return 3;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return 4;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return 5;
                } else {
                    return 6;
                }
            case Spectacles:
                if(itsArmourType == ArmourType.Headgear) {
                    return -1;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return 0;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return 1;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return 2;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return 3;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return 4;
                } else {
                    return 5;
                }
            case Tunic:
                if(itsArmourType == ArmourType.Headgear) {
                    return -2;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return -1;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return 0;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return 1;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return 2;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return 3;
                } else {
                    return 4;
                }
            case Trinket:
                if(itsArmourType == ArmourType.Headgear) {
                    return -3;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return -2;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return -1;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return 0;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return 1;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return 2;
                } else {
                    return 3;
                }
            case Leggings:
                if(itsArmourType == ArmourType.Headgear) {
                    return -4;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return -3;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return -2;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return -1;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return 0;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return 1;
                } else {
                    return 2;
                }
            case Footwear:
                if(itsArmourType == ArmourType.Headgear) {
                    return -5;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return -4;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return -3;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return -2;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return -1;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return 0;
                } else {
                    return 1;
                }
            case Accessory:
                if(itsArmourType == ArmourType.Headgear) {
                    return -6;
                } else if(itsArmourType == ArmourType.Spectacles) {
                    return -5;
                } else if(itsArmourType == ArmourType.Tunic) {
                    return -4;
                } else if(itsArmourType == ArmourType.Trinket) {
                    return -3;
                } else if(itsArmourType == ArmourType.Leggings) {
                    return -2;
                } else if(itsArmourType == ArmourType.Footwear) {
                    return -1;
                } else {
                    return 0;
                }
            }
            return -7;
    }
}