public class SortSearch {
    public static int findFirstDist(int[] array, int v, int d) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= (v - d) && array[i] <= (v - d)) {
                return i;
            }
        }
        return -1;
    }

    public static void sortDist(int[] array, int v) {
        insertionSort(array, 0, v);

    }

    // public helper method
    public static void insertionSort(int [] array, int i, int v){
        if (i>array.length-1) {return;}
        int temp = array[i];
        int index = i;
        int dist = Math.abs(temp-v);
        while(index>0){
          if (Math.abs(array[index-1])>temp){
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