public class Interval implements Splittable {

    private final int LOW;
    private final int HIGH;
    private final int BOUNDARY;

    public Interval(int a, int b) {
        this.LOW=a;
        this.HIGH=b;
        this.BOUNDARY=b-a;    
    }
    public int low() {
        return this.LOW;
    }
    public int high() {
        return this.HIGH;
    }
    public int size() {
        return this.HIGH-this.LOW;
    }
    @Override public String toString() {
        return String.format("[%d, %d)", this.LOW, this.HIGH);
    }
    public Interval firstHalf() {
        if (this.BOUNDARY%2==0) {
            return new Interval(this.LOW, this.BOUNDARY/2+this.LOW); 
        }
        else {return new Interval(this.LOW, this.BOUNDARY/2+this.LOW+1);} //String.format("[%d, %d)", this.LOW, this.HIGH/2+this.LOW+1);} 
    }
    public Interval secondHalf() {
        if (this.BOUNDARY%2==0) {
            return new Interval(this.BOUNDARY/2+this.LOW, this.HIGH); //String.format("[%d, %d)", this.HIGH/2+this.LOW, this.HIGH);
        }
        else {return new Interval(this.BOUNDARY/2+this.LOW+1, this.HIGH);} //String.format("[%d, %d)", this.HIGH/2+this.LOW+1,this.HIGH);}
    }
}