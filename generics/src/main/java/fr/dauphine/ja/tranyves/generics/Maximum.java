package fr.dauphine.ja.tranyves.generics;

public class Maximum {

    public static int myMax(int... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Empty array or array or null");
        }

        int currentMax = values[0];

        for (Integer i : values) {
            if (currentMax < i) {
                currentMax = i;
            }
        }
        return currentMax;
    }

    public static void main(String [] args) {
        System.out.println(myMax(142352, 2434, 4));
        System.out.println(myMax());
    }

}
