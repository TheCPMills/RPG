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

public class Titan extends Good
{   public Titan
()
    {   
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? 2 : 4;
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
        {   Evil evil = new Alien(this);
            return evil;
        }
        return null;
    }
}
class TitanProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("titan.png");  
        g.drawImage(i, 0,0,this); 
    }
}  