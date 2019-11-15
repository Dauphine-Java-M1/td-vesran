package fr.dauphine.ja.tranyves.iterable;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

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

    public static Iterable<Integer> panel2(final int firstValue, final int lastValue) {
        return new Iterable<Integer>() {

            @Override
            public Iterator iterator() {
                return panel1(firstValue, lastValue);
            }

        };
    }

    public static AbstractList<Integer> panel(final int firstValue, final int lastValue) {

        if (firstValue > lastValue) {
            throw new IllegalArgumentException("First bound cannot be greater than the second bound.");
        }
        
        return new AbstractList<Integer>() {

            @Override
            public int size() {
                return lastValue - firstValue + 1;
            }

            @Override
            public Integer get(int index) {
                int value = firstValue + index;

                if (value > lastValue) {
                    throw new IndexOutOfBoundsException();
                }

                return value;
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

        System.out.println("Start 3");
        List<Integer> l = panel(3, 6);
        for (int i : l) {
            System.out.println(i);
        }
        System.out.println(l.get(1));

    }
}
