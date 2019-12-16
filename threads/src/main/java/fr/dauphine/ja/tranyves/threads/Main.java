package fr.dauphine.ja.tranyves.threads;

import static fr.dauphine.ja.tranyves.threads.MySafeList.*;

public class Main {

    private static void exo2() {
        int n = 29;
        int m = 10000;
        try {
            System.out.println(stressTest(n, m));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void exo3() {
        long start;
        long end;
        long time;
        double res;
        int n = 10000000;
        MySafeList myList1 = genList(n);
        MySafeList myList2 = genList(n);


        for (int i = 1; i <= 20; i++) {
            start = System.nanoTime();
            res = parallelScalar(myList1, myList2, i);
            end = System.nanoTime();
            time = end - start;
            System.out.println("i=" + i + " | res : " + res + " time : " + time * 10E-9);
        }

        System.out.println("=============================");
        start = System.nanoTime();
        res = scalar(myList1, myList2, 0, n);
        end = System.nanoTime();
        time = end - start;
        System.out.println("Ground truth | res : " + res + " time : " + time * 10E-9);
    }

    public static void main(String [] args) {
        exo3();
    }
}
