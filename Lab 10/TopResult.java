public class TopResult<T extends Comparable<T>> { // Declare generic class, extend compareble class 
    private T top; // declare variable

    public TopResult() { // constructor to initialize variable
        this.top = null; 
    }

    public void newResult(T a) { // compare parameter object to "this.top" object
        if (this.top == null) { // if there is no this.top yet, assign that value to this.top
            this.top = a;
        } else {
            if (a.compareTo(this.top) > 0) { // else compare and if method return a positive, assign new this.top
                this.top = a;
            }
        }
    }

    public T getTopResult() { // getter
        if (this.top == null) {
            return null;
        } else {
            return this.top;
        }
    }

    public String toString() { // calling toString method
        if (this.top == null) {
            return null;
        } else {
            return this.top.toString();
        }
    }
}