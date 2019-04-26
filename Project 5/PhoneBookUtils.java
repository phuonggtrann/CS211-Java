import java.util.*;

public final class PhoneBookUtils {
  public static <KeyType, ValueType> String mapToString(Map <KeyType, ValueType> map){
      String s = "";
      //Collection c = map.values();
      for (ValueType col: map.values()) {
          s=s+col.toString()+"\n";
      }
      return s;
  } 
  public static <T extends Comparable<T>> String listToSortedList(List <T> list) {
      String s ="";
      Collections.sort(list);
      for (T t: list) {
          s=s+t.toString()+"\n";
      }
      return s;
  }
  public static <T extends Comparable<T>> void insertionSort(T[] arr, int i) {
      
  }
}