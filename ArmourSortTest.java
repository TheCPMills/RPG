import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import main.*;
import tools.*;

/**
 * @version Version
 * @since 
 */

public class ArmourSortTest {
   public static void main() throws IllegalEnumException {
       java.util.List<Armour> s = new ArrayList<Armour>();
       Armour a = new Armour("A", 1, "Common", "Leggings");
       Armour b = new Armour("B", 1, "Common", "Tunic");
       Armour c = new Armour("C", 1, "Common", "Footwear");
       Armour d = new Armour("D", 1, "Common", "Headgear");
       Armour e = new Armour("E", 1, "Common", "Trinket");
       Armour f = new Armour("F", 1, "Common", "Accessory");
       Armour g = new Armour("G", 1, "Common", "Spectacles");
       s.add(a);
       s.add(b);
       s.add(c);
       s.add(d);
       s.add(e);
       s.add(f);
       s.add(g);
       Sort.heapSort(s);
    }

    public static void main(String[] args) {
        try {
            main();
        }
        catch(IllegalEnumException ex) {

        }
    }
}