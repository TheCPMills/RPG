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
public class Ration extends Equipment
{   public Ration(int amount) throws IllegalEnumException
    {   super("Rations", amount, Rarity.Common.toString());
    }
    
    public void remove(int i)
    {   while(i > 0)
        {   decrementItsAmount();
            i--;
        }
    }
    
    public void add(int i)
    {   while(i > 0)
        {   incrementItsAmount();
            i--;
        }
    }
}