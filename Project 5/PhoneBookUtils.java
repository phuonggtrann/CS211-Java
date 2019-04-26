import java.util.*;

public final class PhoneBookUtils {
    public static <KeyType, ValueType> String mapToString(Map<KeyType, ValueType> map) {
        String s = "";
        // Collection c = map.values();
        for (ValueType col : map.values()) {
            s = s + col.toString() + "\n";
        }
        return s;
    }

    public static <T extends Comparable<T>> String listToSortedList(List<T> list) {
        String s = "";
        Collections.sort(list);
        for (T t : list) {
            s = s + t.toString() + "\n";
        }
        return s;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr, int i) {

        if (i >= arr.length - 1) {
            return;
        }
        int index = i + 1;
        T temp = arr[index];
        while (index > 0 && arr[index].compareTo(arr[index - 1]) < 0) {
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            index--;
        }
        insertionSort(arr, i + 1);

    }

    public static <T extends Comparable<T>> T binarySearch(T arr[], int begin, int end, T key) {
        T t = null;
        while (begin < end || begin < arr.length) {
            if (arr[begin].compareTo(key) == 0) {
                t = arr[begin];
                break;
            }
            begin++;
        }
        return t;
    }
}