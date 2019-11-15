package fr.dauphine.ja.tranyves.iterable;

import java.util.Iterator;

public class Panel implements Iterator<Integer> {

    private int currentValue;
    private int lastValue;

    public Panel(int firstValue, int lastValue) {
        this.currentValue = firstValue;
        this.lastValue = lastValue;
    }

    @Override
    public boolean hasNext() {
        return this.currentValue <= this.lastValue;
    }

    @Override
    public Integer next() {
        return this.currentValue;
    }

    @Override
    public void remove() {
        // Do nothing
    }

    public static Iterator<Integer> panel1Old(int firstValue, int lastValue) {
        return new PanelIterator(firstValue, lastValue);
    }

    public static Iterator<Integer> panel1(final int firstValue, final int lastValue) {

        return new Iterator<Integer>() {

            private int currentValue = firstValue;

            @Override
            public boolean hasNext() {
                return currentValue <= lastValue;
            }

            @Override
            public Integer next() {
                return currentValue++;
            }

            @Override
            public void remove() {
                // Do nothing
            }
        };

    }

    public static Iterable<Integer> panel2(final int firstValue, final int lastValue) {
        return new Iterable<Integer>() {

            @Override
            public Iterator iterator() {
                return panel1(firstValue, lastValue);
            }

        };
    }

    public static void main(String [] args) {
        System.out.println("Start");

        Iterator<Integer> it = panel1(1, 5);
        for (; it.hasNext(); ){
            System.out.println(it.next());
        }

        System.out.println("Start 2");
        for (int i : panel2(1, 5)) {
            System.out.println(i);
        }

    }
}
