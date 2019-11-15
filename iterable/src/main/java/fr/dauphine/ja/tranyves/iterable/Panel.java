package fr.dauphine.ja.tranyves.iterable;

import java.util.Iterator;

public class Panel {

    public static Iterator<Integer> panel1(int firstValue, int lastValue) {
        return new PanelIterator(firstValue, lastValue);
    }

    public static void main(String [] args) {
        System.out.println("Start");

        Iterator<Integer> it = panel1(1, 5);
        for (; it.hasNext(); ){
            System.out.println(it.next());
        }
    }
}
