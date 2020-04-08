package character;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import tools.*;
import builder.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Troll extends Evil
{   public Troll(Fairy h)
    {   super(h);
    }
    
    public Troll()
    {   
    }
    
    public void displayProfile()
    {   TrollProfile m = new TrollProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? 1 : 2;
    }
}
class TrollProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("troll.png");  
        g.drawImage(i, 0,0,this); 
    }
}  