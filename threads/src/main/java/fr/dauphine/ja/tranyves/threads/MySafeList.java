package fr.dauphine.ja.tranyves.threads;

import java.sql.Time;
import java.util.ArrayList;

public class MySafeList {

    public ArrayList<Double> list;

    public MySafeList() {
        this.list = new ArrayList<Double>();
    }

    public void add(double d) {
        this.list.add(d);
    }

    public int size() {
        return this.list.size();
    }

    public Double get(int i) {
        return this.list.get(i);
    }

    public static MySafeList stressTest(int n, final int m) {
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
            System.out.println("adding " + threads[i]);
            System.out.println(threads.length);
        }
        System.out.println(threads.length);
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
        return myList;
    }

    public static void main(String [] args) throws InterruptedException {
        int n = 2;
        int m = 10;
        MySafeList myList = stressTest(n, m);

        // This section happened before the end of thread's execution

        Thread.sleep(1000);
        System.out.println(myList.list);
        System.out.println("List size is " + myList.size() + " and should be " + n * m);
    }

}
