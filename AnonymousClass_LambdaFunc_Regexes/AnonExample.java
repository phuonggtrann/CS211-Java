import java.util.*;

public class AnonExample {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>() { // declare whole new class but didn't give it a name 
            // Below is anonymous class, no constructor
            public boolean add(E element) {
                System.out.println("We just added the element to the list");
                return super.add(element);
            }
        };
        // We just added the nth element to the list: xyz
    }
}

