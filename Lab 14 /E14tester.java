/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E14tester       # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E14tester       # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class E14tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E14tester");
  }
  
  private int[] array1 = {3, 6, 1, 8, 7, 5, 8};
  private int[][] cases1 = { 
    {0,0,-1}, {0,1,2}, {0,2,2}, {0,3,0}, {0,4,0}, {0,5,0},
    {1,0,2},  {1,1,2}, {1,2,0}, {1,3,0}, {1,4,0}, {1,5,0},
    {2,0,-1}, {2,1,0}, {2,2,0}, {2,3,0}, {2,4,0}, {2,5,0},
    {3,0,0},  {3,1,0}, {3,2,0}, {3,3,0}, {3,4,0}, {3,5,0},
    {4,0,-1}, {4,1,0}, {4,2,0}, {4,3,0}, {4,4,0}, {4,5,0},
    {5,0,5},  {5,1,1}, {5,2,0}, {5,3,0}, {5,4,0}, {5,5,0},
    {6,0,1},  {6,1,1}, {6,2,1}, {6,3,0}, {6,4,0}, {6,5,0},
    {7,0,4},  {7,1,1}, {7,2,1}, {7,3,1}, {7,4,0}, {7,5,0},
    {8,0,3},  {8,1,3}, {8,2,1}, {8,3,1}, {8,4,1}, {8,5,0},
    {9,0,-1}, {9,1,3}, {9,2,3}, {9,3,1}, {9,4,1}, {9,5,1},
  };
  private int[][] sorted1 = {
    // {3, 6, 1, 8, 7, 5, 8}
    {1,3,5,6,7,8,8}, // 0
    {1,3,5,6,7,8,8}, // 1
    {3,1,5,6,7,8,8}, // 2
    {3,1,5,6,7,8,8}, // 3
    {3,5,6,1,7,8,8}, // 4
    {5,6,3,7,8,8,1}, // 5
    {6,7,5,8,8,3,1}, // 6
    {7,6,8,8,5,3,1}, // 7
    {8,8,7,6,5,3,1}, // 8
    {8,8,7,6,5,3,1}, // 9
  };
  
  @Test(timeout=1000) public void test_findfirstdist() {
    for (int[] testcase : cases1) {
      int[] array = Arrays.copyOf(array1, array1.length);
      int expected = testcase[2];
      int actual = SortSearch.findFirstDist(array, testcase[0], testcase[1]);
      String errMsg = String.format("incorrect find first for v=%d, distance=%d", testcase[0], testcase[1]);
      assertEquals(errMsg, expected, actual);
    }
  }

  @Test(timeout=1000) public void test_sortdist() {
    for (int i = 0;  i < sorted1.length;  i++) {
      int[] actual = Arrays.copyOf(array1, array1.length);
      SortSearch.sortDist(actual, i);
      int[] expected = sorted1[i];
      String errMsg = String.format("incorrect sorting result for %s with v=%d (expected=%s, actual=%s)", 
                                    Arrays.toString(array1), i,
                                    Arrays.toString(expected),
                                    Arrays.toString(actual));
      assertArrayEquals(errMsg, expected, actual);
    }
  }
  
  @Test(timeout=1000) public void test_findkthfromv() {
    for (int v = 0;  v < sorted1.length;  v++) {
      for (int k = 1; k <= sorted1[v].length; k++) {
        int[] array = Arrays.copyOf(array1, array1.length);
        int actual = SortSearch.findKthFromV(array, k, v);
        int expected = sorted1[v][k-1];
        String errMsg = String.format("incorrect %dth element from %d in %s", k, v, Arrays.toString(array1));
        assertEquals(errMsg, expected, actual);
      }
    }
  }
  

}