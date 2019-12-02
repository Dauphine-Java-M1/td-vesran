package fr.dauphine.ja.tranyves.generics;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class Maximum {

    private static int myMaxOld(int v0, int... values) {
        int currentMax = v0;

        for (Integer i : values) {
            if (currentMax < i) {
                currentMax = i;
            }
        }
        return currentMax;
    }

    private static <T extends Comparable<T>> T myMax(T v0, T... sequence) {
        T currentMax = v0;

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

    private static List<Integer> listLength2(List<? extends CharSequence> list) {
        ArrayList<Integer> length = new ArrayList<Integer>();

        for (CharSequence seq : list) {
            length.add(seq.length());
        }

        return length;
    }

    private static <T, T1 extends T, T2 extends T> List<T> fusion(List<T1> l1, List<T2> l2) {
        List<T> res = new ArrayList<T>();

        Iterator<T1> it1 = l1.iterator();
        Iterator<T2> it2 = l2.iterator();
        int parity = 0;

        while (it1.hasNext() || it2.hasNext()) {
            if (parity++ % 2 == 0) {
                if (it1.hasNext()) {
                    res.add(it1.next());
                } else if (it2.hasNext()) {
                    res.add(it2.next());
                }
            } else {
                if (it2.hasNext()) {
                    res.add(it2.next());
                } else if (it1.hasNext()) {
                    res.add(it1.next());
                }

            }
        }
        return res;
    }

    public static void main(String [] args) {
        System.out.println(myMax(3));
        System.out.println(myMax("aaa", "aba"));

        List<String> list = Arrays.asList("foo", "toto");
        print(list);

        displayLengths(Arrays.asList("fsdov", "fsg"));

        System.out.println(listLength2(Arrays.asList("fsdov", "fsg")));

        System.out.println(fusion(Arrays.asList("fef", "nj"), Arrays.asList(1, 2)));


        List<String> l1= Arrays.asList("C", "rc");
        List<StringBuilder> l2= Arrays.asList(new StringBuilder("a ma"), new StringBuilder("he!"));
        List<? extends CharSequence> r1=fusion(l1,l2);
        List<?> r2=fusion(l1,l2);List<Integer> l3 = Arrays.asList(1,2);
        List<Integer> l4 = Arrays.asList(10,20);
        List<Integer> r3 = fusion(l3,l4);
        List<?> r4 = fusion(l1,l3);

        myMax(new Time(0, 0, 0), new Date(0));

    }

}
