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

public class Skill extends Union<Skills, Integer>
{   public Skill(Skills s, int p)
    {   super(s, (int) ((p / 20.0) * 100));
    }
    
    public Skills getItsSkill()
    {   return firstElement();
    }

    public int getItsPoints()
    {   return secondElement();
    }
}
enum Skills
{   Survival, Athletics, Diplomacy, Investigation, Stealth, Tinkering;
    public static Skills getSkill(int i)
    {   return i == 0 ? Survival : i == 1 ? Athletics : i == 2 ? Diplomacy : i == 3 ? Investigation : i == 4 ? Stealth : Tinkering;
    }
}