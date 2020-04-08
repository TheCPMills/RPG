package main;
import java.util.*;

/**
 * @author Chase P. Miller
 * @version Version 
 * @since
 */  

public class Utilities
{   public static <T> boolean inArr(T[] arr, T i)
    {   return indexOf(arr, i) >= 0 ? true : false;
    }
    
    public static <T> boolean inList(List<T> lst, T i)
    {   return indexOf(lst, i) >= 0 ? true : false;
    }
    
    public static <T> int indexOf(T[] arr, T o)
    {   for(int j = 0; j < arr.length; j++)
        {   if(o.toString().equals(arr[j].toString()))
            {   return j;
            }
        }
        return -1;
    }
    
    public static <T> int indexOf(List<T> lst, T o)
    {   for(int j = 0; j < lst.size(); j++)
        {   String s = lst.get(j).toString();
            if(o.toString().equals(s))
            {   return j;
            }
        }
        return -1;
    }
    
    public static <T> int nthIndexOf(T[] arr, T o, int i)
    {   int count = 0, result = -1;
        for(int j = 0; j < arr.length && count < i; j++)
        {   if(o.toString().equals(arr[j].toString()))
            {   result = j;
                count++;
            }
        }
        if(count < i)
        {   return -1;
        }
        else
        {   return result;
        }
    }
    
    public static <T> int nthIndexOf(List<T> lst, T o, int i)
    {   int count = 0, result = -1;
        for(int j = 0; j < lst.size() && count < i; j++)
        {   if(o.toString().equals(lst.get(j).toString()))
            {   result = j;
                count++;
            }
        }
        if(count < i)
        {   return -1;
        }
        else
        {   return result;
        }
    }
    
    public static <T> int lastIndexOf(T[] arr, T o)
    {   int result = -1;
        for(int j = 0; j < arr.length; j++)
        {   if(o.toString().equals(arr[j].toString()))
            {   result = j;
            }
        }
        return result;
    }
    
    public static <T> int lastIndexOf(List<T> lst, T o)
    {   int result = -1;
        for(int j = 0; j < lst.size(); j++)
        {   String s = lst.get(j).toString();
            if(o.toString().equals(s))
            {   result = j;
            }
        }
        return result;
    }
    
    public static int binarySearch(List<Comparable> arr, Comparable i)
    {   int count = 0;
        int lowerBound = 0;
        int upperBound = arr.size() - 1;
        while(lowerBound < upperBound)
        {   int mid = (lowerBound + upperBound) / 2;
            if(arr.get(mid).compareTo(i) < 0)
            {   lowerBound = mid + 1;
            }
            else
            {   upperBound = mid;
            }
            count++;
        }
        count++;
        if(arr.get(lowerBound) == i)
        {   return lowerBound;
        }
        return -1;
    }
    
    public static int binarySearch(Comparable [] arr, Comparable i)
    {   int count = 0;
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        while(lowerBound < upperBound)
        {   int mid = (lowerBound + upperBound) / 2;
            if(arr[mid].compareTo(i) < 0)
            {   lowerBound = mid + 1;
            }
            else
            {   upperBound = mid;
            }
            count++;
        }
        count++;
        if(arr[lowerBound] == i)
        {   return lowerBound;
        }
        return -1;
    }
}