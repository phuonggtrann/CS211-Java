import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class P5tester {
 
  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("P5tester");
  }
  @Test 
  public void testContact_toString() {
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    assertEquals("Arthur Moddy, email: est@temp.com, phone: 703­555­5555.",c.toString());
  }
  
  @Test
  public void testPhoneBookUtils_mapToString(){
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("x",1); map.put("y",2); map.put("z",3);
    assertEquals("1\n2\n3\n", PhoneBookUtils.mapToString(map));
  }

  @Test 
  public void testPhoneBookUtils_listToSortedList(){
    Integer[] ints = { 3, 8, 5, 4, 1, 9, -2};
    List<Integer> intList = new ArrayList<Integer>(Arrays.asList(ints));
    assertEquals("-2\n1\n3\n4\n5\n8\n9\n", PhoneBookUtils.listToSortedList(intList));
  }
}