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

public class Cyborg extends Evil
{   public Cyborg(Golem e)
    {   super(e);
    }
    
    public Cyborg()
    {   
    }
    
    public void displayProfile()
    {   CyborgProfile m = new CyborgProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public int setItsSizeModifier()
    {   return 0;
    }
}
class GhoulProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("cyborg.png");  
        g.drawImage(i, 0,0,this); 
    }
}  