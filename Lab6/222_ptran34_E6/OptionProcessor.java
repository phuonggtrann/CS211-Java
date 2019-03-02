// import ArrayList to use its method
import java.util.ArrayList;
public class OptionProcessor {
    // Declare variables, ArrayList type Option class
    private ArrayList<Option> opt;
    private String fullStr;
    public OptionProcessor() {
        // Initialize under the constructor
        this.opt= new ArrayList<Option>();
        this.fullStr="";
    }
    public void add(Option o) {
        this.opt.add(o); // appending object to the ArrayList
    }
    public void process(String[] inputs) {
        for (Option a:opt) { // go through every elements in ArrayList
            // using nested loop to compare every element
            for (int b=0; b<inputs.length; b++) {
                // brreak if key found
                if (a.match(inputs, b)) {break;};
            }
        }
    }
    @Override public String toString() {
        // go through every element in the ArrayList and append it to String
        // /n to get newline after each element
        for (Option c:opt) {
            this.fullStr += c.toString() +"\n";
        }
        return this.fullStr;
    }
}