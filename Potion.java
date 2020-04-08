package tools;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import builder.*;
import character.*;

/**
 * AP CSA 2017-18
 * @author Chase P. Miller
 * @version Version 2.0.2
 * @since
 */  

public class Potion extends Equipment
{   private Condition [] itsEffects;
    public Potion(String name, int amount, String rarity, String... effect) throws IllegalEnumException
    {   super(name, amount, rarity);
        try {
            itsEffects = Convert.toConditionArray(effect);
        }
        catch(IllegalEnumException ex) {
        }
    }
    
    public Condition[] inflict()
    {  return itsEffects;
    }
    
    public String toString()
    {   String s = "";
        Condition [] condition = inflict();
        if(condition.length == 1 && condition[0] == Condition.Healing)
        {   return super.toString() + " [Heals the Target]";
        }
        for(Condition c : condition)
        {   if(c != Condition.Healing)
            {   s += c + ", ";
            }
        }
        s = s.substring(0, s.length() - 2);
        if(Utilities.indexOf(itsEffects, Condition.Healing) > -1)
        {   return super.toString() + " [Inflicts the Target With " + s + " and Heals the Target]";
        }
        return super.toString() + " [Inflicts the Target With " + s + "]";
    }
}