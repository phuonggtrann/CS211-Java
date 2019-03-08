public class SplittableString implements Splittable{
    private String s;
    public SplittableString(String s) {
        this.s=s;
    }
    public int size() {
        return (this.s).length();
    }
    public int length() {
        return (this.s).length();
    }
    public char charAt(int i) {
        return (this.s).charAt(i);
    }
    @Override public String toString() {
        return this.s.toString();
    }
    public boolean strEven() {
        if (this.length()%2==0) {return true;}
        else {return false;}
    }
    public SplittableString firstHalf() {
        String s1="";
        if (this.strEven()) {
            s1=(this.s).substring(0,this.length()/2);
        }
        else {
            s1=(this.s).substring(0, this.length()/2+1);
        }
        return new SplittableString(s1);
    }
    public SplittableString secondHalf() {
        String s2="";
        if (this.strEven()) {
            s2=this.s.substring(this.length()/2, this.length());
        }
        else {
            s2=this.s.substring(this.length()/2+1, this.length());
        }
        return new SplittableString(s2);
    }
    
}