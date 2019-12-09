package fr.dauphine.ja.tranyves.threads;

public class ThreadTest {

    private static int n;
    private final static Object monitor = new Object();
    private static boolean flag;

    public static Runnable display10000times(final int id) {
        return new Runnable() {

            public void run() {
//                while (ThreadTest.n < 10000) {
//                    // --> Thread 2 STOPPED during iteration 9999
//                    synchronized (ThreadTest.monitor) {
//                        // --> Thread 1 continue iteration 9999 from here (from where it stopped)
//                        if (ThreadTest.n < 10000) {
//                            System.out.println("Je suis le thread " + id + " et j'effectue l'iteration " + ThreadTest.n);
//                            ThreadTest.n++;
//                        }
//                    }
//                }
                int limit = 10000;
                while (ThreadTest.n < limit) {
                    synchronized (ThreadTest.monitor) {
                        if (ThreadTest.n < limit) {
                            flag = true;
                        }

                        if (flag) {
                            System.out.println("Je suis le thread " + id + " et j'effectue l'iteration " + ThreadTest.n++);
                            flag = false;
                        }
                    }
                }
            }

        };
    }

    public static void main(String [] args) {
        Thread t1 = new Thread(display10000times(1));
        Thread t2 = new Thread(display10000times(2));

        t1.start();
        t2.start();
    }
}
