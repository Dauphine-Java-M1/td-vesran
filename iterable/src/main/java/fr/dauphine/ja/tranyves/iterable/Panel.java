package fr.dauphine.ja.tranyves.iterable;

import java.util.Iterator;

public class Panel {

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

    public static void main(String [] args) {
        System.out.println("Start");

        Iterator<Integer> it = panel1(1, 5);
        for (; it.hasNext(); ){
            System.out.println(it.next());
        }

    }
}
