public class Option {
    // Declare variable
    private String key;
    private String name;
    private boolean keyFound;
    private String fullStr;
    // Constructor to initialize
    public Option(String key, String name) {
        this.key=key;
        this.name=name;
        this.keyFound=false; // initialize as false
        this.fullStr="";
    }
    // getter method for keyFound
    public boolean isFound(){
        return this.keyFound;
    }
    // getter for key
    public String getKey() {
        return this.key;
    }
    // getter for name
    public String getName(){
        return this.name;
    }
    // return numSlots as 1
    public int numSlots(){
        return 1;
    }
    public boolean match(String[] s, int i) {
        if (i<=s.length-1){ // Make sure i is not out of range
            // If key found set it to true
            if (s[i].equals(this.key)) {
                this.keyFound = true;
            }
            // If not, set it to false
            else {this.keyFound=false;}
        }
        return this.keyFound;
    }
    @Override public String toString() {
        // create string as shown formatted and return fullString
        if (this.keyFound) {
            this.fullStr= String.format("%s: yes",this.name);
        }
        else {
            this.fullStr= String.format("%s: no",this.name);
        }
        return this.fullStr;
    }
}