public class ArrayManipulator {
    private int[] arr; // declare internal array
    public ArrayManipulator(int size) { // constructor take in size of array
        this.arr = new int[size]; // initialize internal array
    }
    // change value of array index i to value v
    public void set(int i, int v) {
        this.arr[i]=v; 
    }
    // return the value at ith index of the internal array
    public int get(int i) throws ZeroException {
        if (this.arr[i]==0) {
            throw new ZeroException(); // throw exception if arr[i] is 0
        }
        else {return (this.arr[i]);} // otherwise, return answer
    }
    // return the product of arr[i] and value m
    public int getMult(int i, int m) throws ZeroException {
        if (this.arr[i]*m==0) {
            throw new ZeroException(); // throw exception if the prodcut is 0
        }
        else {return (this.arr[i]*m);} // otherwise, return answer
    }
    // The same above, but doing division instead
    public int getDiv(int i, int d) throws ZeroException{
        if ((this.arr[i]/d)==0) {
            throw new ZeroException();
        }
        else {return this.arr[i]/d;}
    }
    // call appropriate method depend on the value of mode given
    public void print(int mode, int i, int v) {
        try {
            if (mode==0) { // if mode is 0, call get()
                System.out.println(this.get(i));
            }
            if (mode==1) { // if mode is 1, call getMult()
                System.out.println(this.getMult(i,v));
            }
            if (mode==2) { // if mode is 2, call getDiv()
                System.out.println(this.getDiv(i,v));
            }
        }
        // Catch appropriate exception
        catch(ArithmeticException e1) {
            System.out.println("divide by zero");
        }
        catch(ArrayIndexOutOfBoundsException e2) {
            System.out.println("out of bounds");
        }
        catch(ZeroException e3) {
            System.out.println("zero result");
        }
    }
}