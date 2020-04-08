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

public class Tiefling extends Good
{   public Tiefling ()
    {   
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? -4 : -2;
    }
    
    public void displayProfile()
    {   TieflingProfile m = new TieflingProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public Evil evilRevival()
    {   if(Utilities.inList(itsConditions,Condition.Radioactivity))
        {   Evil evil = new Orc(this);
            return evil;
        }
        return null;
    }
}
class TieflingProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("tiefling.png");  
        g.drawImage(i, 0,0,this); 
    }
}  