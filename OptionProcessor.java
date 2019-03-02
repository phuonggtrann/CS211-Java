import java.util.ArrayList;
public class OptionProcessor {
    private ArrayList<Option> opt;
    private String fullStr;
    public OptionProcessor() {
        this.opt= new ArrayList<Option>();
        this.fullStr="";
    }
    public void add(Option o) {
        this.opt.add(o);
    }
    public void process(String[] inputs) {
        for (Option a:opt) {
            for (int b=0; b<inputs.length; b++) {
                if (a.match(inputs, b)) {break;};
            }
        }
    }
    @Override public String toString() {
        for (Option c:opt) {
            this.fullStr += c.toString() +"\n";
        }
        return this.fullStr;
    }
}