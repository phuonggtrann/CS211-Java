/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E9tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E9tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class E9tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E9tester");
  }
  
  @Test public void zeroexception_exists() {
    Exception e = new ZeroException();
  }

  @Test public void arraymanipulator_getset() throws Exception {
    ArrayManipulator a = new ArrayManipulator(5);
    for (int i = 0;  i < 5;  i++) a.set(i, i+1);
    for (int i = 0;  i < 5;  i++) {
      String errMsg = String.format("incorrect value at position %d", i);
      assertEquals(errMsg, (i+1), a.get(i));
    }
    
  }
  
  private int[][] multRes = { 
    {1,2,3,4,5}, {2,4,6,8,10}, {3,6,9,12,15}, {4,8,12,16,20}, {5,10,15,20,25} 
  };
  @Test public void arraymanipulator_getmult() throws Exception {
    ArrayManipulator a = new ArrayManipulator(5);
    for (int i = 0;  i < 5;  i++) a.set(i, i+1);
    for (int[] testCase : multRes) {
       int m = testCase[0];
       for (int i = 0;  i < 5;  i++) {
         String errMsg = String.format("incorrect value at position %d when multiplying %d by %d", i, i+1, m);
         assertEquals(errMsg, testCase[i], a.getMult(i, m));
       }
       for (int i = 0;  i < 5;  i++) {
         String errMsg = String.format("incorrect value at position %d when multiplying %d by %d (repeated)", i, i+1, m);
         assertEquals(errMsg, testCase[i], a.getMult(i, m));
       }
    }
  }
  
  private int[][] divRes = { 
    {5,10,15,20,25,1}, {2,5,7,10,12,2}, {1,3,5,6,8,3}, {1,2,3,5,6,4}, {1,2,3,4,5,5} 
  };
  @Test public void arraymanipulator_getdiv() throws Exception {
    ArrayManipulator a = new ArrayManipulator(5);
    for (int i = 0;  i < 5;  i++) a.set(i, 5*i+5);
    for (int[] testCase : divRes) {
       int d = testCase[5];
       for (int i = 0;  i < 5;  i++) {
         String errMsg = String.format("incorrect value at position %d when dividing %d by %d", i, (5*i+5), d);
         assertEquals(errMsg, testCase[i], a.getDiv(i, d));
       }
       for (int i = 0;  i < 5;  i++) {
         String errMsg = String.format("incorrect value at position %d when dividing %d by %d (repeated)", i, (5*i+5), d);
         assertEquals(errMsg, testCase[i], a.getDiv(i, d));
       }
    }
  }
  
  @Test public void arraymanipulator_print() throws Exception {
    ArrayManipulator a = new ArrayManipulator(5);
    for (int i = 0;  i < 5;  i++) a.set(i, i+1);
    setCapture();
    for (int m = 0; m < 5; m++) {
      for (int i = 0;  i < 5;  i++) a.print(m,i,2);
    }
    a.print(0,10,0);
    a.print(1,10,0);
    a.print(2,10,0);
    a.print(0,0,0);
    a.print(1,0,0);
    a.print(2,0,0);
    a.set(0,0);
    a.print(0,0,0);
    
    String expected = "1\n2\n3\n4\n5\n"+
         "2\n4\n6\n8\n10\n"+
         "zero result\n1\n1\n2\n2\n"+
         "out of bounds\nout of bounds\nout of bounds\n" +
         "1\nzero result\ndivide by zero\n" +
         "zero result\n";
         
    String actual = getCapture();
	assertEquals(expected, actual);
    unsetCapture();
    
  }
  
  /** the lines below are for setting up input/output redirection so that the
    * tests can see what is being set to the screen as well as produce its own
    * pseudo-keyboard input.  No test appear below here. */
  
  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sOut, sErr;

  @BeforeClass public static void setup() throws Exception {
    sOut = System.out;
    sErr = System.err;
  }
  
  @AfterClass public static void cleanup() throws Exception {
    unsetCapture();
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

}