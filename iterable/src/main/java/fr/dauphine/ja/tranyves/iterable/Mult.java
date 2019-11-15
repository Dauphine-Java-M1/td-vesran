package fr.dauphine.ja.tranyves.iterable;

import java.util.*;

public class Mult {

    public static List<Integer> multOld(int scalar, List<Integer> values) {
        List<Integer> multValues = new ArrayList<>();

        for (int value : values) {
            multValues.add(value * scalar);
        }

        return multValues;
    }

    public static List<Integer> mult(final int scalar, final List<Integer> values) {
        return new AbstractList<Integer>() {

            @Override
            public int size() {
                return values.size();
            }

            @Override
            public Integer get(int index) {
                return values.get(index) * scalar;
            }

        };
    }

    public static void f() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            al.add(i);
        }
        long t0 = System.nanoTime();
        List<Integer> ret = Mult.mult(2, al);
        long sum=0;
        for(int val : ret) {
            sum+=val/2;
        }
        System.out.println((System.nanoTime() - t0));
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            ll.add(i);
        }
        System.out.println("added");
        t0 = System.nanoTime();
        sum=0;
        ret = Mult.mult(2, ll);
        for(int val : ret) {
            sum+=val/2;
        }
        System.out.println((System.nanoTime() - t0));
    }

    public static void main(String [] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
        values = mult(2, values);
        System.out.println(values);

        f();
    }
}
