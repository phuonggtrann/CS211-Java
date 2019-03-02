// sub class, in heritance from Option (parents class)
public class StringOption extends Option {
    // Declare variable
    private String defValue;
    // Constructor to initialize
    public StringOption(String key, String name, String defValue) {
        super(key, name);
        this.defValue = defValue;

    }
    // return numSlots as 2
    @Override public int numSlots(){
        return 2;
    }
    /// getter for defValue
    public String getValue() {
        return this.defValue;
    }
    @Override public boolean match(String[] s, int i) {
        // Call in method from parents class using super()
        if (super.match(s,i)){
            this.defValue=s[i+1]; //if true, save next value
            return true;
        } 
        else {return false;} // if false, return false
    }
    @Override public String toString() {
        // Override toString with new format 
        return String.format("%s: %s", super.getName(), getValue());
    }
}