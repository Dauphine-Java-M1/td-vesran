package fr.dauphine.ja.tranyves.generics;

import java.util.*;

public class Mix {

    public static <T> void swap(List<T> list, int i, int j) {
        if (i < 0 || j < 0 || i >= list.size() || j >= list.size()) {
            throw new IllegalArgumentException(i + " and / or " + j + " out of bound");
        }
        T savedElement = list.get(i);
        list.set(i, list.get(j));
        list.set(j, savedElement);
    }

    /**
     * Knuth shuffle method
     * @param list list to shuffle
     */
    private static <T, L extends List<T> & RandomAccess> void shuffle1(L list) {
        Random rand = new Random();
        int j;

        for (int i = list.size() - 1; i >= 0; i--) {
            j = rand.nextInt(i + 1);    // bound excluded
            swap(list, i, j);
        }
    }

    private static void shuffle2(List<?> list) {
        Collections.shuffle(list);
    }

    public static void f() {
        Random rand = new Random();
        ArrayList<Double> l1 = new ArrayList<>();
        ArrayList<Double> l2 = new ArrayList<>();
        double d;

        for (int i = 0; i < 10000000; i++) {
            d = rand.nextDouble();
            l1.add(d);
            l2.add(d);
        }

        long start = System.currentTimeMillis();
        shuffle1(l1);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        shuffle2(l2);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String [] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(list);
        swap(list, 1, 4);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(list2);
        shuffle1(list2);
        System.out.println(list2);

        f();

    }
}
