/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E6tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E6tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class E6tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E6tester");
  }
  
  @Test public void option_construct() {
    Option o = new Option("op1", "Option 1");
    assertEquals("incorrect key value", "op1", o.getKey());
    assertEquals("incorrect option name", "Option 1", o.getName());
    assertEquals("number of slots should be 1", 1, o.numSlots());
    assertFalse("isFound() should initially be false", o.isFound());
  }
  
  @Test public void option_match() {
    for (int i = 0;  i < 5;  i++) {
      String[] s = {"y", "n", "y", "y", "n"};
      boolean expected = s[i].equals("y");
      Option o = new Option("y", "test option");
      String errMsg = String.format("improper match detection at position %d of %s", i, Arrays.toString(s));
      assertEquals(errMsg, expected, o.match(s, i));
      errMsg = String.format("incorrect isFound() output after position %d of %s", i, Arrays.toString(s));
      assertEquals(errMsg, expected, o.isFound());
      String expectStr = String.format("test option: %s", (expected ? "yes" : "no"));
      errMsg = String.format("incorrect toString() output after position %d of %s", i, Arrays.toString(s));
      assertEquals(errMsg, expectStr, o.toString());
    }
  }
  
  @Test public void optionprocessor_construct() {
    OptionProcessor op = new OptionProcessor();
    assertEquals("OptionProcessor should initially have an empty toString()", "", op.toString());
  }

  @Test public void optionprocessor_add() {
    OptionProcessor op = new OptionProcessor();
    String expected = "";
    for (int i = 0;  i < 5;  i++) {
      op.add(new Option("op" + i, "Option " + i));
      expected += String.format("Option %d: no\n", i);
    }
    assertEquals("incorrect output from adding Options", expected, op.toString());
  }
  
  @Test(timeout=1000) public void optionprocessor_process() {
    String[] opList = {"op1", "op0", "op5", "op4"};
    boolean[] expected = {true, true, false, false, true, true, false, false};
    String expString = "";
    Option[] optObjs = new Option[8];
    OptionProcessor op = new OptionProcessor();
    for (int i = 0;  i < optObjs.length; i++) {
      optObjs[i] = new Option("op" + i, "Option " + i);
      op.add(optObjs[i]);
      expString += String.format("Option %d: %s\n", i, (expected[i] ? "yes" : "no"));
    }
    op.process(opList);
    String errMsg = String.format("incorrect result of processing options list %s", Arrays.toString(opList));
    assertEquals(errMsg, expString, op.toString());    
  }
  
  @Test(timeout=1000) public void optionprocessor_skipopt() {
    String[] opList = {"unknown", "op0"};
    boolean[] expected = {true, false};
    String expString = "";
    Option[] optObjs = new Option[expected.length];
    OptionProcessor op = new OptionProcessor();
    for (int i = 0;  i < optObjs.length; i++) {
      optObjs[i] = new Option("op" + i, "Option " + i);
      op.add(optObjs[i]);
      expString += String.format("Option %d: %s\n", i, (expected[i] ? "yes" : "no"));
    }
    op.process(opList);
    String errMsg = String.format("incorrect result of processing options list %s", Arrays.toString(opList));
    assertEquals(errMsg, expString, op.toString());    
  }
  
  @Test public void stringoption_construct() {
    StringOption o = new StringOption("op1", "Option 1", "default");
    assertTrue("StringOption should inherit from Option", o instanceof Option);
    assertEquals("incorrect key value", "op1", o.getKey());
    assertEquals("incorrect option name", "Option 1", o.getName());
    assertEquals("incorrect option attribute value", "default", o.getValue());
    assertEquals("number of slots should be 2", 2, o.numSlots());
    assertFalse("isFound() should initially be false", o.isFound());
  }

  @Test public void stringoption_match() {
    for (int i = 0;  i < 5;  i++) {
      int j = 2*i;
      String[] s = {"y", "s0", "n", "s1", "y", "s2", "y", "s3", "n", "s4"};
      boolean expected = s[j].equals("y");
      StringOption o = new StringOption("y", "test option", "def value");
      String errMsg = String.format("improper match detection at position %d of %s", j, Arrays.toString(s));
      assertEquals(errMsg, expected, o.match(s, j));
      errMsg = String.format("incorrect isFound() output after position %d of %s", j, Arrays.toString(s));
      assertEquals(errMsg, expected, o.isFound());
      String expectStr = String.format("test option: %s", (expected ? "s"+i : "def value"));
      errMsg = String.format("incorrect toString() output after position %d of %s", j, Arrays.toString(s));
      assertEquals(errMsg, expectStr, o.toString());
    }
  }

  @Test(timeout=1000) public void stringoption_process() {
    String[] opList = {"sop1", "s1", "op0", "sop5", "s5", "op4"};
    boolean[] expFound = {true, true, false, false, true, true, false, false};
    String[] expValue = {"yes", "s1", "no", "def3", "yes", "s5", "no", "def7"};
    String expString = "";
    Option[] optObjs = new Option[8];
    OptionProcessor op = new OptionProcessor();
    for (int i = 0;  i < optObjs.length; i++) {
      if (i%2 == 0) { 
        optObjs[i] = new Option("op" + i, "Option " + i);
        expString += String.format("Option %d: %s\n", i, expValue[i]);
      }
      else {
        optObjs[i] = new StringOption("sop" + i, "String Option " + i, "def" + i);
        expString += String.format("String Option %d: %s\n", i, expValue[i]);
      }
      op.add(optObjs[i]);
    }
    op.process(opList);
    String errMsg = String.format("incorrect result of processing options list %s", Arrays.toString(opList));
    assertEquals(errMsg, expString, op.toString());    
  }

}