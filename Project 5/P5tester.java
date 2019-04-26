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
  // Test Contact task
  @Test 
  public void testToString() {
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    assertEquals("Arthur Moddy, email: est@temp.com, phone: 703­555­5555.",c.toString());
  }
  //Test phone book utils task
  @Test
  public void testMapToString(){
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("x",1); map.put("y",2); map.put("z",3);
    assertEquals("1\n2\n3\n", PhoneBookUtils.mapToString(map));
  }

  Integer[] ints = { 3, 8, 5, 4, 1, 9, -2};
  List<Integer> intList = new ArrayList<Integer>(Arrays.asList(ints));
  String[] strs = { "Hhh", "Ccc", "Fff", "Ttt", "Aaa", "Ddd" };
  List<String> strList = new ArrayList<String>(Arrays.asList(strs));

  @Test 
  public void testListToSortedList0(){
    assertEquals("-2\n1\n3\n4\n5\n8\n9\n", PhoneBookUtils.listToSortedList(intList));
  }

@Test 
  public void testListToSortedList1(){
    assertEquals("Aaa\nCcc\nDdd\nFff\nHhh\nTtt\n", PhoneBookUtils.listToSortedList(strList));
  }

  // @Test 
  // public void testInsertionSort0(){
  //   assertEquals("[-2, 1, 3, 4, 5, 8, 9]", java.util.Arrays.toString(ints));
  // }

  @Test 
  public void testPhoneBookUtils_binarySearch0(){
    Integer expected = 9;
    assertEquals(expected, PhoneBookUtils.binarySearch(ints, 0, ints.length, 9));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch1(){
    Integer expected = null;
    assertEquals(expected, PhoneBookUtils.binarySearch(ints, 0, ints.length, 45));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch2(){ //Test out of range end point
    Integer expected = 9;
    assertEquals(expected, PhoneBookUtils.binarySearch(ints, 0, 20, 9));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch3(){ 
    String expected = "Fff";
    assertEquals(expected, PhoneBookUtils.binarySearch(strs, 0, strs.length, "Fff"));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch4(){ 
    String expected = null;
    assertEquals(expected, PhoneBookUtils.binarySearch(strs, 0, strs.length, "Bebe"));
  }

  // Test PhoneBook task
  // @Test
  // public void testFileToMap() {
  //   PhoneBook blackbook = new PhoneBook(); 
  //   blackbook.fileToMap("contacts.txt");
  //   System.out.println(blackbook.getContactList());
  //   String [] tempArr = blackbook.getContactList().split("\n");
	// Set<String> actualSet = new HashSet<String>(Arrays.asList(tempArr));
  //   Set<String> expectedSet = new HashSet<String>(Arrays.asList(new String[]{
  //       "Wing Mcbride, email: vehicula.risus.Nulla@Nuncsollicitudincommodo.net, phone: 1-142-956-2408.",
  //       "Lawrence Garcia, email: diam@amagna.ca, phone: 1-665-672-6398.",
  //       "Brielle Richardson, email: nisl@semNulla.com, phone: 1-803-813-0239.",
  //       "Baxter Cantu, email: arcu.iaculis@iaculis.net, phone: 1-606-427-1676.",
  //       "Madonna Potter, email: sollicitudin@Nullamvitaediam.edu, phone: 1-116-362-9565.",
  //       "Xenos Cardenas, email: dui.in@lectus.org, phone: 1-947-140-2672.",
  //       "Petra Williamson, email: euismod.in@convallisligulaDonec.co.uk, phone: 1-352-344-9237.",
  //       "Marvin Castro, email: orci.Ut@Nuncquis.com, phone: 1-340-704-1258.",
  //       "Arthur Moody, email: est@temporerat.com, phone: 1-170-451-6998.",
  //       "Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073."}));

	// 	assertEquals("loaded file contents do not match expected contents", expectedSet, actualSet);
  // }

}