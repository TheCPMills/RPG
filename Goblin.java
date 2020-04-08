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

public class Goblin extends Evil
{   public Goblin(Elf h)
    {   super(h);
    }
    
    public Goblin()
    {   
    }
    
    public void displayProfile()
    {   GoblinProfile m = new GoblinProfile();  
        JFrame f = new JFrame();
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? -8 : -4;
    }
}
class GoblinProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("goblin.png");  
        g.drawImage(i, 0,0,this); 
    }
}  