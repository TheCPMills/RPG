package main;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import tools.*;
import builder.*;
import character.*;

/**
 * AP CSA 2017-18
 * @author Chase P. Miller
 * @version Version 
 * @since
 */  

public abstract class Weapon implements Item
{   public String itsName;
    public int itsDamage;
    public Rarity itsRarity;
    public DamageType itsDamageType;
    public Dice itsDie;
    public Weapon(String name, int damage, Rarity rarity, DamageType damageType, int die)
    {   itsName = name;
        itsDamage = damage;
        itsRarity = rarity;
        itsDamageType = damageType;
        itsDie = new Dice(die);
    }
    
    public String getItsName()
    {   return itsName;
    }
    
    public Dice getItsDie()
    {   return itsDie;
    }
    
    public Rarity getItsRarity()
    {   return itsRarity;
    }
    
    public int getItsDamage()
    {   return itsDamage;
    }
    
    public String toString()
    {   return itsName + ": 1" + itsDie.toString() + " + " + itsDamage + " " + itsDamageType;
    }
    
    public boolean equals(Weapon w)
    {   if(itsName.compareTo(w.getItsName()) == 0 && itsRarity.compareTo(w.getItsRarity()) == 0)
        {   return true;
        }
        return false;
    }
    
    public abstract int damage();
}