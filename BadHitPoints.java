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

public class BadHitPoints extends ArrayList<BadHitPoint> implements HitPoints
{   Evil Char;
    String charName;
    int itsIrradiatedPoints;
    int firstUnirradiated;
    BadHitPoints(Evil character)
    {   Char = character;
        charName = character.itsName;
        int siz = new Dice(20).roll() + 5;
        for(int i = 0; i < siz; i++)
        {   add(new BadHitPoint());
        }
        updateStats();
    }

    public void levelUp(int i)
    {   int j = size() - 1;
        for(int k = 0; k < j - 1; k++)
        {   get(k).setHealthy();
        }
        int b = (int) ((i * 1.5) + 0.5);
        for(; b > 0; b--)
        {   add(firstUnirradiated, new BadHitPoint());
        }
        updateStats();
    }

    public void addHealth()
    {   int i = Utilities.indexOf(this, new BadHitPoint(State.Unirradiated));
        if(i != -1)
        {   get(i).setHealthy();
        }
        updateStats();
    }

    public void loseHealth()
    {   int i = Utilities.lastIndexOf(this, new BadHitPoint(State.Irradiated));
        if(i != -1)
        {   get(i).setUnhealthy();
        }
        updateStats();
    }

    void updateStats()
    {   itsIrradiatedPoints = 0;
        firstUnirradiated = size();
        int j = 0;
        for(BadHitPoint hP : this)
        {   if(hP.isHealthy())
            {   itsIrradiatedPoints++;
            }

            else if(firstUnirradiated == size())
            {   firstUnirradiated = j;
            }
            j++;
        }
    }

    public void displayHealthBar()
    {   BadHealthBar rects = new BadHealthBar(this);
        JFrame frame = new JFrame(charName + "'s Health Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(560, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
class BadHitPoint
{   private boolean itsHealth;
    BadHitPoint()
    {   setHealthy();
    }

    BadHitPoint(State s)
    {   if(s.toString().equals("Unirradiated"))
        {   setUnhealthy();
        }
        else if(s.toString().equals("Irradiated"))
        {   setHealthy();
        }
    }
    
    boolean isHealthy()
    {   return itsHealth;
    }

    void setHealthy()
    {   itsHealth = true;
    }

    void setUnhealthy()
    {   itsHealth = false;
    }

    public String toString()
    {   if(itsHealth)
        {   return "Irradiated Hit Point";
        }
        else
        {   return "Unirradiated Hit Point";
        }
    }
}