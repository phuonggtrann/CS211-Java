public class SplittableString implements Splittable{
    private String s; // Declare
    public SplittableString(String s) { // Constructors - initialize variable
        this.s=s;
    }
    public int size() { // interface method
        return (this.s).length(); // return String length
    }
    public int length() { // class method
        return (this.s).length(); // return String length
    }
    public char charAt(int i) { // return character at index i of String
        return (this.s).charAt(i);
    }
    @Override public String toString() {
        return this.s.toString(); // return toString by calling toString() method
    }
    // helper method - return true if even and false if odd
    public boolean strEven() {
        if (this.length()%2==0) {return true;}
        else {return false;} 
    }
    public SplittableString firstHalf() {
        String s1=""; // Declare and initialize 
        if (this.strEven()) { // If even
            s1=(this.s).substring(0,this.length()/2); // firstHalf=start to midpoint
        }
        else { // if odd
            s1=(this.s).substring(0, this.length()/2+1); // firstHalf=start to midpoint+1
        }
        return new SplittableString(s1); // return object of type SplittableString
    }
    public SplittableString secondHalf() {
        // The same of firstHalf but go from midpoint(+1) to end
        String s2="";
        if (this.strEven()) {
            s2=this.s.substring(this.length()/2, this.length());
        }
        else {
            s2=this.s.substring(this.length()/2+1, this.length());
        }
        return new SplittableString(s2); // same type return of firstHalf()
    }
    
}