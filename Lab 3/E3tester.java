/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E3tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E3tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class E3tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E3tester");
  }
  
  private Object[][] gradeData = {
    {100.0, "A"},
    {97.5,  "A"},
    {95.0,  "A"},
    {92.5,  "A"},
    {90.0,  "A"},
    {89.9,  "B"},
    {86.7,  "B"},
    {83.3,  "B"},
    {80.0,  "B"},
    {79.9,  "C"},
    {76.7,  "C"},
    {73.3,  "C"},
    {70.0,  "C"},
    {69.9,  "D"},
    {66.7,  "D"},
    {63.3,  "D"},
    {60.0,  "D"},
    {59.9,  "F"},
    {56.7,  "F"},
    {53.3,  "F"},
    {50.0,  "F"},
    {40.0,  "F"},
    {20.0,  "F"},
    {2.0,  "F"},
    {0.0,  "F"}
  };
  private final double ERR = 0.00001;
      
  @Test public void grade_construct_def() { 
    Grade g = new Grade();
    assertEquals("default grade is incorrect", 100.0, g.getGrade(), ERR);
  }
  @Test public void grade_construct_neg() {
    Grade g = new Grade(-1.0);
    assertEquals("negative grade should become zero", 0.0, g.getGrade(), ERR);
  }
  @Test public void grade_construct_range() {
    for (Object[] testcase : gradeData) {
      double grade = (Double)testcase[0];
      Grade g = new Grade(grade);
      assertEquals("grade initialization failed", grade, g.getGrade(), ERR);
    }
  }
  @Test public void grade_set_neg() {
    Grade g = new Grade(100.0);
    g.setGrade(-1.0);
    assertEquals("negative grade should be ignored", 100.0, g.getGrade(), ERR);
  }
  @Test public void grade_set_range() {
    for (Object[] testcase : gradeData) {
      double grade = (Double)testcase[0];
      Grade g = new Grade();
      g.setGrade(grade);
      assertEquals("setting new grade value failed", grade, g.getGrade(), ERR);
    }
  }
  @Test public void grade_letter_range() {
    for (Object[] testcase : gradeData) {
      double grade = (Double)testcase[0];
      String letter = (String)testcase[1];
      Grade g = new Grade(grade);
      String errmsg = String.format("incorrect letter grade for %f", grade);
      assertEquals(errmsg, letter, g.toString());
    }
  }

    private Object[][] inputData = {
    {"1 2 3 4 5", 5, "", "integer: 0 double: 0.0 string: ", 0, 0.0, "", 
     "integer: 1\n", "integer: 1 double: 0.0 string: ", 1, 0.0, "",
     "integer: 2\n", "integer: 3 double: 0.0 string: ", 3, 0.0, "",
     "integer: 3\n", "integer: 6 double: 0.0 string: ", 6, 0.0, "",
     "integer: 4\n", "integer: 10 double: 0.0 string: ", 10, 0.0, "",
     "integer: 5\n", "integer: 15 double: 0.0 string: ", 15, 0.0, ""
    },
    {"1.0 2.0 3.0 4.0 5.0", 5, "", "integer: 0 double: 0.0 string: ", 0, 0.0, "", 
     "double: 1.0\n", "integer: 0 double: 1.0 string: ", 0, 1.0, "",
     "double: 2.0\n", "integer: 0 double: 3.0 string: ", 0, 3.0, "",
     "double: 3.0\n", "integer: 0 double: 6.0 string: ", 0, 6.0, "",
     "double: 4.0\n", "integer: 0 double: 10.0 string: ", 0, 10.0, "",
     "double: 5.0\n", "integer: 0 double: 15.0 string: ", 0, 15.0, ""
    },
    {"ab cd ef 12g hijk", 5, "", "integer: 0 double: 0.0 string: ", 0, 0.0, "", 
     "string: ab\n", "integer: 0 double: 0.0 string: ab", 0, 0.0, "ab",
     "string: cd\n", "integer: 0 double: 0.0 string: abcd", 0, 0.0, "abcd",
     "string: ef\n", "integer: 0 double: 0.0 string: abcdef", 0, 0.0, "abcdef",
     "string: 12g\n", "integer: 0 double: 0.0 string: abcdef12g", 0, 0.0, "abcdef12g",
     "string: hijk\n", "integer: 0 double: 0.0 string: abcdef12ghijk", 0, 0.0, "abcdef12ghijk"
    },
    {"6 2.4 XY! 4 5.0 5.A", 6, "", "integer: 0 double: 0.0 string: ", 0, 0.0, "", 
     "integer: 6\n", "integer: 6 double: 0.0 string: ", 6, 0.0, "",
     "double: 2.4\n", "integer: 6 double: 2.4 string: ", 6, 2.4, "",
     "string: XY!\n", "integer: 6 double: 2.4 string: XY!", 6, 2.4, "XY!",
     "integer: 4\n", "integer: 10 double: 2.4 string: XY!", 10, 2.4, "XY!",
     "double: 5.0\n", "integer: 10 double: 7.4 string: XY!", 10, 7.4, "XY!",
     "string: 5.A\n", "integer: 10 double: 7.4 string: XY!5.A", 10, 7.4, "XY!5.A"
    }
  };
  
  @Test public void test_inputsplitter() throws Exception {
    for (Object[] testcase : inputData) {
      String input = (String)testcase[0];
      int tokens = (Integer)testcase[1];
      setInput(input);
      setCapture();
      InputSplitter iSplit = new InputSplitter();
      for (int i = 0, j = 2;  i <= tokens;  i++, j += 5) {
         String expectedOutput = (String)testcase[j];
         String expectedToString = (String)testcase[j+1];
         int expectedInt = (Integer)testcase[j+2];
         double expectedDouble = (Double)testcase[j+3];
         String expectedString = (String)testcase[j+4];
         String actualOutput = getCapture();
         String actualToString = iSplit.toString();
         int actualInt = iSplit.getIntTotal();
         double actualDouble = iSplit.getDoubleTotal();
         String actualString = iSplit.getStringTotal();
         unsetCapture();
         
         assertEquals(String.format("output mismatch after token %d of input %s", i, input), expectedOutput, actualOutput);
         assertEquals(String.format("toString mismatch after token %d of input %s", i, input), expectedToString, actualToString);
         assertEquals(String.format("integer accumulator mismatch after token %d of input %s", i, input), expectedInt, actualInt);
         assertEquals(String.format("floating point accumulator mismatch after token %d of input %s", i, input), expectedDouble, actualDouble, ERR);
         assertEquals(String.format("string accumulator mismatch after token %d of input %s", i, input), expectedString, actualString);
         
         if (i < tokens) {
           setCapture();
           iSplit.next();
         }
      }      
      unsetInput();
    }
  }
  


  /** the lines below are for setting up input/output redirection so that the
    * tests can see what is being set to the screen as well as produce its own
    * pseudo-keyboard input.  No test appear below here. */
  
  static ByteArrayOutputStream localOut, localErr;
  static ByteArrayInputStream localIn;
  static PrintStream sOut, sErr;
  static InputStream sIn;

  @BeforeClass public static void setup() throws Exception {
    sOut = System.out;
    sErr = System.err;
    sIn  = System.in;
  }
  
  @AfterClass public static void cleanup() throws Exception {
    unsetCapture();
    unsetInput();
  }
  
  private static void setCapture() {
   localOut = new ByteArrayOutputStream();
   localErr = new ByteArrayOutputStream();
   System.setOut(new PrintStream( localOut ) );
   System.setErr(new PrintStream( localErr ) );
  }

  private static String getCapture() {
   return localOut.toString().replaceAll("\\r?\\n", "\n");
  }

  private static void unsetCapture() {
   System.setOut( null );
   System.setOut( sOut );
   System.setErr( null );
   System.setErr( sErr );
  }
  
  private static void setInput(String input) {
    localIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(localIn);
  }
  
  private static void unsetInput() throws IOException {
    if (localIn != null) localIn.close();
    System.setIn( null );
    System.setIn( sIn  );
  }
  

}