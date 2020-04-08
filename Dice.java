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

public class Dice
{   private int sides;
    public Dice(int i)
    {   sides = i;
    }
    
    public int getItsSides()
    {   return sides;
    }
    
    public String toString()
    {   return "d" + sides;
    }
    
    public int roll()
    {   return (int) ((Math.random() * sides) + 1);
    }
    
    public static String multiRoll(int sides, int amount)
    {   Dice d = new Dice(sides);
        String s = "";
        for(int i = 0; i < amount; i++)
        {   int k = d.roll();
            if(i == amount - 1)
            {   System.out.print(k);
                s += "" + k;
            }
            else 
            {   System.out.print(k + ", ");
                s += k + ", ";
            }
        }
        return s.substring(0, s.length());
    }
    
    public int[] multiRoll(int amount)
    {   Dice d = new Dice(sides);
        int[] j = new int[amount];
        for(int i = 0; i < amount; i++)
        {   int k = d.roll();
            if(i == amount - 1)
            {   System.out.print(k);
            }
            else 
            {   System.out.print(k + ", ");
            }
            j[i] = k;
        }
        return j;
    }
}