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

public class Zombie extends Evil
{   public Zombie(Human h)
    {   super(h);
    }
    
    public Zombie()
    {   
    }
    
    public void displayProfile()
    {   ZombieProfile m = new ZombieProfile();  
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
class ZombieProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("zombie.png");  
        g.drawImage(i, 0,0,this); 
    }
}  