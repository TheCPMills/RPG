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
 * @version Version 
 * @since
 */  

public class Spell implements main.Item
{   private String itsName;
    private main.Rarity itsRarity;
    private main.Condition itsEffect;
    private Dice itsDie;
    public Spell(String name, String rarity, String effect, int die)
    {   itsName = name;
        try {
            itsRarity = Convert.toRarity(rarity);
            itsEffect = Convert.toCondition(effect);
        }
        catch(IllegalEnumException ex) {
        }
        itsDie = new Dice(die);
    }
    
    public String getItsName()
    {   return itsName;
    }
    
    public main.Rarity getItsRarity()
    {   return itsRarity;
    }
    
    public String toString()
    {   if(itsEffect != null)
        {   return itsName + ": 1" + itsDie.toString() + " [Inflicts the Target With " + itsEffect + "]";
        }
        return itsName + ": 1" + itsDie.toString();
    }
    
    public int cast()
    {   return itsDie.roll();
    }
    
    public boolean equals(Spell s)
    {   if(itsName.compareTo(s.getItsName()) == 0 && itsRarity.compareTo(s.getItsRarity()) == 0)
        {   return true;
        }
        return false;
    }
    
    public main.Condition effect()
    {   return itsEffect;
    }
}