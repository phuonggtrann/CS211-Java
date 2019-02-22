// Create a class
public class ArrayFactory {
    // Initialize
    private int[] arr;
    private int arrLength;
    // create constructor
    public ArrayFactory(int length) {
        this.arrLength = length;
        this.arr = new int[this.arrLength];
    }
    // getLength return length of the array
    public int getLength(){
        return this.arrLength;
    }
    // setLength change length of array by given length
    public void setLength(int arrLength){
        this.arrLength = arrLength;
    }
    // create new array with stored length
    public int[] getArray() {
        this.arr= new int[this.arrLength];
        return this.arr;
    }
    // return readable String
    public String toString() {
        return "Length " + getLength();
    }
}