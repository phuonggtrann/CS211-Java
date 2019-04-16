/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E12tester       # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E12tester       # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class E12tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E12tester");
  }
  
  private Integer[] test1 = {1, 2, 6, 4, 5, 2, 3};
  @Test public void test_i2c_1() {
    ArrayList<Integer> a = new ArrayList<>();
    a.addAll(Arrays.asList(test1));
    Iterable<Integer> i1 = a;
    Collection<Integer> c = ListUtils.iterToCollection(i1);
    
    String errMsg = String.format("collection does not have the expected size", Arrays.toString(test1));
    assertEquals(errMsg, test1.length, c.size());
    for (Integer elem : test1) {
      errMsg = String.format("collection missing element %s from %s", elem, Arrays.toString(test1));
      assertTrue(errMsg, c.contains(elem));
    }
    for (Integer elem : c) {
      errMsg = String.format("collection has extraneous element %s not in %s", elem, Arrays.toString(test1));
      assertTrue(errMsg, Arrays.asList(test1).contains(elem));
    }  
    
  }
  
  private String[] test2 = {"abc", "def", "ghi", "jkl"};
  @Test public void test_i2c_2() {
    Set<String> s = new HashSet<>();
    s.addAll(Arrays.asList(test2));
    Iterable<String> i1 = s;
    Collection<String> c = ListUtils.iterToCollection(i1);
    
    String errMsg = String.format("collection for %s does not have the expected size", Arrays.toString(test2));
    assertEquals(errMsg, test2.length, c.size());
    for (String elem : test2) {
      errMsg = String.format("collection missing element %s from %s", elem, Arrays.toString(test2));
      assertTrue(errMsg, c.contains(elem));
    }
    for (String elem : c) {
      errMsg = String.format("collection has extraneous element %s not in %s", elem, Arrays.toString(test2));
      assertTrue(errMsg, Arrays.asList(test2).contains(elem));
    }  
    
  }

  @Test public void test_c2l_1() {
    ArrayList<Integer> a = new ArrayList<>();
    a.addAll(Arrays.asList(test1));
    Collection<Integer> c = a;
    List<Integer> l = ListUtils.collToList(c);
    
    String errMsg = String.format("list for %s does not have the expected size", Arrays.toString(test1));
    assertEquals(errMsg, test1.length, l.size());
    for (int i = 0;  i < test1.length;  i++) {
      errMsg = String.format("list mismatch at element %d of %s", i, Arrays.toString(test1));
      assertEquals(errMsg, test1[i], l.get(i));
    }
    
  }

  @Test public void test_c2l_2() {
    Set<String> a = new HashSet<>();
    a.addAll(Arrays.asList(test2));
    Collection<String> c = a;
    List<String> l = ListUtils.collToList(c);
    
    String errMsg = String.format("list for %s does not have the expected size", Arrays.toString(test2));
    assertEquals(errMsg, test2.length, l.size());
    for (int i = 0;  i < test2.length;  i++) {
      errMsg = String.format("list mismatch at element %d of %s", i, Arrays.toString(test2));
      assertEquals(errMsg, test2[i], l.get(i));
    }
    
  }

  @Test public void test_l2m_1() {
    Integer[] test = test1;
    String data = Arrays.toString(test);
    
    List<Integer> a = new ArrayList<>();
    a.addAll(Arrays.asList(test));
    Map<Integer,Integer> m = ListUtils.listToMap(a);

    String errMsg = String.format("list for %s does not have the expected size", data);
    assertEquals(errMsg, test.length, m.size());
    for (int i = 0;  i < test.length;  i++) {
      errMsg = String.format("map mismatch at element %d of %s", i, data);
      assertEquals(errMsg, test[i], m.get(i));
    }
    for (Integer key : m.keySet()) {
      errMsg = String.format("map contains extraneous key-value (%s,%s) for list %s", key, m.get(key), data);
      assertTrue(errMsg, (key >= 0 && key < test.length));
    }
    
  }

  @Test public void test_l2m_2() {
    String[] test = test2;
    String data = Arrays.toString(test);

    List<String> a = new ArrayList<>();
    a.addAll(Arrays.asList(test));
    Map<Integer,String> m = ListUtils.listToMap(a);

    
    String errMsg = String.format("list for %s does not have the expected size", data);
    assertEquals(errMsg, test.length, m.size());
    for (int i = 0;  i < test.length;  i++) {
      errMsg = String.format("map mismatch at element %d of %s", i, data);
      assertEquals(errMsg, test[i], m.get(i));
    }
    for (Integer key : m.keySet()) {
      errMsg = String.format("map contains extraneous key-value (%s,%s) for list %s", key, m.get(key), data);
      assertTrue(errMsg, (key >= 0 && key < test.length));
    }
    
  }


}