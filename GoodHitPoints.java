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

public class GoodHitPoints extends ArrayList<GoodHitPoint> implements HitPoints
{   public Good Char;
    public String charName;
    public int itsHealthPoints;
    public int itsRadioactivePoints;
    public int firstUnhealthy;
    public int firstRadiation;
    GoodHitPoints(Good character)
    {   Char = character;
        charName = character.itsName;
        int siz = new Dice(20).roll() + 5;
        for(int i = 0; i < siz; i++)
        {   add(new GoodHitPoint());
        }
        updateStats();
    }

    public void levelUp(int i)
    {   int j = size() - 1;
        while(j > -1 && get(j).isRadioactive())
        {   j--;
        }
        for(int k = 0; k < j - 1; k++)
        {   get(k).setHealthy();
        }
        for(; i > 0; i--)
        {   add(j - 1, new GoodHitPoint());
        }
    }

    public void addHealth()
    {   int i = Utilities.indexOf(this, new GoodHitPoint(State.Unhealthy));
        if(i != -1)
        {   get(i).setHealthy();
        }
        updateStats();
    }

    public void loseHealth()
    {   int i = Utilities.lastIndexOf(this, new GoodHitPoint(State.Healthy));
        if(i != -1)
        {   get(i).setUnhealthy();
        }
        updateStats();
    }

    void addRadiation()
    {   int i = Utilities.lastIndexOf(this,new GoodHitPoint(State.Unhealthy));
        if(i != -1)
        {   get(i).setRadioactive();
        }
        updateStats();
    }

    void loseRadiation()
    {   int i = Utilities.indexOf(this, new GoodHitPoint(State.Irradiated));
        if(i != -1)
        {   get(i).setUnhealthy();
        }
        updateStats();
    }

    void updateStats()
    {   itsHealthPoints = 0;
        itsRadioactivePoints = 0;
        firstUnhealthy = size();
        firstRadiation = size();
        int j = 0;
        for(GoodHitPoint hP : this)
        {   if(hP.isHealthy())
            {   itsHealthPoints++;
            }
            else if(hP.isRadioactive())
            {   if(firstRadiation == size())
                {   firstRadiation = j;
                }
                itsRadioactivePoints++;
            }
            else if(firstUnhealthy == size())
            {   firstUnhealthy = j;
            }
            j++;
        }
    }

    public String toString()
    {   for(int i = 0; i < size(); i++)
        {   String r = get(i).toString();
            if(r == "Healthy Hit Point")
            {   System.out.print("*");
            }
            else if(r == "Radioactive Hit Point")
            {   System.out.print("#");
            }
            else
            {   System.out.print("_");
            }
        }
        System.out.println();
        return "Done";
    }

    public void displayHealthBar()
    {   GoodHealthBar rects = new GoodHealthBar(this);
        JFrame frame = new JFrame(charName + "'s Health Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(560, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
class GoodHitPoint
{   private boolean itsHealth;
    private boolean itsRadioactive;
    GoodHitPoint()
    {   setHealthy();
    }
    
    GoodHitPoint(State s)
    {   if(s.toString().equals("Unhealthy"))
        {   setUnhealthy();
        }
        else if(s.toString().equals("Irradiated"))
        {   setRadioactive();
        }
        else if(s.toString().equals("Healthy"))
        {   setHealthy();
        }
    }

    boolean isHealthy()
    {   return itsHealth;
    }

    boolean isRadioactive()
    {   return itsRadioactive;
    }

    void setHealthy()
    {   itsHealth = true;
        itsRadioactive = false;
    }

    void setUnhealthy()
    {   itsHealth = false;
        itsRadioactive = false;
    }

    void setRadioactive()
    {   if(!itsHealth)
        {   itsRadioactive = true;
        }
    }

    public String toString()
    {   if(itsHealth)
        {   return "Healthy Hit Point";
        }
        else if(itsRadioactive)
        {   return "Irradiated Hit Point";
        }
        else
        {   return "Unhealthy Hit Point";
        }
    }
}