// child class of given abstract class
public class ShrinkFracArray extends AlterableArray {
    // constructor which take in arr to call super
    public ShrinkFracArray(int[] arr) {
        super(arr);
    }
    // Initialize the temp arr, using instruction given
    public void makeSecondary(int n) {
        if (n<=0) { // If given int is 0 or negative
            super.temp=new int[super.values.length];
        } else { 
        super.temp = new int[super.values.length/n];
        }
    }
    // main method    
    public static void main(String[] args) {
        // create and initialize array
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
        // create ShrinkFacArr which take in above array
        ShrinkFracArray sf = new ShrinkFracArray(arr1);
        // call in appropriate method for step 3 and 4 on the instructions
        sf.print(); // call print before decimate array
        sf.decimate(2); // decimate array
        sf.print(); // recall int to print new array
    }

}