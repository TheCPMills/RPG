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

public class GoodHealthBar extends JPanel
{   private final GoodHitPoints hP;
    private final int x = 30;
    private final int y = 40;
    private final int w = 500;
    private final int h = 20;
    GoodHealthBar(GoodHitPoints hitPoints)
    {   hP =  hitPoints;
    }

    protected void paintComponent(Graphics g)
    {   super.paintComponent(g);
        int health = ((int) (500.0 * hP.itsHealthPoints / hP.size()));
        int unhealth = ((int) (500.0 * (hP.size() - hP.itsHealthPoints - hP.itsRadioactivePoints) / hP.size()));
        g.drawRect(x,y,w,h);
        g.setColor(Color.GREEN);
        g.fillRect(x,y,w,h);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x + health,y,w - health,h);
        g.setColor(Color.RED);
        g.fillRect(x + health + unhealth,y,w - health - unhealth,h);
        g.setColor(Color.BLACK);
        g.drawString("HP: " + hP.itsHealthPoints + "/" + hP.size(), 45, 80);
        g.drawString("RP: " + hP.itsRadioactivePoints + "/" + hP.size(), 180, 80);
        g.drawString("FP: " + ((Good) (hP.Char)).itsFatiguePoints + "/100", 315, 80);
        g.drawString("AP: " + hP.Char.itsArmourClass, 450, 80);
        g.drawString("Level: " + hP.Char.itsLevel, 100, 30);
        g.drawString("Experience: " + hP.Char.itsExperience, 350, 30);
    }
}