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

public class Orc extends Evil
{   public Orc(Tiefling d)
    {   super(d);
    }
    
    public Orc()
    {   
    }
    
    public void displayProfile()
    {   OrcProfile m = new OrcProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? -2 : -1;
    }
}
class OrcProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("orc.png");  
        g.drawImage(i, 0,0,this); 
    }
}  