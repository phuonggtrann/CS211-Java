public class ArrayFactory {
    private int[] arr;
    private int arrLength;
    public ArrayFactory(int arrLength) {
        this.arrLength = arrLength;
        this.arr = new int[this.arrLength];
    }
    public int getLength(){
        return this.arrLength;
    }
    public void setLength(int arrLength){
        this.arrLength = arrLength;
    }
    public int[] getArray() {
        this.arr= new int[this.arrLength];
        return this.arr;
    }
    public String toString() {
        return "Length " + getLength();
    }
}