package fr.dauphine.ja.tranyves.threads;

import java.util.ArrayList;
import java.util.Random;

public class MySafeList extends ArrayList<Double>{

    private Object monitorAdd = new Object();

    public void add(double d) {
        synchronized (this.monitorAdd) {
            super.add(d);
        }
    }

    public int size() {
        return super.size();
    }

    public Double get(int i) {
        return super.get(i);
    }

    public static boolean stressTest(int n, final int m) throws InterruptedException {
        final MySafeList myList = new MySafeList();

        // Creating n thread that will add m times a value
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < m; j++) {
                        myList.add(1.0);
                     }
                }
            });
        }
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
        // Displaying results
        for (int i = 0; i < n; i++) {
            threads[i].join();
        }
        System.out.println("List size is " + myList.size() + " and should be " + n * m);
        return myList.size() == n * m;
    }

    public static double scalar(MySafeList l1, MySafeList l2, int begin, int end) {
        if (l1.size() != l2.size()) {
            throw new IllegalArgumentException("Lists size are different");
        }
        double res = 0.0;
        for (int i = begin; i < end; i++) {
            res += (l1.get(i) * l2.get(i));
        }
        return res;
    }

    public static MySafeList genList(int n) {
        Random rand = new Random();
        MySafeList resList = new MySafeList();

        for (int i = 0; i < n; i++) {
            resList.add(rand.nextDouble());
        }

        return resList;
    }

    public static void main(String [] args) throws InterruptedException {
        int n = 29;
        int m = 10000;
        System.out.println(stressTest(n, m));

        MySafeList l1 = genList(10);
        System.out.println(l1);
    }

    public static double parallelScalar(MySafeList l1, MySafeList l2, int n) {
        ScalarThread[] threads = new ScalarThread[n];
        int portionLength = l1.size() / n;
        double res = 0;

        // Create n threads
        for (int i = 0; i < n - 1; i++) {
            threads[i] = new ScalarThread(l1, l2, i * portionLength, (i + 1) * portionLength);
            threads[i].start();
        }
        threads[n - 1] = new ScalarThread(l1, l2, (n - 1) * portionLength, l1.size());
        threads[n - 1].start();

        // Sum the results
        try {
            for (int i = 0; i < n; i++) {
                threads[i].join();
                res += threads[i].getResult();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return res;
    }

}
