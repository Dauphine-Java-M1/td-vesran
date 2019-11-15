package fr.dauphine.ja.tranyves.iterable;

import java.util.Iterator;

public class PanelIterator implements Iterator<Integer> {

    private int currentValue;
    private int lastValue;

    public PanelIterator(int firstValue, int lastValue) {
        this.currentValue = firstValue;
        this.lastValue = lastValue;
    }

    @Override
    public boolean hasNext() {
        return this.currentValue <= this.lastValue;
    }

    @Override
    public Integer next() {
//        int value = this.currentValue;
//        this.currentValue++;
        return this.currentValue++; // Return value, next inc
    }

    @Override
    public void remove() {
        // do nothing
    }
}
