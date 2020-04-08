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

public class BadHealthBar extends JPanel
{   private final BadHitPoints hP;
    private final int x = 30;
    private final int y = 40;
    private final int w = 500;
    private final int h = 20;
    BadHealthBar(BadHitPoints hitPoints)
    {   hP =  hitPoints;
    }

    protected void paintComponent(Graphics g)
    {   super.paintComponent(g);
        int health = ((int) (500.0 * hP.itsIrradiatedPoints / hP.size()));
        g.drawRect(x,y,w,h);
        g.setColor(Color.RED);
        g.fillRect(x,y,w,h);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x + health,y,w - health,h);
        g.setColor(Color.BLACK);
        g.drawString("HP: " + hP.itsIrradiatedPoints + "/" + hP.size(), 100, 80);
        g.drawString("AP: " + hP.Char.itsArmourClass, 350, 80);
        g.drawString("Level: " + hP.Char.itsLevel, 100, 30);
        g.drawString("Experience: " + hP.Char.itsExperience, 350, 30);
    }
}