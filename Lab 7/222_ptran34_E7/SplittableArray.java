import java.util.ArrayList;

public class SplittableArray extends ArrayList<String> implements Splittable {
    public SplittableArray() {
        super(); // Call super since this is subclass

    }

    public SplittableArray firstHalf() {
        // Declare and initialize
        int size = super.size();
        int mid = super.size() / 2; 
        // if the sie is odd, midpoint (mid) increase by 1 
        if (size % 2 != 0) {
            mid++;
        }
        SplittableArray firstH = new SplittableArray(); // create object type SplittableArray
        if (size > 1 && mid>0) { // Size>1 b/c if size =1 then mid =0 which loop won't start
            for (int i = 0; i < mid; i++) {
                firstH.add(super.get(i)); // Append value in "object"
            }
        }
        else if (size==1) {firstH.add(super.get(0));} // If size =1 then only firstHalf get elements
       // Second half will empty therefoer no need this for secondHalf 
        return firstH;
    }

    public SplittableArray secondHalf() {
        // This works 100% percent like firstHalf excluding else if part since it's no need 
        int size = super.size();
        int mid = super.size() / 2;
        if (size % 2 != 0) {
            mid++;
        }
        // Same condition for for-loop and create new object to append value in
        SplittableArray secondH = new SplittableArray();
        if (size > 1 && mid>0) { 
            for (int i = mid; i < super.size(); i++) {
                secondH.add(super.get(i));
            }
        }
        return secondH; // return
    }
}
