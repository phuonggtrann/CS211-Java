/** Example of using unit tests for this assignment.  To run them on the command line, make
 * sure that the junit-cs211.jar is in the same directory.  
 * 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar P1tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  demo$ javac -cp .;junit-cs211.jar *.java   # compile everything
 *  demo$ java -cp .;junit-cs211.jar P1tester  # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
  
public class P1tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("P1tester");
  }
  
  @Test public void test1_inOrder_00() { assertTrue(DataProcessor.inOrder(new int[]{})); }
  @Test public void test1_inOrder_01() { assertTrue(DataProcessor.inOrder(new int[]{0})); }
  @Test public void test1_inOrder_02() { assertTrue(DataProcessor.inOrder(new int[]{1})); }
  @Test public void test1_inOrder_03() { assertTrue(DataProcessor.inOrder(new int[]{2})); }
  @Test public void test1_inOrder_04() { assertTrue(DataProcessor.inOrder(new int[]{0,1})); }
  @Test public void test1_inOrder_05() { assertTrue(DataProcessor.inOrder(new int[]{0,1,2})); }
  @Test public void test1_inOrder_06() { assertTrue(DataProcessor.inOrder(new int[]{0,1,2,3})); }
  @Test public void test1_inOrder_07() { assertTrue(DataProcessor.inOrder(new int[]{0,1,2,3,4})); }
  @Test public void test1_inOrder_08() { assertTrue(DataProcessor.inOrder(new int[]{0,2,4,6,8})); }
  @Test public void test1_inOrder_09() { assertTrue(DataProcessor.inOrder(new int[]{0,3,4,9,22})); }
  @Test public void test1_inOrder_10() { assertTrue(DataProcessor.inOrder(new int[]{0,0,1,1,2,2})); }
  @Test public void test1_inOrder_11() { assertTrue(DataProcessor.inOrder(new int[]{0,4,6,6,9})); }
  @Test public void test1_inOrder_12() { assertFalse(DataProcessor.inOrder(new int[]{0,-1})); }
  @Test public void test1_inOrder_13() { assertFalse(DataProcessor.inOrder(new int[]{1,0})); }
  @Test public void test1_inOrder_14() { assertFalse(DataProcessor.inOrder(new int[]{1,2,1})); }
  @Test public void test1_inOrder_15() { assertFalse(DataProcessor.inOrder(new int[]{1,2,2,0})); }
  @Test public void test1_inOrder_16() { assertFalse(DataProcessor.inOrder(new int[]{1,2,1,3})); }
  @Test public void test1_inOrder_17() { assertFalse(DataProcessor.inOrder(new int[]{1,2,3,4,2,6})); }
  @Test public void test1_inOrder_18() { assertFalse(DataProcessor.inOrder(new int[]{1,2,0,1,2,3})); }
  @Test public void test1_inOrder_19() { assertTrue(DataProcessor.inOrder(new int[]{1,1,1,1,1,1})); }

  @Test public void test2_smallest_00() { assertEquals(Integer.MAX_VALUE, DataProcessor.smallest(new int[]{})); }
  @Test public void test2_smallest_01() { assertEquals(0, DataProcessor.smallest(new int[]{0})); }
  @Test public void test2_smallest_02() { assertEquals(10, DataProcessor.smallest(new int[]{10})); }
  @Test public void test2_smallest_03() { assertEquals(-20, DataProcessor.smallest(new int[]{-20})); }
  @Test public void test2_smallest_04() { assertEquals(7, DataProcessor.smallest(new int[]{7,7})); }
  @Test public void test2_smallest_05() { assertEquals(8, DataProcessor.smallest(new int[]{8,17})); }
  @Test public void test2_smallest_06() { assertEquals(3, DataProcessor.smallest(new int[]{19,3})); }
  @Test public void test2_smallest_07() { assertEquals(1, DataProcessor.smallest(new int[]{1,1,2,3})); }
  @Test public void test2_smallest_08() { assertEquals(1, DataProcessor.smallest(new int[]{2,1,3})); }
  @Test public void test2_smallest_09() { assertEquals(4, DataProcessor.smallest(new int[]{9,10,8,7,4,5,7,6,5,4})); }

  @Test public void test3_smallestGreaterThanN_00() { assertEquals(0, DataProcessor.smallestGreaterThanN(0, new int[]{})); }
  @Test public void test3_smallestGreaterThanN_01() { assertEquals(5, DataProcessor.smallestGreaterThanN(5, new int[]{})); }
  @Test public void test3_smallestGreaterThanN_02() { assertEquals(5, DataProcessor.smallestGreaterThanN(5, new int[]{1})); }
  @Test public void test3_smallestGreaterThanN_03() { assertEquals(6, DataProcessor.smallestGreaterThanN(5, new int[]{6})); }
  @Test public void test3_smallestGreaterThanN_04() { assertEquals(10, DataProcessor.smallestGreaterThanN(10, new int[]{4,7})); }
  @Test public void test3_smallestGreaterThanN_05() { assertEquals(7, DataProcessor.smallestGreaterThanN(6, new int[]{4,7})); }
  @Test public void test3_smallestGreaterThanN_06() { assertEquals(7, DataProcessor.smallestGreaterThanN(6, new int[]{6,7})); }
  @Test public void test3_smallestGreaterThanN_07() { assertEquals(6, DataProcessor.smallestGreaterThanN(3, new int[]{6,7})); }
  @Test public void test3_smallestGreaterThanN_08() { assertEquals(4, DataProcessor.smallestGreaterThanN(3, new int[]{1,4,3,2,2,6,7,4,3,7})); }
  @Test public void test3_smallestGreaterThanN_09() { assertEquals(8, DataProcessor.smallestGreaterThanN(8, new int[]{1,4,3,2,2,6,7,4,3,7})); }

  @Test public void test4_numDistinct_00() { assertEquals(0, DataProcessor.numDistinct(new int[]{})); }
  @Test public void test4_numDistinct_01() { assertEquals(1, DataProcessor.numDistinct(new int[]{0})); }
  @Test public void test4_numDistinct_02() { assertEquals(2, DataProcessor.numDistinct(new int[]{0,1})); }
  @Test public void test4_numDistinct_03() { assertEquals(3, DataProcessor.numDistinct(new int[]{0,1,2})); }
  @Test public void test4_numDistinct_04() { assertEquals(4, DataProcessor.numDistinct(new int[]{0,1,2,3})); }
  @Test public void test4_numDistinct_05() { assertEquals(4, DataProcessor.numDistinct(new int[]{2,4,6,8})); }
  @Test public void test4_numDistinct_06() { assertEquals(4, DataProcessor.numDistinct(new int[]{2,1,0,3})); }
  @Test public void test4_numDistinct_07() { assertEquals(1, DataProcessor.numDistinct(new int[]{1,1})); }
  @Test public void test4_numDistinct_08() { assertEquals(1, DataProcessor.numDistinct(new int[]{2,2,2})); }
  @Test public void test4_numDistinct_09() { assertEquals(2, DataProcessor.numDistinct(new int[]{3,3,4,4,4,4})); }
  @Test public void test4_numDistinct_10() { assertEquals(4, DataProcessor.numDistinct(new int[]{1,2,2,3,3,4,4})); }
  @Test public void test4_numDistinct_11() { assertEquals(5, DataProcessor.numDistinct(new int[]{1,1,2,3,4,5})); }
  @Test public void test4_numDistinct_12() { assertEquals(5, DataProcessor.numDistinct(new int[]{1,2,3,3,4,5})); }
  @Test public void test4_numDistinct_13() { assertEquals(5, DataProcessor.numDistinct(new int[]{1,3,3,4,5,5,5,8})); }
  @Test public void test4_numDistinct_14() { assertEquals(5, DataProcessor.numDistinct(new int[]{2,7,3,3,6,4,6,6,3,2})); }

  @Test public void test5_numOccurrences_00() { assertEquals(0, DataProcessor.numOccurrences(0, new int[]{})); }
  @Test public void test5_numOccurrences_01() { assertEquals(0, DataProcessor.numOccurrences(0, new int[]{1})); }
  @Test public void test5_numOccurrences_02() { assertEquals(1, DataProcessor.numOccurrences(2, new int[]{2})); }
  @Test public void test5_numOccurrences_03() { assertEquals(2, DataProcessor.numOccurrences(2, new int[]{2,2})); }
  @Test public void test5_numOccurrences_04() { assertEquals(3, DataProcessor.numOccurrences(2, new int[]{2,2,2})); }
  @Test public void test5_numOccurrences_05() { assertEquals(0, DataProcessor.numOccurrences(3, new int[]{2,2,2})); }
  @Test public void test5_numOccurrences_06() { assertEquals(1, DataProcessor.numOccurrences(0, new int[]{0,1,1,2,2,2,3,3,3,3})); }
  @Test public void test5_numOccurrences_07() { assertEquals(2, DataProcessor.numOccurrences(1, new int[]{0,1,1,2,2,2,3,3,3,3})); }
  @Test public void test5_numOccurrences_08() { assertEquals(3, DataProcessor.numOccurrences(2, new int[]{0,1,1,2,2,2,3,3,3,3})); }
  @Test public void test5_numOccurrences_09() { assertEquals(4, DataProcessor.numOccurrences(3, new int[]{0,1,1,2,2,2,3,3,3,3})); }
  @Test public void test5_numOccurrences_10() { assertEquals(0, DataProcessor.numOccurrences(5, new int[]{0,3,1,3,2,1,3,2,3,2})); }
  @Test public void test5_numOccurrences_11() { assertEquals(1, DataProcessor.numOccurrences(0, new int[]{0,3,1,3,2,1,3,2,3,2})); }
  @Test public void test5_numOccurrences_12() { assertEquals(2, DataProcessor.numOccurrences(1, new int[]{0,3,1,3,2,1,3,2,3,2})); }
  @Test public void test5_numOccurrences_13() { assertEquals(3, DataProcessor.numOccurrences(2, new int[]{0,3,1,3,2,1,3,2,3,2})); }
  @Test public void test5_numOccurrences_14() { assertEquals(4, DataProcessor.numOccurrences(3, new int[]{0,3,1,3,2,1,3,2,3,2})); }

  @Test public void test6_numInRange_00() { assertEquals(0, DataProcessor.numInRange(0, 10, new int[]{})); }
  @Test public void test6_numInRange_01() { assertEquals(1, DataProcessor.numInRange(0, 10, new int[]{1})); }
  @Test public void test6_numInRange_02() { assertEquals(2, DataProcessor.numInRange(0, 10, new int[]{1,2})); }
  @Test public void test6_numInRange_03() { assertEquals(3, DataProcessor.numInRange(0, 10, new int[]{1,2,3})); }
  @Test public void test6_numInRange_04() { assertEquals(0, DataProcessor.numInRange(0, 10, new int[]{-1,11,20})); }
  @Test public void test6_numInRange_05() { assertEquals(1, DataProcessor.numInRange(0, 10, new int[]{-1,11,1})); }
  @Test public void test6_numInRange_06() { assertEquals(2, DataProcessor.numInRange(0, 10, new int[]{0,5})); }
  @Test public void test6_numInRange_07() { assertEquals(1, DataProcessor.numInRange(0, 10, new int[]{5,10})); }
  @Test public void test6_numInRange_08() { assertEquals(6, DataProcessor.numInRange(0, 10, new int[]{-1,5,10,2,11,0,2,4,15,4})); }
  @Test public void test6_numInRange_09() { assertEquals(1, DataProcessor.numInRange(5, 10, new int[]{-1,5,10,2,11,0,2,4,15,4})); }

  @Test public void test7_mean_00() { assertEquals(0.0, DataProcessor.mean(new int[]{0}),0.00001); }
  @Test public void test7_mean_01() { assertEquals(1.0, DataProcessor.mean(new int[]{1}),0.00001); }
  @Test public void test7_mean_02() { assertEquals(2.0, DataProcessor.mean(new int[]{2}),0.00001); }
  @Test public void test7_mean_03() { assertEquals(1.0, DataProcessor.mean(new int[]{0,2}),0.00001); }
  @Test public void test7_mean_04() { assertEquals(2.0, DataProcessor.mean(new int[]{0,2,4}),0.00001); }
  @Test public void test7_mean_05() { assertEquals(3.0, DataProcessor.mean(new int[]{0,2,7}),0.00001); }
  @Test public void test7_mean_06() { assertEquals(3.0, DataProcessor.mean(new int[]{1,4,2,5}),0.00001); }
  @Test public void test7_mean_07() { assertEquals(2.5, DataProcessor.mean(new int[]{2,3}),0.00001); }
  @Test public void test7_mean_08() { assertEquals(0.33333333, DataProcessor.mean(new int[]{0,1,0}),0.00001); }
  @Test public void test7_mean_09() { assertEquals(6.2, DataProcessor.mean(new int[]{1,2,4,8,16}),0.00001); }

  @Test public void test8_meanInRange_00() { assertEquals(4.0, DataProcessor.meanInRange(0,10,new int[]{3},new double[]{4.0}),0.00001); }
  @Test public void test8_meanInRange_01() { assertEquals(5.0, DataProcessor.meanInRange(0,10,new int[]{7,2},new double[]{4.0,6.0}),0.00001); }
  @Test public void test8_meanInRange_02() { assertEquals(6.0, DataProcessor.meanInRange(0,10,new int[]{2,9,3},new double[]{4.0,6.0,8.0}),0.00001); }
  @Test public void test8_meanInRange_03() { assertEquals(4.5, DataProcessor.meanInRange(0,10,new int[]{1,2,3,4},new double[]{3.0,4.0,5.0,6.0}),0.00001); }
  @Test public void test8_meanInRange_04() { assertEquals(8.0, DataProcessor.meanInRange(0,10,new int[]{7,8,9,10,11},new double[]{9.0,8.0,7.0,6.0,5.0}),0.00001); }
  @Test public void test8_meanInRange_05() { assertEquals(8.5, DataProcessor.meanInRange(0,10,new int[]{8,9,10,11,12},new double[]{9.0,8.0,7.0,6.0,5.0}),0.00001); }
  @Test public void test8_meanInRange_06() { assertEquals(1.0, DataProcessor.meanInRange(0,10,new int[]{-2,-1,0,1,2},new double[]{4.0,3.0,2.0,1.0,0.0}),0.00001); }
  @Test public void test8_meanInRange_07() { assertEquals(1.5, DataProcessor.meanInRange(0,10,new int[]{-1,0,1,2,3},new double[]{4.0,3.0,2.0,1.0,0.0}),0.00001); }
  @Test public void test8_meanInRange_08() { assertEquals(5.0, DataProcessor.meanInRange(4,8,new int[]{0,2,4,6,8,10},new double[]{0.0,2.0,4.0,6.0,8.0,10.0}),0.00001); }
  @Test public void test8_meanInRange_09() { assertEquals(3.5, DataProcessor.meanInRange(4,8,new int[]{2,7,3,9,4,8},new double[]{1.0,2.0,3.0,4.0,5.0,6.0}),0.00001); }

  @Test public void test9_cleanList_00() { assertArrayEquals(new int[]{}, DataProcessor.cleanList(0,10,new int[]{})); }
  @Test public void test9_cleanList_01() { assertArrayEquals(new int[]{3}, DataProcessor.cleanList(0,10,new int[]{3})); }
  @Test public void test9_cleanList_02() { assertArrayEquals(new int[]{3,4,2,7}, DataProcessor.cleanList(0,10,new int[]{3,4,2,7})); }
  @Test public void test9_cleanList_03() { assertArrayEquals(new int[]{1,2,4,6}, DataProcessor.cleanList(0,10,new int[]{1,2,4,6,11})); }
  @Test public void test9_cleanList_04() { assertArrayEquals(new int[]{1,2,4,6}, DataProcessor.cleanList(0,10,new int[]{-1,1,2,4,6})); }
  @Test public void test9_cleanList_05() { assertArrayEquals(new int[]{1,2,4,6}, DataProcessor.cleanList(0,10,new int[]{-1,1,2,4,6,11})); }
  @Test public void test9_cleanList_06() { assertArrayEquals(new int[]{2,4}, DataProcessor.cleanList(2,6,new int[]{-1,1,2,4,6,11})); }
  @Test public void test9_cleanList_07() { assertArrayEquals(new int[]{2,4,6}, DataProcessor.cleanList(2,8,new int[]{1,1,1,2,4,6})); }
  @Test public void test9_cleanList_08() { assertArrayEquals(new int[]{2,4,6}, DataProcessor.cleanList(2,8,new int[]{2,1,1,1,4,6})); }
  @Test public void test9_cleanList_09() { assertArrayEquals(new int[]{2,4,6}, DataProcessor.cleanList(2,8,new int[]{1,2,1,4,1,6,1,8,10})); }

  @Test public void test10_nearestNeighbor_00() { assertEquals(5.0, DataProcessor.nearestNeighbor(5.0,new double[]{}),0.00001); }
  @Test public void test10_nearestNeighbor_01() { assertEquals(2.0, DataProcessor.nearestNeighbor(5.0,new double[]{2.0}),0.00001); }
  @Test public void test10_nearestNeighbor_02() { assertEquals(4.9, DataProcessor.nearestNeighbor(5.0,new double[]{4.9,5.8}),0.00001); }
  @Test public void test10_nearestNeighbor_03() { assertEquals(4.9, DataProcessor.nearestNeighbor(2.5,new double[]{4.9,5.8}),0.00001); }
  @Test public void test10_nearestNeighbor_04() { assertEquals(2.7, DataProcessor.nearestNeighbor(2.5,new double[]{2.0,2.7}),0.00001); }
  @Test public void test10_nearestNeighbor_05() { assertEquals(2.6, DataProcessor.nearestNeighbor(2.5,new double[]{2.8,2.6,2.7}),0.00001); }
  @Test public void test10_nearestNeighbor_06() { assertEquals(2.4, DataProcessor.nearestNeighbor(2.5,new double[]{1.2,2.4,2.1}),0.00001); }
  @Test public void test10_nearestNeighbor_07() { assertEquals(2.0, DataProcessor.nearestNeighbor(2.5,new double[]{2.0,3.0}),0.00001); }
  @Test public void test10_nearestNeighbor_08() { assertEquals(3.0, DataProcessor.nearestNeighbor(2.5,new double[]{3.0,2.0}),0.00001); }
  @Test public void test10_nearestNeighbor_09() { assertEquals(2.6, DataProcessor.nearestNeighbor(2.5,new double[]{3.0,2.0,1.0,4.2,3.5,3.1,2.6,2.3,2.2}),0.00001); }
  
  /*
  // HONORS SECTION:
  @Test public void testH_kNearestNeighbors_00() { assertArrayEquals(new double[]{1.0}, DataProcessor.kNearestNeighbors(1,0.0,new double[]{1.0}),0.00001); }
  @Test public void testH_kNearestNeighbors_01() { assertArrayEquals(new double[]{1.0,2.0}, DataProcessor.kNearestNeighbors(2,0.0,new double[]{1.0,2.0}),0.00001); }
  @Test public void testH_kNearestNeighbors_02() { assertArrayEquals(new double[]{1.0,2.0}, DataProcessor.kNearestNeighbors(2,0.0,new double[]{2.0,1.0}),0.00001); }
  @Test public void testH_kNearestNeighbors_03() { assertArrayEquals(new double[]{1.0,2.0}, DataProcessor.kNearestNeighbors(2,0.0,new double[]{2.0,1.0,3.0}),0.00001); }
  @Test public void testH_kNearestNeighbors_04() { assertArrayEquals(new double[]{0.5,1.5,2.0}, DataProcessor.kNearestNeighbors(3,0.0,new double[]{2.0,1.5,3.2,5.2,0.5}),0.00001); }
  @Test public void testH_kNearestNeighbors_05() { assertArrayEquals(new double[]{2.1,3.0,2.0,3.2}, DataProcessor.kNearestNeighbors(4,2.5,new double[]{3.0,1.5,3.2,2.0,5.2,0.5,2.1,4.1}),0.00001); }
  @Test public void testH_kNearestNeighbors_06() { assertArrayEquals(new double[]{}, DataProcessor.kNearestNeighbors(1,5.0,new double[]{}),0.00001); }
  @Test public void testH_kNearestNeighbors_07() { assertArrayEquals(new double[]{1.0}, DataProcessor.kNearestNeighbors(2,5.0,new double[]{1.0}),0.00001); }
  @Test public void testH_kNearestNeighbors_08() { assertArrayEquals(new double[]{}, DataProcessor.kNearestNeighbors(0,5.0,new double[]{1.0}),0.00001); }
  @Test public void testH_kNearestNeighbors_09() { assertArrayEquals(new double[]{0.0,1.0}, DataProcessor.kNearestNeighbors(4,0.0,new double[]{0.0,1.0}),0.00001); }
  */
  
}