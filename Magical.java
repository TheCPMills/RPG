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

public class Magical extends main.Weapon
{   private int itsUses;
    private main.Condition itsEffect;
    public Magical(String name, int damage, String rarity, int die, String effect, int uses) throws IllegalEnumException
    {   super(name, damage, Convert.toRarity(rarity), DamageType.Magical, die);
        itsEffect = Convert.toCondition(effect);
        itsUses = uses;
    }
    
    public Magical(String name, int damage, String rarity, int die, int uses) throws IllegalEnumException
    {   super(name, damage, Convert.toRarity(rarity), DamageType.Bludgeoning, die);
        itsUses = uses;
    }
    
    public String toString()
    {   if(itsEffect != null)
        {   return super.toString() + " [Inflicting the Target With " + itsEffect + "]";
        }
        return super.toString();
    }
    
    public int damage()
    {   itsUses--;
        return getItsDie().roll() + getItsDamage();
    }
    
    public main.Condition effect()
    {   if(itsEffect != null)
        {   return itsEffect;
        }
        return null;
    }
}