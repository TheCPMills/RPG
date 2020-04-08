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

public class Elf extends Good
{   public Elf()
    {   
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? -1 : 0;
    }
    
    public void displayProfile()
    {   ElfProfile m = new ElfProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400, 637);  
        f.setVisible(true);  
    }
    
    public Evil evilRevival()
    {   if(Utilities.inList(itsConditions,Condition.Radioactivity))
        {   Evil evil = new Goblin(this);
            return evil;
        }
        return null;
    }
}
class ElfProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("elf.png");  
        g.drawImage(i, 0,0,this); 
    }
}  