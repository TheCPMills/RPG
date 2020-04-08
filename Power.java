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

public enum Power
{   Survival, Athletics, Diplomacy, Investigation, Stealth, Tinkering;
    public static Power getPower(int i)
    {   return i == 0 ? Survival : i == 1 ? Athletics : i == 2 ? Diplomacy : i == 3 ? Investigation : i == 4 ? Stealth : Tinkering;
    }
}