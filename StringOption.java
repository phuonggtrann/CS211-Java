public class StringOption extends Option {
    private String defValue;
    public StringOption(String key, String name, String defValue) {
        super(key, name);
        this.defValue = defValue;

    }
    @Override public int numSlots(){
        return 2;
    }
    public String getValue() {
        return this.defValue;
    }
    @Override public boolean match(String[] s, int i) {
        if (super.match(s,i)){
            this.defValue=s[i+1];
            return true;
        } 
        else {return false;}
    }
    @Override public String toString() {
        return String.format("%s: %s", super.getName(), getValue());
    }
}