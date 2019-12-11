package fr.dauphine.ja.tranyves.threads;

import java.sql.Time;
import java.util.ArrayList;

public class MySafeList extends ArrayList<Double>{

    private Object monitorAdd = new Object();
//    private Object monitorSize = new Object();

    public void add(double d) {
        synchronized (this.monitorAdd) {
            super.add(d);
        }
//        super.add(d);
    }

    public int size() {
//        synchronized (monitorSize) {
//            return this.list.size();
//        }
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
            }

            );
        }
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
        // Displaying results
        Thread.sleep(1000); // Waiting that threads finish their work
        System.out.println("List size is " + myList.size() + " and should be " + n * m);
        return myList.size() == n * m;
    }

    public static void main(String [] args) throws InterruptedException {
        int n = 29;
        int m = 10000;
        System.out.println(stressTest(n, m));
    }

}
