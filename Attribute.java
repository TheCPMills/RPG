package builder;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import tools.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Attribute extends Union<Attributes, Integer>
{   public Attribute(Attributes a, Integer i)
    {   super(a, i);
    }
    
    public Attributes getItsAttribute()
    {   return firstElement();
    }

    public int getItsPoints()
    {   return secondElement();
    }

    public static int[] getItsAttributeModifiers(Attribute[] a)
    {   int [] i = new int[9];
        for(int j = 0; j < 9; j++)
        {   i[j] = a[j].secondElement() > 10 ? ((a[j].secondElement() - 10) / 2) : ((a[j].secondElement() - 11) / 2);
        }
        return i;
    }
}
enum Attributes
{   Strength, Constitution, Dexterity, Charisma, Intelligence, Wisdom, Perception, Willpower, Luck;
    public static Attributes getAttribute(int i)
    {   return i == 0 ? Strength : i == 1 ? Constitution : i == 2 ? Dexterity : i == 3 ? Charisma : i == 4 ? Intelligence : i == 5 ? Wisdom : i == 6 ? Perception : i == 7 ? Willpower : Luck;
    }
}