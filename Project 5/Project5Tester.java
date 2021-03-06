import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Project5Tester {
 
   
  
  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("Project5Tester");
  }
  
  @Test 
  public void testAddContact0() {
    PhoneBook blackbook = new PhoneBook();
    System.out.println(blackbook.getContactList());
    assertEquals("",blackbook.getContactList());
  }
  
  @Test 
  public void testAddContact1() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    assertEquals("Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073.\n",blackbook.getContactList());
  }
  
  
  @Test 
  public void testGetContactList() {
    PhoneBook blackbook = new PhoneBook();
    blackbook.addContact("Lance Farmer", "sem.egestas@urnanecluctus.ca", "1-425-180-9073");
    blackbook.addContact("Lawrence Garcia", "diam@amagna.ca", "1-665-672-6398");
    System.out.println(blackbook.getContactList());
    String [] tempArr = blackbook.getContactList().split("\n");
	Set<String> actualSet = new HashSet<String>(Arrays.asList(tempArr));
    Set<String> expectedSet = new HashSet<String>(Arrays.asList(new String[]{
       "Lawrence Garcia, email: diam@amagna.ca, phone: 1-665-672-6398.",
       "Lance Farmer, email: sem.egestas@urnanecluctus.ca, phone: 1-425-180-9073.\n"
	}));

	assertEquals("loaded contacts do not match expected contents", expectedSet, actualSet);
    }
  
  @Test
  public void testFileToMap() {
    PhoneBook blackbook = new PhoneBook(); 
    blackbook.fileToMap("contacts.txt");
    System.out.println(blackbook.getContactList());
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
    System.out.println(PhoneBookUtils.listToSortedList(strList));
    assertEquals("Aba\n"+"B\n"+"Eee\n"+"F\n"+"Xve\n",PhoneBookUtils.listToSortedList(strList));
  }
   
}   