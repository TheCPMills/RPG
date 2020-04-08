package tools;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import main.*;
import builder.*;
import character.*;

/**
 * AP CSA 2017-18
 * @author Chase P. Miller
 * @version Version 
 * @since
 */  

public class Fist extends main.Weapon
{   public Fist() throws IllegalEnumException
    {   super("Fist", - (int) (Math.random() + 0.5), Convert.toRarity("Common"), DamageType.Bludgeoning, 6);
    }
    
    public int damage()
    {   return getItsDie().roll() + getItsDamage();
    }
}