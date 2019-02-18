public class DataProcessor {

    /** This method should return true if and only if every element in the
      * input array is in ascending order, meaning that none of the values
      * in the array are smaller than the previous element, and false 
      * otherwise.  For example, the array {1, 2, 5, 5, 6, 7, 8, 8, 8} 
      * would be in order.  An empty array is considered in order as well.
      */
    public static boolean inOrder(int[] values) {
      boolean ascend=true; // Declare value
      // if arrray is 0 or 1, no order checking needed
      if (values.length<2) {
        ascend = true;
      }
      else {
        // Check order of current value and their right neighbor
        // If neighbor is smaller then loop stop and return false
        for (int x=0; x<values.length-1; x++ ) {
          if (values[x] > values[x+1]) {
            ascend = false;
            break; // If disorder detected then stop the loop
          }
        }
      }
    return ascend; // return final answer
    }
 
    /** This method will return the smallest value found in the array.  For
      * example, for the array {4, 2, 3, 1, 5, 1}, the value 1 will be 
      * returned.  If the array is empty, then the built-in constant
      * Integer.MAX_VALUE may be returned.
      */
    public static int smallest(int[] values) {
    int smallest=0; // initialize variable
      if (values.length == 0) { // if array is empty
        smallest = Integer.MAX_VALUE; // return integer.MAX_VALUE
      }
      else { // If list is not empty
        smallest = values[0]; // assign answer with 1st value in array
        for (int a=0; a<values.length; a++){ // loop through array
          if (values[a]<smallest) { // if there is another smaller value
            smallest = values[a]; // assign answer with that value
          }
        }
      }
    return smallest; // return final answer
    }
 
    /** This method will return the smallest value found in the array which
      * is larger than the input n.  For example, for the input n=2 and the
      * array {4, 2, 3, 1, 5, 1}, the value 3 will be returned.  If no such
      * value exists, then the method will return the value n.
      */
    public static int smallestGreaterThanN(int n, int[] values) {
      int smallestGreater=n; // initialize variable
      if (values.length==0){ // Check if the array is empty
        smallestGreater=n;
      }
      else { // if array isn't empty
        for (int a=0; a<values.length; a++) { // go through every element in array
          if (values[a]>n) { //if the looped element is greater than n
            smallestGreater=values[a];//assign that element to smallestGGreater
            break;
          }
        } // go through every element again to find the smallest but still bigger than n
        for (int b=0; b<values.length; b++) {
          if (values[b]<smallestGreater && values[b]>n) {
            smallestGreater = values[b];
          }
        }
      }
      return smallestGreater; // return final answer
    }
 
    /** Return the total number of distinct values contained in the
      * input array.  For example, the array {2, 2, 5, 1, 7, 4, 7} has
      * 5 distinct values (the numbers 1, 2, 4, 5, and 7).
      * 
      * Hint: calls to smallest() and smallestGreaterThanN() may help
      * you solve this.
      */
    public static int numDistinct(int[] values) {
      int count = 1; //setting count to start at one since the smallest value is used to initialize
      if (values.length ==0) {
        count=0; //if the values list is empty, there is no/zero distinct value
      }
      else{
        int n= smallest(values); //setting the value to be the smallest
        for(int x=0; x<values.length; x++){ //loop through as  many elements as there are in the values array
          if(smallestGreaterThanN(n, values)!=n){// if there is a different value
            count++; // increase the count
            n=smallestGreaterThanN(n, values);
            //find next n
          }
        }
      }
      return count; //return the count
    }

    /** Determines the number of times element v occurs within the array
      * of values. For example, in the array {1, 2, 5, 5, 3, 2}, the value
      * v=2 occurs twice.
      */  
    public static int numOccurrences(int v, int[] values) {
     int countV = 0;
      if (values.length == 0) {
        countV=0;
      }
      else {
        for (int a=0; a<values.length;a++) {
          if (values[a]==v) {
            countV++;
          }
        }
      }
      return countV;
    }

    /** Determines the number of elements from the array of values which
      * have a value within the range [a, b) (that is, between a and b,
      * including a but not including b).  For example, if the input array
      * is {1, 2, 3, 4, 2, 3, 4, 3, 4, 4} with a=2 and b=4, the result would
      * be 5 (because there are two 2's and three 3's).
      */
    public static int numInRange(int a, int b, int[] values) {
      // initial variable and check whether the array is empty
     int countRange = 0;
     if (values.length == 0) {
      countRange=0;
    }
    else {
      for (int i=0; i<values.length; i++) { // go through every element in the array
        if (values[i]>=a && values[i]<b) { // if the element is in range
          countRange++; // increase range by 1
        }
      }
    }
    return countRange; // return final answer
    }
 
    /** Finds the arithmetic mean (the average) of the list of numbers.  For
      * example, if the input is {1, 2, 3, 4}, then the mean is 2.5.
      * 
      * Hint: the input values are integers, but the output most likely
      * won't be.  Do you need to account for that somehow?
      */
    public static double mean(int[] values) {
      // initialize
     double avg = 0;
     double total = 0;
     double count = values.length; // total element in the array
     if (values.length==0) { // check if the array is empty
       avg = 0;
     }
     else { // if array not empty
       for (int a=0; a<count; a++) { // go through every element
         total = total + values[a]; // adding every element aka find total
       }
       avg = total/count; // divide by numberr of element to find average
     }
     return avg; // return final answer
    }
 
    /** The input of this method includes two arrays, which you may assume
      * are the same size, and whose entries correspond to one another 
      * (for example, the first array may be a list of ages of several people,
      * while the second array may be a list of the heights of the same people).
      * The method will compute the average of values from the second array, 
      * but only when the values correspond to entries from the first list 
      * within the range [a, b).  For example, if the first array is a list
      * of ages, {19, 15, 20, 25, 30, 5, 32}, the second array is a list 
      * of heights in feet, {5.2, 4.9, 5.9, 6.1, 5.85, 3.2, 5.7}, and the
      * range is a=20, b=30, then it would give the average of people aged
      * 20-29, which in this example would be 6.0.
      */
    public static double meanInRange(int a, int b, int[] list, double[] values) {
      // initialize variable
     double heightAvg = 0;
     double count = 0;
     double total = 0;
     for (int i=0; i<list.length; i++){ // go through every element in array
       if (list[i]>=a && list[i]<b) { // check whether the element is in range
         total = total + values[i]; /// finding the total of element that in range
         count ++; // keep track of number of element that in range
       }
     }
     heightAvg = total/count; // finding average
     return heightAvg; // return final answer
    }
 
    /** When performing data analysis, it is often necessary to first clean
      * obvious outliers from the data set, because these may be the result
      * of a clerical error and could throw off analysis.  As an example,
      * when studying medical data, sometimes you will see "zombies" (people
      * with hospital visits occurring after their recorded date of death) or
      * "vampires" (people who are hundreds of years old, because their date
      * of birth was left blank and defaulted to zero when entered into the 
      * the system).  This method will eliminate entries from the array of
      * input values which are outside of the range [a, b), and return the list
      * of entries which remain. For example, for the input a=0, b=125, and
      * {10, -1, 20, 30, 25, 125, 40, 200}, the array which is returned would
      * be {10, 20, 30, 25, 40}.
      * 
      * Hint 1: you don't need to delete elements from the input array. You
      * can create a whole new array to return instead.
      * Hint 2: it may help to know how big your output array is before you
      * begin.  Would any of the other methods you've written help here?
      */
    public static int[] cleanList(int a, int b, int[] list) {
       int listLen = numInRange(a, b, list); // finding number of element in new list
       int ind = 0; // index of new list
       int[] cleanArr = new int[listLen]; // declare new array 
       for (int i=0; i<list.length; i++) { // go through every element in given list
        if (list[i]>=a && list[i]<b) { // if the element is in range
          cleanArr[ind] = list[i];  // replace it with default 0 in the new array
          ind++;      // increase index by 1 after replacing
        }
    }
    return cleanArr; // return final array
  }
 
    /** Return the value of the nearest neighbor to v.  If v is some value,
      * look through the list of values to find the one which is closest
      * in value to v.  For example, if v=1.2 and the input array is
      * {3.2, 1.7, 2.4, 0.9, 4.4}, then the method will return 0.9 because
      * it is the value closest to 1.2 in the list.  If there is a tie (for
      * example, both 0.9 and 1.5 are the same distance to 1.2), then return
      * the one which occurs first in the list.  If the list is empty, then
      * return v.
      */
    public static double nearestNeighbor(double v, double[] values) {
      // initialize using variables
      double dist=v; 
      double nearV =v;
     if (values.length==0) { // check whether the array is empty
       nearV = v; 
     }
     else { // if not
       for (int i=0; i<values.length; i++) { // go through every element in the array
         // if-else if is used to prevent negative result
         if ((values[i]>v) && (values[i]-v < dist)) {
           dist = values[i]-v; /// keep track of smallest distance
           nearV = values[i];
         }
         else if ((v>values[i]) && (v-values[i] < dist)) {
           dist = v-values[i];
           nearV = values[i];
         }
         else if (v==values[i] && 0<dist) {
           dist=0;
           nearV=values[i];
         }
         }
       }
       return nearV; // return final answer
     }


    /** HONORS SECTION ONLY 
      * (if you are not in the honors section, you do not need to complete 
      * this part, and it is not worth any points if you do):
      * 
      * Find and return the k elements which are closest to v in value, in
      * order of increasing distance from v.  For example, if v=1.2, k=3,
      * and the input array is {3.2, 1.7, 2.4, 0.9, 4.4}, then the method 
      * will return {0.9, 1.7, 2.4}.  If k is larger than the length of
      * the input array, then the output array should only have as many values
      * as you have in the original array.
      */
    public static double[] kNearestNeighbors(int k, double v, double[] values) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        throw new RuntimeException("not implemented!");  
    }

}