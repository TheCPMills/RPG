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

public class Melee extends main.Weapon
{   public Melee(String name, int damage, String rarity, int die) throws IllegalEnumException
    {   super(name, damage, Convert.toRarity(rarity), DamageType.Slashing, die);
    }
    
    public int damage()
    {   return getItsDie().roll() + getItsDamage();
    }
    
    public Magical enchant(String effect, int bonusDamage, int uses) throws IllegalEnumException
    {   return new Magical("Enchanted " + getItsName(), getItsDamage() + bonusDamage, itsRarity.toString(), (getItsDie()).getItsSides(), effect, uses);
    }
}