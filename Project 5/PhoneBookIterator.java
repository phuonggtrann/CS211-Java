import java.io.*;
import java.util.*;

public class PhoneBookIterator<E> implements Iterator<E> {
    private ArrayList<E> arrList;
    private int pos;

    public PhoneBookIterator(ArrayList<E> arr) {
        this.arrList = arr;
        this.pos=0;
    }
    @Override public boolean hasNext() {
        return pos<this.arrList.size();
    }
    @Override public E next() throws NoSuchElementException{
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        else {
            pos++;
            return this.arrList.get(pos);
        }
    }
}