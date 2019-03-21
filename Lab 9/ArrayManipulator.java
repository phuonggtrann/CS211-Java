public class ArrayManipulator {
    private int[] arr;
    public ArrayManipulator(int size) {
        this.arr = new int[size];
    }
    public void set(int i, int v) {
        this.arr[i]=v;
    }
    public int get(int i) throws ZeroException {
        if (this.arr[i]==0) {
            throw new ZeroException();
        }
        else {return (this.arr[i]);}
    }
    public int getMult(int i, int m) throws ZeroException {
        if (this.arr[i]*m==0) {
            throw new ZeroException();
        }
        else {return (this.arr[i]*m);}
    }
    public int getDiv(int i, int d) throws ZeroException{
        if ((this.arr[i]/d)==0) {
            throw new ZeroException();
        }
        else {return this.arr[i]/d;}
    }
    public void print(int mode, int i, int v) {
        try {
            if (mode==0) {
                System.out.println(this.get(i));
            }
            if (mode==1) {
                System.out.println(this.getMult(i,v));
            }
            if (mode==2) {
                System.out.println(this.getDiv(i,v));
            }
        }
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