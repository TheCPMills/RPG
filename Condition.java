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

public enum Condition
{   Ageusia, Akathisia, Amnesia, Anosmia, Aphasia, Asphyxia, Asthenia, Ataxia, Agnosia, Blindness, Darkvision, Deafness, Enhanced_Leaping, Enraged, Fatigue, Healing, Hunger, Insomnia, Levitation, Paralysis, Psychosis, Poison, Radioactivity, Slowness, Speed, Stunned;
    public String toString()
    {   if(this == Enhanced_Leaping)
        {   return "Enhanced Leaping";
        }
        else
        {   return super.toString();
        }
    }
}