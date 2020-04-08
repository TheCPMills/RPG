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

public class Ritual extends Spell
{   private java.util.List<String> itsComponents = new ArrayList<String>();
    public Ritual(String name, String rarity, String effect, int die)
    {   super(name, rarity, effect, die);
        Scanner sc = new Scanner(System.in);
        System.out.println("Is There a Verbal Component?");
        if("Yes".equalsIgnoreCase(sc.nextLine()))
        {   itsComponents.add("Verbal Component");
        }
        System.out.println("\nIs There a Somatic Component?");
        if("Yes".equalsIgnoreCase(sc.nextLine()))
        {   itsComponents.add("Somatic Component");
        }
        System.out.println("\nAre There Any Material Components?");
        if("Yes".equalsIgnoreCase(sc.nextLine()))
        {   System.out.println("\nHow Many Material Components Are There?");
            int i = sc.nextInt();
            int j = i;
            System.out.println("Name The Material Components");
            for(; i > -1; i--)
            {   itsComponents.add(sc.nextLine());
            }
            System.out.println();
            itsComponents.remove("");
        }
    }
    
    public String toString()
    {   String s = super.toString() + " [Requires ";
        for(int i = 0; i < itsComponents.size(); i++)
        {   s += itsComponents.get(i) + ", ";
        }
        return s.substring(0, s.length() - 2) + "]";
    }
    
    public java.util.List<String> getItsComponents()
    {   return itsComponents;
    }
}