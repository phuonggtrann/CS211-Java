/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E10tester       # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E10tester       # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class E10tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E10tester");
  }
  
  @Test public void topresult_exists() {
    TopResult<Integer>   tr_i = new TopResult<Integer>();
    TopResult<String>    tr_s = new TopResult<String>();
    TopResult<Character> tr_c = new TopResult<Character>();
    TopResult<Boolean>   tr_b = new TopResult<Boolean>();
    TopResult<Double>    tr_d = new TopResult<Double>();
  }
  
  @Test public void topresult_iscomparable() {
    TopResult<Integer>  tr = new TopResult<Integer>();
    Comparable<Integer> c = tr.getTopResult();
  }
  
  private Integer[] int_input = { 5, 3, 6, 2, 1, 6, 8, 9, 6, 7, 10 };
  private Integer[] int_top   = { 5, 5, 6, 6, 6, 6, 8, 9, 9, 9, 10 };
  
  @Test public void topresult_test_int() {
    TopResult<Integer>  tr = new TopResult<Integer>();
    assertTrue("top result initially should be null", tr.getTopResult() == null);
    assertTrue("top result toString should initially be null", tr.toString() == null);
    for (int i = 0; i < int_input.length;  i++) {
      tr.newResult(int_input[i]);
      Integer r_act = tr.getTopResult();
      Integer r_exp = int_top[i];
      String errMsg = String.format("wrong top result after entry %d of %s", i, Arrays.toString(int_input));
      assertEquals(errMsg, r_exp, r_act);
      String s_act = tr.toString();
      String s_exp = int_top[i].toString();
      errMsg = String.format("wrong toString after entry %d of %s", i, Arrays.toString(int_input));
      assertEquals(errMsg, s_exp, s_act);
    }
  }
  
  private String[] str_input = { "a", "c", "b", "d", "c", "e", "m", "h", "p" };
  private String[] str_top   = { "a", "c", "c", "d", "d", "e", "m", "m", "p" };
  
  @Test public void topresult_test_str() {
    TopResult<String>  tr = new TopResult<String>();
    assertTrue("top result initially should be null", tr.getTopResult() == null);
    assertTrue("top result toString should initially be null", tr.toString() == null);
    for (int i = 0; i < str_input.length;  i++) {
      tr.newResult(str_input[i]);
      String r_act = tr.getTopResult();
      String r_exp = str_top[i];
      String errMsg = String.format("wrong top result after entry %d of %s", i, Arrays.toString(str_input));
      assertEquals(errMsg, r_exp, r_act);
      String s_act = tr.toString();
      String s_exp = str_top[i].toString();
      errMsg = String.format("wrong toString after entry %d of %s", i, Arrays.toString(str_input));
      assertEquals(errMsg, s_exp, s_act);
    }
  }
  
  


}