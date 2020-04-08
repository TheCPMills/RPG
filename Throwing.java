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

public class Throwing extends Equipment
{   public Throwing(String name) throws IllegalEnumException
    {   super("Throwable " + name, 1, Rarity.Common.toString());
    }
    
    public Throwing(String name, int amount) throws IllegalEnumException
    {   super("Throwable " + name, amount, Rarity.Common.toString());
    }
    
    public String toString()
    {   return getItsName();
    }
    
    public int damage()
    {   return new Dice(4).roll();
    }
}