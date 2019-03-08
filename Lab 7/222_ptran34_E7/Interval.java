public class Interval implements Splittable {
    // Declare variables
    private final int LOW;
    private final int HIGH;
    private final int BOUNDARY;

    // Constructor to initialize variable
    public Interval(int a, int b) {
        this.LOW=a;
        this.HIGH=b;
        this.BOUNDARY=b-a;    
    }
    public int low() { // Return type int, lower bound of the interval
        return this.LOW;
    }
    public int high() { // Return type int, higher bound of the interval
        return this.HIGH;
    }
    public int size() { // Return the size of the interval
        return this.HIGH-this.LOW;
    }
    @Override public String toString() { // return readable string
        return String.format("[%d, %d)", this.LOW, this.HIGH);
    }
    public Interval firstHalf() { 
        if (this.BOUNDARY%2==0) { // If the boundary is even, first half is from start point to half of boundary + start point
            return new Interval(this.LOW, this.BOUNDARY/2+this.LOW); 
        } // If the boundary is odd, first half is from start point to half of boundary + start point + 1
        else {return new Interval(this.LOW, this.BOUNDARY/2+this.LOW+1);} 
    }
    public Interval secondHalf() { // The same as above but from "endpoint" of first half to higher bounce
        if (this.BOUNDARY%2==0) {
            return new Interval(this.BOUNDARY/2+this.LOW, this.HIGH); 
        }
        else {return new Interval(this.BOUNDARY/2+this.LOW+1, this.HIGH);} 
    }
}