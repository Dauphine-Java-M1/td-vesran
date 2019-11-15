package fr.dauphine.ja.tranyves.iterable;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String [] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
        values = mult(2, values);
        System.out.println(values);
    }
}
