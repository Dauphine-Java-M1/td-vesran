package fr.dauphine.ja.tranyves.threads;

public class ThreadTest {

    private static int n;
    private static Object monitor = new Object();
    private static boolean flag;

    public static Runnable display10000times(final int id) {
        return new Runnable() {

            public void run() {
//                while (ThreadTest.n < 10000) {
//                    synchronized (ThreadTest.monitor) {
//                        System.out.println("Je suis le thread " + id + " et j'effectue l'iteration " + ThreadTest.n);
//                        ThreadTest.n++;
//                    }
//                }
                while (ThreadTest.n < 100) {
                    synchronized (ThreadTest.monitor) {
                        if (ThreadTest.n < 100) {
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
