package fr.dauphine.ja.tranyves.iterable;

import java.util.Iterator;

public class PanelIterator implements Iterator<Integer> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next(){
        return null;
    }

    @Override
    public void remove() {
        // do something...
    }
}
