public class Option {
    private String key;
    private String name;
    private boolean keyFound;
    private String fullStr;
    public Option(String key, String name) {
        this.key=key;
        this.name=name;
        this.keyFound=false;
        this.fullStr="";
    }
    public boolean isFound(){
        return this.keyFound;
    }
    public String getKey() {
        return this.key;
    }
    public String getName(){
        return this.name;
    }
    public int numSlots(){
        return 1;
    }
    public boolean match(String[] s, int i) {
        if (i<=s.length-1){
            if (s[i].equals(this.key)) {
                this.keyFound = true;
            }
            else {this.keyFound=false;}
        }
        return this.keyFound;
    }
    @Override public String toString() {
        if (this.keyFound) {
            this.fullStr= String.format("%s: yes",this.name);
        }
        else {
            this.fullStr= String.format("%s: no",this.name);
        }
        return this.fullStr;
    }
}