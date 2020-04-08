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

public abstract class UniversalCharacter
{   public String itsName;
    public java.util.List<Equipment> itsEquipment = new ArrayList<Equipment>();
    public java.util.List<Weapon> itsWeapons = new ArrayList<main.Weapon>();
    public java.util.List<Condition> itsConditions = new ArrayList<main.Condition>();
    public Armour[] itsArmour = new Armour[7];
    public java.util.List<Armour> itsExtraArmour = new ArrayList<Armour>();
    public int itsArmourClass = 0;
    public boolean isAlive = true;
    public abstract void addCondition(String s);
    
    public abstract void loseHitPoints(int i);
    
    public abstract void addHitPoints(int i);
    
    public abstract void attack(Item item, UniversalCharacter c);
    
    public void give(Item item, int a, builder.Character c) throws IllegalEnumException
    {   if(isAlive)
        {   if(item.getClass().getSuperclass().toString().equals("class main.Weapon") && itsWeapons.contains(item))
            {   c.addWeapon(itsWeapons.remove(itsWeapons.indexOf(item)));
            }
            else if((item.getClass().getSuperclass().toString().equals("class tools.Equipment") || item.getClass().toString().equals("class Equipment")) && itsEquipment.contains(item))
            {   Equipment e = itsEquipment.get(itsEquipment.indexOf(item));
                int o = e.getItsAmount();
                if(o >= a)
                {   Equipment q;
                    if(item.getClass().toString().equals("class Potion"))
                    {   q = new Potion(item.getItsName(), a, ((Potion) (item)).getItsRarity().toString(), Convert.toStringArray(((Potion) (item)).inflict()));
                    }
                    else if(item.getClass().toString().equals("class Ration"))
                    {   q = new Ration(a);
                    }
                    else if(item.getClass().toString().equals("ElectromagneticRadiationRemovalKit"))
                    {   q = new ElectromagneticRadiationRemovalKit(a);
                    }
                    else
                    {   q = new Equipment(item.getItsName(), a, ((Equipment) (item)).getItsRarity().toString());
                    }
                    c.addEquipment(q);
                    for(; a > 0; a--)
                    {   e.decrementItsAmount();
                    }
                }
            }
        }
    }
    
    public void dress(Armour a)
    {   if(isAlive)
        {   if(a != null)
            {   switch(a.itsArmourType)
                {   case Headgear:
                    dressAid(a, 0);
                    break;
                    case Spectacles:
                    dressAid(a, 1);
                    break;
                    case Tunic:
                    dressAid(a, 2);
                    break;
                    case Trinket:
                    dressAid(a, 3);
                    break;
                    case Leggings:
                    dressAid(a, 4);
                    break;
                    case Footwear:
                    dressAid(a, 5);
                    break;
                    case Accessory:
                    dressAid(a, 6);
                    break;
                }
            }
        }
    }
    
    public void addArmour(Armour a) {
        if(isAlive) {
            itsExtraArmour.add(a);
            sortArmour();
        }
    }
     
    public void sortArmour() {
        if(isAlive) {
            Sort.heapSort(itsExtraArmour);
        }
    }

    public void removeArmour(Armour a)
    {   if(isAlive)
        {   changeArmourClass(- a.itsArmourPoints);
            for(main.Condition c : a.itsEffects)
            {   itsConditions.remove(c);
            }
            addArmour(a);
        }
    }

    private void dressAid(Armour a, int i)
    {   if(isAlive)
        {   if(itsArmour[i] != null)
            {   removeArmour(itsArmour[i]);
            }
            itsArmour[i] = a;
            changeArmourClass(a.itsArmourPoints);
            for(main.Condition c : a.itsEffects)
            {   addCondition(c.toString());
            }
        }
    }
    
    public void changeArmourClass(int i)
    {   if(isAlive)
        {   itsArmourClass += i;
        }
    }
}