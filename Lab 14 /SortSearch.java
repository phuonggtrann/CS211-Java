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
        insertionSort(array, 0, v);

    }

    // public helper method
    public static void insertionSort(int [] array, int i, int v){
        if (i==array.length-1) {return;} // stop condition for sort algorithm
        // initialize needed variable
        int temp = array[i+1]; 
        int index = i+1;
        while(index>0){
            if (Math.abs((array[index]-v)) < Math.abs((array[index-1]-v))) {
                array[index]=array[index-1];
                array[index-1]=temp;
                
            }
            index--;
        }
        insertionSort(array, i+1, v);
          
    }

    public static int findKthFromV(int[] array, int k, int v) {
        int arr[] = array;
        sortDist(arr, v);
        return arr[k - 1];
    }
}