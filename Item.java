package main;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import tools.*;
import builder.*;
import character.*;

/**
 * AP CSA 2017-18
 * @author Chase P. Miller
 * @version Version 
 * @since
 */  

public interface Item
{   public String getItsName();
    public Rarity getItsRarity();
}