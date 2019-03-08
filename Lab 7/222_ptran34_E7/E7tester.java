/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E7tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E7tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class E7tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E7tester");
  }
  
  private class DummySplittable implements Splittable {
    public int size() { return 0; }
    public Splittable firstHalf() { return null; }
    public Splittable secondHalf() { return null; }
  }
  
  @Test public void splittable_exists() {
    Splittable c = new DummySplittable();
    int i = c.size();
    Splittable s1 = c.firstHalf();
    Splittable s2 = c.secondHalf();
  }
  
  @Test public void splittablestring_implements() {
    Splittable c = new SplittableString("test");
    c.size();
    c.firstHalf();
    c.secondHalf();
  }
  
  private Object[][] testCases = {
    {"", 0, "", 0, "", 0,},
    {"t", 1, "t", 1, "", 0, 't',},
    {"te", 2, "t", 1, "e", 1, 't', 'e',},
    {"tes", 3, "te", 2, "s", 1, 't', 'e', 's',},
    {"test", 4, "te", 2, "st", 2, 't', 'e', 's', 't',},
  };
  
  @Test public void splittablestring_methods() {
    for (Object[] testCase : testCases) {
      String str = (String)testCase[0];
      String half1 = (String)testCase[2];
      String half2 = (String)testCase[4];
      int num = (Integer)testCase[1];
      int num1 = (Integer)testCase[3];
      int num2 = (Integer)testCase[5];
      SplittableString s = new SplittableString(str);
      String errMsg;
      assertEquals("String value does not match", str, s.toString());
      assertEquals("String length does not match", num, s.length());
      assertEquals("String size does not match", num, s.size());
      errMsg = String.format("First half of %s does not match", str);
      assertEquals(errMsg, half1, s.firstHalf().toString());
      errMsg = String.format("First half size of %s does not match", str);
      assertEquals(errMsg, num1, s.firstHalf().size());
      errMsg = String.format("Second half of %s does not match", str);
      assertEquals(errMsg, half2, s.secondHalf().toString());
      errMsg = String.format("Second half size of %s does not match", str);
      assertEquals("Second half size does not match", num2, s.secondHalf().size());
      for (int i = 0;  i < num;  i++) {
        errMsg = String.format("charAt(%d) of %s does not match", i, str);
        char c = (Character)testCase[6+i];
        assertEquals(errMsg, c, s.charAt(i));
      } 
    }
  }
  
  @Test public void splittablearray_implements() {
    Splittable c = new SplittableArray();
    c.size();
    c.firstHalf();
    c.secondHalf();
    assertTrue("SplittableArray should inherit from ArrayList<String>", c instanceof ArrayList);
  }
  
  private Object[][][] testCasesArray = {
    { {0, 0, 0}, {}, {}, {} },
    { {1, 1, 0}, {"test"}, {"test"}, {} },
    { {2, 1, 1}, {"test", "one"}, {"test"}, {"one"} },
    { {3, 2, 1}, {"test", "one", "two"}, {"test", "one"}, {"two"} },
    { {4, 2, 2}, {"test", "one", "two", "three"}, {"test", "one"}, {"two", "three"} },
  };
  
  @Test public void splittablearray_methods() {
    for (Object[][] testCase : testCasesArray) {
      SplittableArray arr = new SplittableArray();
      int num = (Integer)testCase[0][0];
      int num1 = (Integer)testCase[0][1];
      int num2 = (Integer)testCase[0][2];
      String errMsg;
      for (int i = 0;  i < num;  i++) {
        String s = (String)testCase[1][i];
        arr.add(s);
        errMsg = String.format("Element %d of %s incorrectly added", i, Arrays.toString(testCase[1]));
        assertEquals(errMsg, s, arr.get(i));
      }
      errMsg = String.format("Element count of %s does not match", Arrays.toString(testCase[1]));
      assertEquals("Element count does not match", num, arr.size());
      checkList("First half", arr.firstHalf(), testCase[2]);
      checkList("Second half", arr.secondHalf(), testCase[3]);
    }
  }
  
  private void checkList(String info, SplittableArray sa, Object[] values) {
    String errMsg = String.format("%s size does not match", info);
    assertEquals(errMsg, values.length, sa.size());
    for (int i = 0;  i < values.length; i++) {
      String s = (String)values[i];
      errMsg = String.format("%s array for %s does not match at element %d", info, Arrays.toString(values), i);
      assertEquals(errMsg, s, sa.get(i));
    }
  }

  @Test public void interval_implements() {
    Splittable c = new Interval(0,10);
    c.size();
    c.firstHalf();
    c.secondHalf();
  }
  
  private int[][] intervalTestCases = {
    {0, 10, 10,  0,  5,  5,  5, 10,  5},
    {1, 10,  9,  1,  6,  5,  6, 10,  4},
    {1,  9,  8,  1,  5,  4,  5,  9,  4},
    {2,  9,  7,  2,  6,  4,  6,  9,  3},
    {2,  8,  6,  2,  5,  3,  5,  8,  3},
    {3,  8,  5,  3,  6,  3,  6,  8,  2},
    {3,  7,  4,  3,  5,  2,  5,  7,  2},
    {4,  7,  3,  4,  6,  2,  6,  7,  1},
    {4,  6,  2,  4,  5,  1,  5,  6,  1},
    {5,  6,  1,  5,  6,  1,  6,  6,  0},
    {5,  5,  0,  5,  5,  0,  5,  5,  0},
  };
  
  @Test public void interval_methods() {
    for (int[] testCase : intervalTestCases) {
      Interval inter = new Interval(testCase[0], testCase[1]);
      Interval i1 = (Interval)inter.firstHalf();
      Interval i2 = (Interval)inter.secondHalf();
      String errMsg;
      errMsg = String.format("Incorrect interval [%d, %d) low bound", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[0], inter.low());
      errMsg = String.format("Incorrect interval [%d, %d) high bound", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[1], inter.high());
      errMsg = String.format("Incorrect interval [%d, %d) size", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[2], inter.size());
      errMsg = String.format("Incorrect interval [%d, %d) first half low bound", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[3], i1.low());
      errMsg = String.format("Incorrect interval [%d, %d) first half high bound", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[4], i1.high());
      errMsg = String.format("Incorrect interval [%d, %d) first half size", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[5], i1.size());
      errMsg = String.format("Incorrect interval [%d, %d) second half low bound", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[6], i2.low());
      errMsg = String.format("Incorrect interval [%d, %d) second half high bound", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[7], i2.high());
      errMsg = String.format("Incorrect interval [%d, %d) second half size", testCase[0], testCase[1]);
      assertEquals(errMsg, testCase[8], i2.size());
    }
    
    assertEquals("Incorrect toString() value", "[5, 6)", new Interval(5, 6).toString());
  }
  
}