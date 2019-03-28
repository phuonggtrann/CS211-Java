public class TopResult< T extends Comparable<T> > {
    private T top;
    public TopResult() {
        this.top=null;
    }
    public void newResult(T a) {
        if (this.top==null) {this.top=a;}
        else{
            if (a.compareTo(o)>0) {
                this.top=a;
            }
        }
    }
    public T getTopResult() {}
}