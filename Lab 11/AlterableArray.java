public abstract class AlterableArray {
  protected int[] values;
  protected int[] temp;
 
  /** A constructor which sets the 'values' array to its initial value.
    * 
    * @param values The array to use for the instance variable 'values'. 
    */
  public AlterableArray(int[] values) {
    this.values = new int[values.length];
    System.arraycopy(values,0, this.values,0, values.length);
    temp = null;
  }

  /** Make a secondary array, using the parameter to help determine
    * the size.  This method is responsible for creating a new temp array,
    * which will then be used to store values from the original array.
    *
    * @param n A paramter used to determine the size of the new array.
    */
  public abstract void makeSecondary(int n);
  
  /** Decimating is the process of removing elements from an original input
    * array to produce a new one.  Internally, this class stores data in
    * an array called 'values'.  This method will use the backup array called
    * 'temp' to copy only some of the values from the original array to help
    * with decimation.  For example, if the original values array is
    * {10, 9, 8, 7} and a length-2 temp array is created (using the 
    * makeSecondary() method), the resulting array will be {10, 8}.
    * 
    * @param n Used to determine the number of elements in the new array.
    */
  public void decimate(int n) {
    
    makeSecondary(n);
    
    // do some size accounting
    int size = temp.length;
    if (size > values.length) size = values.length;
    int oldsize = values.length;
    int dy = 0, dx = 0;
    
    // copy over the elements from the old array
    int j = 0;
    for (int i = 0;  i < oldsize;  i++) {
      if (dy >= dx && size > 0) { 
        temp[j] = values[i]; 
        dx += oldsize;
        j++;
      }
      dy += size;
    }
    
    // make the old array into the new one.
    values = temp;
    temp = null;
  }
  
  /** A getter which provides the number of elements in the array.
    * @return The number of elements in the array.
    */
  public int size() { return values.length; }
  
  /** A getter which accesses the ith element in the array.
    *
    * @param i The index of the element to be retrieved.
    * @return The value of the requested array element.
    */
  public int get(int i) { return values[i]; }
  
  /** A setter which sets the ith element in the array to the specified
    * value.
    * 
    * @param i The index of the element to be set.
    * @param v The new value of the array element.
    */
  public void set(int i, int v) { values[i] = v; }
  
  /** Prints out the value of the current 'values' array using the static
    * print(int[]) method defined below.pplied to each element.
    */
  public void print() { print(values); }
    
  /** A static helper method which prints out the inputted array to the
    * terminal.
    * 
    * @param array An array to print to the terminal.
    */
  public static void print(int[] array) {
    String s = "{}";
    
    // if the array is longer than one, build up the string to be printed
    if (array.length > 0) {
      s = "{" + array[0];
      for (int i = 1;  i < array.length;  i++) s += ", " + array[i];
      s += "}";
    }
    
    // print the string
    System.out.println(s);
  }
}
  