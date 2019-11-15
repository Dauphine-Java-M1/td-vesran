package fr.dauphine.ja.tranyves.iterable;

import java.util.Iterator;

public class Panel {

    public static Iterator<Integer> panel1(int firstValue, int lastValue) {

        return null;
    }

    public static void main(String [] args) {
        Iterator<Integer> it = panel1(1, 5);
        for (; it.hasNext(); ){
            System.out.println(it.next());
        }
    }
}
