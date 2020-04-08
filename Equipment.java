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

public class Equipment implements Item
{   private String itsName;
    private int itsAmount;
    private Rarity itsRarity;
    public Equipment(String name, int amount, String rarity) throws IllegalEnumException
    {   itsName = name;
        itsAmount = amount;
        itsRarity = Convert.toRarity(rarity); 
    }
    
    public String getItsName()
    {   return itsName;
    }
    
    public int getItsAmount()
    {   return itsAmount;
    }
    
    public Rarity getItsRarity()
    {   return itsRarity;
    }
    
    public void decrementItsAmount()
    {   itsAmount--;
    }
    
    public void incrementItsAmount()
    {   itsAmount++;
    }
    
    public String toString()
    {   return itsRarity + " " + itsName + ": " + itsAmount;
    }
    
    public boolean equals(Equipment e)
    {   if(itsName.compareTo(e.getItsName()) == 0 && itsRarity.compareTo(e.getItsRarity()) == 0)
        {   return true;
        }
        return false;
    }
    
    public Throwing convertToThrowable() throws IllegalEnumException
    {   return new Throwing(getItsName(), getItsAmount());
    }
}