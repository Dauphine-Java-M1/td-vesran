package fr.dauphine.ja.tranyves.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maximum {

    public static int myMaxOld(int... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Empty array or array is null");
        }

        int currentMax = values[0];

        for (Integer i : values) {
            if (currentMax < i) {
                currentMax = i;
            }
        }
        return currentMax;
    }

    public static <T extends Comparable<T>> T myMax(T... sequence) {
        if (sequence == null || sequence.length == 0) {
            throw new IllegalArgumentException("Empty array or array is null");
        }

        T currentMax = sequence[0];

        for (T element : sequence) {
            if (element.compareTo(currentMax) > 0) {
                currentMax = element;
            }
        }

        return currentMax;
    }

    private static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void displayLengths(List<? extends CharSequence> sequences) {
        for (CharSequence sequence : sequences) {
            System.out.println(sequence.length());
        }
    }

    public static <T extends CharSequence> List<Integer> listLength(List<T> list) {
        ArrayList<Integer> length = new ArrayList<Integer>();

        for (T element : list) {
            CharSequence seq = element;
            length.add(seq.length());
        }

        return length;
    }

    public static List<Integer> listLength2(List<? extends CharSequence> list) {
        ArrayList<Integer> length = new ArrayList<Integer>();

        for (CharSequence seq : list) {
            length.add(seq.length());
        }

        return length;
    }

    public static void main(String [] args) {
        System.out.println(myMax(142352, 2434, 4));
        System.out.println(myMax("aaa", "aba"));

        List<String> list = Arrays.asList("foo", "toto");
        print(list);

        displayLengths(Arrays.asList("fsdov", "fsg"));

        System.out.println(listLength2(Arrays.asList("fsdov", "fsg")));
    }

}
