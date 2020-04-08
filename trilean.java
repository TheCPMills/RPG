package dlc;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import tools.*;
import builder.*;
import character.*;
import main.*;

/**
 * @version Version
 * @since 
 */

public class trilean {
    String[] values = new String[3];
    int activeValue;
    public trilean(String value1, String value2, String value3, int active) {
        values[0] = value1;
        values[1] = value2;
        values[2] = value3;
        activeValue = active;
    }
    
    public String toString() {
        return values[activeValue - 1];
    }
    
    public void updateActiveValue(int newActive) {
        activeValue = newActive;
    }
}