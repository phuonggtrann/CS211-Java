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
  @Test 
  public void testGetName00() {
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    assertEquals("Arthur Moddy",c.getName());
  }
  @Test 
  public void testGetEmail00() {
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    assertEquals("est@temp.com",c.getEmail());
  }
  @Test 
  public void testGetPhone00() {
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    assertEquals("703­555­5555",c.getPhone());
  }
  @Test
  public void testCompareTo(){
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    Contact d = new Contact("Brthur Moddy", "est@temp.com", "703­555­5555");
    assertTrue(c.compareTo(d)<0);
  }
  @Test
  public void testCompareTo1(){
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    Contact d = new Contact("Brthur Moddy", "est@temp.com", "703­555­5555");
    assertFalse(c.compareTo(d)>0);
  }
  @Test
  public void testCompareTo2(){
    Contact c = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    Contact d = new Contact("Arthur Moddy", "est@temp.com", "703­555­5555");
    assertTrue(c.compareTo(d)==0);
  }

  //Test phone book utils task
  @Test
  public void testMapToString(){
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("x",1); map.put("y",2); map.put("z",3);
    assertEquals("1\n2\n3\n", PhoneBookUtils.mapToString(map));
  }
  @Test
  public void testMapToStringEmpty(){
    Map<String, Integer> map = new HashMap<String, Integer>();
    assertEquals("", PhoneBookUtils.mapToString(map));
  }

  Integer[] ints = { 3, 8, 5, 4, 1, 9, -2};
  Integer[] intsSorted = {-2,1,3,4,5,8,9};
  Integer[] emptyInts = {};
  List<Integer> emptyList = new ArrayList<Integer>(Arrays.asList(emptyInts));
  List<Integer> intList = new ArrayList<Integer>(Arrays.asList(ints));
  String[] strs = { "Hhh", "Ccc", "Fff", "Ttt", "Aaa", "Ddd" };
  String[] strsSorted = {"Aaa", "Ccc", "Ddd", "Fff", "Hhh", "Ttt"};
  List<String> strList = new ArrayList<String>(Arrays.asList(strs));

  @Test 
  public void testListToSortedList0(){
    assertEquals("-2\n1\n3\n4\n5\n8\n9\n", PhoneBookUtils.listToSortedList(intList));
  }
  @Test 
  public void testListToSortedListEmpty(){
    assertEquals("", PhoneBookUtils.listToSortedList(emptyList));
  }

@Test 
  public void testListToSortedList1(){
    assertEquals("Aaa\nCcc\nDdd\nFff\nHhh\nTtt\n", PhoneBookUtils.listToSortedList(strList));
  }
  @Test
  public void testListToSortedList(){
    String [] strArr = {"F", "B", "Eee", "Xve", "Aba"};
    ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strArr));
    assertEquals("Aba\n"+"B\n"+"Eee\n"+"F\n"+"Xve\n",PhoneBookUtils.listToSortedList(strList));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch0(){
    Integer expected = 9;
    assertEquals(expected, PhoneBookUtils.binarySearch(intsSorted, 0, ints.length, 9));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch1(){
    Integer expected = null;
    assertEquals(expected, PhoneBookUtils.binarySearch(intsSorted, 0, ints.length, 45));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch3(){ 
    String expected = "Fff";
    assertEquals(expected, PhoneBookUtils.binarySearch(strsSorted, 0, strs.length, "Fff"));
  }

  @Test 
  public void testPhoneBookUtils_binarySearch4(){ 
    String expected = null;
    assertEquals(expected, PhoneBookUtils.binarySearch(strsSorted, 0, strs.length, "Bebe"));
  }

  

  // Given tester cases for PhoneBook
  @Test 
  public void testAddContact0() {
    PhoneBook blackbook = new PhoneBook();
    assertEquals("",blackbook.getContactList());
  }
  
  @Test 
  public void testAddContact1() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals("Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073.\n",blackbook.getContactList());
  }
  @Test 
  public void testAddContactFalse() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertFalse(blackbook.addContact("Lance Farmer", "", ""));
  }

  
  @Test 
  public void testGetContactList() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Lawrence Garcia", "diam@amagna.ca", "1-665-672-6398");
    String [] tempArr = blackbook.getContactList().split("\n");
	Set<String> actualSet = new HashSet<String>(Arrays.asList(tempArr));
    Set<String> expectedSet = new HashSet<String>(Arrays.asList(new String[]{
       "Lawrence Garcia, email: diam@amagna.ca, phone: 1-665-672-6398.",
       "Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073."
	}));

	assertEquals("loaded contacts do not match expected contents", expectedSet, actualSet);
    }
  @Test
    public void testFileToMapBadName() {
      PhoneBook blackbook = new PhoneBook(); 
      assertFalse(blackbook.fileToMap("contac.txt"));
    }
  @Test
  public void testFileToMap() {
    PhoneBook blackbook = new PhoneBook(); 
    blackbook.fileToMap("contacts.txt");
    String [] tempArr = blackbook.getContactList().split("\n");
	Set<String> actualSet = new HashSet<String>(Arrays.asList(tempArr));
    Set<String> expectedSet = new HashSet<String>(Arrays.asList(new String[]{
        "Wing Mcbride, email: vehicula.risus.Nulla@Nuncsollicitudincommodo.net, phone: 1-142-956-2408.",
        "Lawrence Garcia, email: diam@amagna.ca, phone: 1-665-672-6398.",
        "Brielle Richardson, email: nisl@semNulla.com, phone: 1-803-813-0239.",
        "Baxter Cantu, email: arcu.iaculis@iaculis.net, phone: 1-606-427-1676.",
        "Madonna Potter, email: sollicitudin@Nullamvitaediam.edu, phone: 1-116-362-9565.",
        "Xenos Cardenas, email: dui.in@lectus.org, phone: 1-947-140-2672.",
        "Petra Williamson, email: euismod.in@convallisligulaDonec.co.uk, phone: 1-352-344-9237.",
        "Marvin Castro, email: orci.Ut@Nuncquis.com, phone: 1-340-704-1258.",
        "Arthur Moody, email: est@temporerat.com, phone: 1-170-451-6998.",
        "Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073."}));

		assertEquals("loaded file contents do not match expected contents", expectedSet, actualSet);
  }
  
  @Test
  public void testListToString() {
    // testing a method in the utility class
    String [] strArr = {"F", "B", "Eee", "Xve", "Aba"};
    ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strArr));
    assertEquals("Aba\n"+"B\n"+"Eee\n"+"F\n"+"Xve\n",PhoneBookUtils.listToSortedList(strList));
  }

  @Test 
  public void testDeleteContact0() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.deleteContact("Bane Farmer");
    assertEquals("Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073.\n",blackbook.getContactList());
  }
  @Test 
  public void testDelteContact1() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertTrue(blackbook.deleteContact("Lance Farmer"));
  }
  @Test 
  public void testDelteContactFalse() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertFalse(blackbook.deleteContact("Lance Farme"));
  }
  @Test 
  public void testDelteContact2() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertFalse(blackbook.deleteContact("Tane Farmer"));
  }
  @Test
  public void testGetContactInfo() {
    PhoneBook blackbook = new PhoneBook();
    String s= "Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073.";
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals(s,blackbook.getContactInfo("Lance Farmer"));
  }
  @Test
  public void testGetContactInfo1() {
    PhoneBook blackbook = new PhoneBook();
    String s= null;
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals(s,blackbook.getContactInfo("Same Farmer"));
  }
  @Test
  public void testGetEmail1() {
    PhoneBook blackbook = new PhoneBook();
    String s= "Lance Farmer: sem.egestas@urnanecluctus.ca";
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals(s,blackbook.getEmail("Lance Farmer"));
  }
  @Test
  public void testGetEmail2() {
    PhoneBook blackbook = new PhoneBook();
    String s= null;
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals(s,blackbook.getEmail("Hance Farmer"));
  }
  @Test
  public void testGetPhone1() {
    PhoneBook blackbook = new PhoneBook();
    String s= "Lance Farmer: 1-425-180-9073";
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals(s,blackbook.getPhone("Lance Farmer"));
  }
  @Test
  public void testGetPhone2() {
    PhoneBook blackbook = new PhoneBook();
    String s= null;
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals(s,blackbook.getPhone("Hance Farmer"));
  }
  @Test
  public void testUpdataEmail() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertTrue(blackbook.updateEmail("Lance Farmer","Test@test.com"));
  }
  @Test
  public void testUpdataEmail2() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertFalse(blackbook.updateEmail("Hance Farmer","Test@test.com"));
  }
  @Test
  public void testSearchContact(){
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Bane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Kane Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Xen Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    Contact c= new Contact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals("Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073.", blackbook.searchContactList("Lance Farmer"));
  }
}
