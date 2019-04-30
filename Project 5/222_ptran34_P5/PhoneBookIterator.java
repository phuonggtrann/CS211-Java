import java.io.*;
import java.util.*;

public class PhoneBookIterator<E> implements Iterator<E> {
    private ArrayList<E> arrList;
    private int pos;
    
    // constructor
    public PhoneBookIterator(ArrayList<E> arr) {
        // internal elements
        this.arrList = arr;
        this.pos=0;
    }
    @Override public boolean hasNext() {
        return pos<this.arrList.size(); // check if there is still element after pos
    }
    @Override public E next() throws NoSuchElementException{
        if (!hasNext()) { // if hasNext()=false
            throw new NoSuchElementException(); // throws exception
        }
        else { // if hasNext()=true
            pos++; // increment pos
            return this.arrList.get(pos); // return array's element at pos index
        }
    }
}