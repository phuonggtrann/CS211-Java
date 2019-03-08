import java.util.ArrayList;

public class SplittableArray extends ArrayList<String> implements Splittable {
    public SplittableArray() {
        super();

    }

    public SplittableArray firstHalf() {
        int size = super.size();
        int mid = super.size() / 2;
        if (size % 2 != 0) {
            mid++;
        }
        SplittableArray firstH = new SplittableArray();
        if (size > 1 && mid>0) {
            for (int i = 0; i < mid; i++) {
                firstH.add(super.get(i));
            }
        }
        else if (size==1) {firstH.add(super.get(0));}
        return firstH;
    }

    public SplittableArray secondHalf() {
        int size = super.size();
        int mid = super.size() / 2;
        if (size % 2 != 0) {
            mid++;
        }
        SplittableArray secondH = new SplittableArray();
        if (size > 1 && mid>0) {
            for (int i = mid; i < super.size(); i++) {
                secondH.add(super.get(i));
            }
        }
        return secondH;
    }
}
