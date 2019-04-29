import java.util.*;

public final class PhoneBookUtils {
    public static <KeyType, ValueType> String mapToString(Map<KeyType, ValueType> map) {
        String s = ""; // Create empty String
        for (ValueType col : map.values()) { // go thru every entries in the HashMap 
            s += String.format("%s\n",col.toString());
        }
        return s;
    }

    public static <T extends Comparable<T>> String listToSortedList(List<T> list) {
        String s = "";
        Collections.sort(list); // Invoke sort() method
        for (T t : list) { // go thru and add it to the String like above methods
            s += t.toString() + "\n";
        }
        return s;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr, int i) {
        // if reached the last element of the array, stop
        if (i >= arr.length - 1) { 
            return;
        }
        int index = i + 1; // initialilze index
        T temp = arr[index]; // initialize temp
        while (index > 0 && arr[index].compareTo(arr[index - 1]) < 0) {
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            index--;
        }
        insertionSort(arr, i + 1); // recursive require 

    }

    public static <T extends Comparable<T>> T binarySearch(T[] arr, int begin, int end, T key) {
        int index = (end+begin)/2; // initiazlie starting index
        if (key.compareTo(arr[index])==0) {return arr[index];} // if match found, return object
        if (end-1==begin) {return null;} // if nothing found, return null
        // call method because recursive way of doing 
        if (arr[index].compareTo(key)<0) {return binarySearch(arr,index,end,key);}
        else {return binarySearch(arr,begin,index,key);}
    }

}