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

public class Dwarf extends Evil
{   public Dwarf(Giant g)
    {   super(g);
    }
    
    public Dwarf()
    {   
    }
    
    public void displayProfile()
    {   DwarfProfile m = new DwarfProfile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
    
    public int setItsSizeModifier()
    {   int i = (int) (Math.random() + 0.5);
        return i % 2 == 0 ? 4 : 8;
    }
}
class DwarfProfile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("dwarf.png");  
        g.drawImage(i, 0,0,this); 
    }
}  