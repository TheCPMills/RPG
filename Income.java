package main;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import tools.*;
import builder.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public enum Income
{   Affluent, UpMid, LowMid, Working, Poverty;
    public String toString()
    {   if(this == UpMid)
        {   return "Upper Middle";
        }
        else if(this == LowMid)
        {   return "Lower Middle";
        }
        else
        {   return super.toString();
        }
    }
    
    public static int getStartingMoney(Income income)
    {   switch(income)
        {   case Affluent: return (int) (Math.random() * 99 + 0.5) + 90;
            case UpMid: return (int) (Math.random() * 79 + 0.5) + 70;
            case LowMid: return (int) (Math.random() * 59 + 0.5) + 50;
            case Working: return (int) (Math.random() * 39 + 0.5) + 30;
            case Poverty: return (int) (Math.random() * 19 + 0.5) + 10;
        }
        return -1;
    }
}