package builder;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import tools.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public interface HitPoints
{   public void levelUp(int i);

    public void addHealth();

    public void loseHealth();

    public int size();

    public void displayHealthBar();
}