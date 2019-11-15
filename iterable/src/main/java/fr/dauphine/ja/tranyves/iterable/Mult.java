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

        // List implements RandomAccess
        if (values instanceof RandomAccess) {
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

        // List does not implements RandomAccess
        return new AbstractSequentialList<Integer>() {

            @Override
            public ListIterator<Integer> listIterator(final int index) {

                return new ListIterator<Integer>() {

                    ListIterator<Integer> lit = values.listIterator(index);

                    @Override
                    public boolean hasNext() {
                        return lit.hasNext();
                    }

                    @Override
                    public Integer next() {
                        return lit.next() * scalar;
                    }

                    @Override
                    public boolean hasPrevious() {
                        return lit.hasPrevious();
                    }
                    @Override
                    public Integer previous() {
                        return lit.previous() * scalar;
                    }

                    @Override
                    public int nextIndex() {
                        return lit.nextIndex();
                    }

                    @Override
                    public int previousIndex() {
                        return lit.previousIndex();
                    }
                    @Override
                    public void remove() {
                        lit.remove();
                    }
                    @Override
                    public void set(Integer integer) {
                        lit.set(integer);
                    }
                    @Override
                    public void add(Integer integer) {
                        lit.add(integer);
                    }
                };

            }

            @Override
            public int size() {
                return values.size();
            }
        };
    }

    public static void funcTest() {
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

        funcTest();
    }
}
