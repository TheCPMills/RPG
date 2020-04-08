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

public class Alien extends Evil
{   public Alien(Titan c)
    {   super(c);
    }
    
    public Alien()
    {   
    }
    
    public void displayProfile()
    {   AlienProfile m = new AlienProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? 2 : 4;
    }
}
class AlienProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("alien.png");  
        g.drawImage(i, 0,0,this); 
    }
}  