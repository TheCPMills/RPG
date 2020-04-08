package main;
import java.util.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since
 */

public class Sort
{   
    static int size = 0;
    private static <T> void printArr(T[] i)
    {   System.out.print("[" + i[0]);
        for(int j = 1; j < i.length; j++)
        {   System.out.print(", " + i[j]);
        }
        System.out.print("]\n");
    }
    
    public static <T> void bubbleSort(T[] i)
    {   printArr(i);
        int n = i.length;
        for(int j = 0; j < n - 1; j++)
        {   for(int k = 0; k < n - j - 1; k++)
            {   if(((Comparable) (i[k])).compareTo(i[k + 1]) > 0)
                {   T temp = i[k];
                    i[k] = i[k + 1];
                    i[k + 1] = temp;
                }
            }
        }
        printArr(i);
    }

    public static <T> void bubbleSort(List<T> i)
    {   System.out.println(i);
        int n = i.size();
        for(int j = 0; j < n - 1; j++)
        {   for(int k = 0; k < n - j - 1; k++)
            {   if(((Comparable) (i.get(k))).compareTo(i.get(k + 1)) > 0)
                {   T temp = i.get(k);
                    i.set(k, i.get(k + 1));
                    i.set(k + 1, temp);
                }
            }
        }
        System.out.println(i);
    }
    
    public static <T> void insertionSort(T[] i)
    {   printArr(i);
        int n = i.length; 
        for(int j = 1; j < n; ++j) 
        {   T key = i[j];
            int k = j - 1;
            while(k >= 0 && ((Comparable) (i[k])).compareTo(key) > 0) 
            {   i[k + 1] = i[k];
                k = k - 1; 
            } 
            i[k + 1] = key;
        } 
        printArr(i);
    }
    
    public static <T> void insertionSort(List<T> i)
    {   System.out.println(i);
        int n = i.size(); 
        for(int j = 1; j < n; ++j) 
        {   T key = i.get(j);
            int k = j - 1;
            while(k >= 0 && ((Comparable) (i.get(k))).compareTo(key) > 0) 
            {   i.set(k + 1, i.get(k));
                k = k - 1; 
            } 
            i.set(k + 1, key);
        } 
        System.out.println(i);
    }
    
    public static <T> void shellSort(T[] i) 
    {   printArr(i);
        int n = i.length;
        for(int gap = n / 2; gap > 0; gap /= 2) 
        {   for(int j = gap; j < n; j++) 
            {   T temp = i[j];
                int k;
                for(k = j; k >= gap && ((Comparable) (i[k - gap])).compareTo(temp) > 0; k -= gap) 
                {   i[k] = i[k - gap];
                }
                i[k] = temp;
            } 
        } 
        printArr(i);
    }
    
    public static <T> void shellSort(List<T> i) 
    {   System.out.println(i);
        int n = i.size();
        for(int gap = n / 2; gap > 0; gap /= 2) 
        {   for(int j = gap; j < n; j++) 
            {   T temp = i.get(j);
                int k;
                for(k = j; k >= gap && ((Comparable) (i.get(k - gap))).compareTo(temp) > 0; k -= gap) 
                {   i.set(k, i.get(k - gap));
                }
                i.set(k, temp);
            } 
        } 
        System.out.println(i);
    }
    
    public static <T> void selectionSort(T[] i) 
    {   System.out.println(i);
        int n = i.length;
        for(int j = 0; j < n - 1; j++) 
        {   int min = j; 
            for(int k = j + 1; k < n; k++) 
            {   if(((Comparable) (i[k])).compareTo(i[min]) < 0) 
                {   min = k;
                }
            }
            T temp = i[min]; 
            i[min] = i[j]; 
            i[j] = temp; 
        }
        System.out.println(i);
    }
    
    public static <T> void selectionSort(List<T> i) 
    {   System.out.println(i);
        int n = i.size();
        for(int j = 0; j < n - 1; j++) 
        {   int min = j; 
            for(int k = j + 1; k < n; k++) 
            {   if(((Comparable) (i.get(k))).compareTo(i.get(min)) < 0) 
                {   min = k;
                }
            }
            T temp = i.get(min); 
            i.set(min, i.get(j)); 
            i.set(j, temp); 
        }
        System.out.println(i);
    }
    
    public static <T> void mergeSort(T[] i)
    {   if(size == 0)
        {   System.out.println(i);
            size = i.length;
        }
        if(i == null) 
        {   return; 
        } 
        if(i.length > 1) 
        {   int mid = i.length / 2;
            Object[] left = new Object[mid]; 
            for(int j = 0; j < mid; j++) 
            {   left[j] = i[j]; 
            }
            Object[] right = new Object[i.length - mid]; 
            for(int j = mid; j < i.length; j++) 
            {   right[j - mid] = i[j]; 
            } 
            mergeSort(left); 
            mergeSort(right);
            int l = 0, j = 0, k = 0;
            while(l < left.length && j < right.length) 
            {   if(((Comparable) (left[l])).compareTo(right[j]) < 0) 
                {   i[k] = (T) (left[l]); 
                    l++; 
                } 
                else
                {   i[k] = (T) (right[j]); 
                    j++; 
                } 
                k++; 
            } 
            while(l < left.length) 
            {   i[k] = (T) (left[l]); 
                l++; 
                k++; 
            } 
            while(j < right.length) 
            {   i[k] = (T) (right[j]); 
                j++; 
                k++; 
            } 
        }
        if(size == i.length)
        {   System.out.println(i);
            size = 0;
        }
    }
    
  public static <T> void mergeSort(List<T> i)
    {   if(size == 0)
        {   System.out.println(i);
            size = i.size();
        }
        if(i == null) 
        {   return; 
        } 
        if(i.size() > 1) 
        {   int mid = i.size() / 2;
            List<T> left = new ArrayList<T>(), right = new ArrayList<T>(); 
            for(int j = 0; j < mid; j++) 
            {   left.add(j, i.get(j)); 
            }
            for(int j = mid; j < i.size(); j++) 
            {   right.add(j - mid, i.get(j)); 
            } 
            mergeSort(left); 
            mergeSort(right);
            int l = 0, j = 0, k = 0;
            while(l < left.size() && j < right.size()) 
            {   if(((Comparable) (left.get(l))).compareTo(right.get(j)) < 0) 
                {   i.set(k, left.get(l)); 
                    l++; 
                } 
                else
                {   i.set(k, right.get(j)); 
                    j++; 
                } 
                k++; 
            } 
            while(l < left.size()) 
            {   i.set(k, left.get(l)); 
                l++; 
                k++; 
            } 
            while(j < right.size()) 
            {   i.set(k, right.get(j)); 
                j++; 
                k++; 
            } 
        }
        if(size == i.size())
        {   System.out.println(i);
            size = 0;
        }
    }
    
    public static <T> void quickSort(T[] i)
    {   printArr(i);
        i = qsort(i, 0, i.length - 1);
        printArr(i);
    }
    
    public static <T> void quickSort(List<T> i)
    {   System.out.println(i);
        i = qsort(i, 0, i.size() - 1);
        System.out.println(i);
    }
    
    public static <T> void heapSort(T i[])
    {   printArr(i);
        int n = i.length;
        for (int j = n / 2 - 1; j >= 0; j--)
        {   heapify(i, n, j);
        }
        for (int j = n - 1; j >= 0; j--)
        {   T temp = i[0];
            i[0] = i[j];
            i[j] = temp;
            heapify(i, j, 0);
        }
        printArr(i);
    }
    
    public static <T> void heapSort(List<T> i)
    {  System.out.println(i);
        int n = i.size();
        for (int j = n / 2 - 1; j >= 0; j--)
        {   heapify(i, n, j);
        }
        for (int j = n - 1; j >= 0; j--)
        {   T temp = i.get(0);
            i.set(0, i.get(j));
            i.set(j, temp);
            heapify(i, j, 0);
        }
        System.out.println(i);
    }
 
    //Resources for Quick Sort
    private static <T> int partition(T arr[], int low, int high)
    {   T pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {   if(((Comparable) (arr[j])).compareTo(pivot) <= 0)
            {   i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    private static <T> int partition(List<T> lst, int low, int high)
    {   T pivot = lst.get(high);
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {   if(((Comparable) (lst.get(j))).compareTo(pivot) <= 0)
            {   i++;
                T temp = lst.get(i);
                lst.set(i, lst.get(j));
                lst.set(j, temp);
            }
        }
        T temp = lst.get(i + 1);
        lst.set(i + 1, lst.get(high));
        lst.set(high, temp);
        return i + 1;
    }

    private static <T> T[] qsort(T arr[], int low, int high)
    {   if(low < high)
        {   int pi = partition(arr, low, high);
            qsort(arr, low, pi - 1);
            qsort(arr, pi + 1, high);
        }
        return arr;
    }
    
    private static <T> List<T> qsort(List<T> lst, int low, int high)
    {   if(low < high)
        {   int pi = partition(lst, low, high);
            qsort(lst, low, pi - 1);
            qsort(lst, pi + 1, high);
        }
        return lst;
    }

    // Resources for Heap Sort
    private static <T> void heapify(T arr[], int n, int i)
    {   int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && ((Comparable) (arr[l])).compareTo(arr[largest]) > 0)
        {   largest = l;
        }
        if (r < n && ((Comparable) (arr[r])).compareTo(arr[largest]) > 0)
        {   largest = r;
        }
        if (largest != i)
        {   T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    
    private static <T> void heapify(List<T> lst, int n, int i)
    {   int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && ((Comparable) (lst.get(l))).compareTo(lst.get(largest)) > 0)
        {   largest = l;
        }
        if (r < n && ((Comparable) (lst.get(r))).compareTo(lst.get(largest)) > 0)
        {   largest = r;
        }
        if (largest != i)
        {   T swap = lst.get(i);
            lst.set(i, lst.get(largest));
            lst.set(largest, swap);
            heapify(lst, n, largest);
        }
    }
}