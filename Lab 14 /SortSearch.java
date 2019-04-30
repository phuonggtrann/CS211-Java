public class SortSearch {
    public static int findFirstDist(int[] array, int v, int d) {
        int ans =-1; // initialize
        for (int i = 0; i < array.length; i++) { // for loop
            if (array[i] >= (v - d) && array[i] <= (v + d)) { // condition compare 
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void sortDist(int[] array, int v) {
        insertionSort(array, 0, v); // calling helper method with initial index at 0

    }

    // public helper method
    public static void insertionSort(int [] array, int i, int v){
        if (i==array.length-1) {return;} // stop condition for sort algorithm
        // initialize needed variable
        int temp = array[i+1]; 
        int index = i+1;
        while(index>0){ // while loop to rearrrange index
            if (Math.abs((array[index]-v)) < Math.abs((array[index-1]-v))) { // Math.abs to find the real distance
                // if it's closer then rearrange
                array[index]=array[index-1]; 
                array[index-1]=temp;
                
            }
            index--; // decrement index
        }
        insertionSort(array, i+1, v); // recursive call, increment index by 1
          
    }

    public static int findKthFromV(int[] array, int k, int v) {
        int arr[] = array; // create array copy
        sortDist(arr, v); // sorted array by invoking helper method
        return arr[k - 1]; // return array's k-1 index
    }
}