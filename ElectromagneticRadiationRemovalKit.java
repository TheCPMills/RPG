package tools;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import builder.*;
import character.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */
public class ElectromagneticRadiationRemovalKit extends Equipment
{   public ElectromagneticRadiationRemovalKit(int amount) throws IllegalEnumException
    {   super("ERR Kit", amount, main.Rarity.Rare.toString());
    }
    
    public int removeRadiation()
    {   return new Dice(6).roll();
    }
}