import java.util.*; // import 

public class ListUtils { // this is our class

    public static <E> Collection<E> iterToCollection(Iterable<? extends E> iterable) {
        Collection<E> col = new ArrayList<E>(); // create an instance of Collection
        for (E e : iterable) { // Advance for loop to loop through 
            col.add(e); // and add element to the new Collection ArrayList
        }
        return col; // return appropriate answer 
    }

    public static <E> List<E> collToList(Collection<? extends E> coll) {
        List<E> ansList = new ArrayList<E>(); // create instance of list
        for (E e : coll) { // Do exactly like the static method above
            ansList.add(e);
        }
        return ansList; // return type List
    }

    public static <E> Map<Integer, E> listToMap(List <? extends E> list) {
        Map<Integer, E> ansMap = new HashMap<>(); // Create instance of Map
        for (int a=0; a<list.size(); a++) { // Since we need index as key, normal for loop is used
            ansMap.put(a, list.get(a)); // .put to create a key-value pair
        }
        return ansMap; // return the answer type map
    }
}