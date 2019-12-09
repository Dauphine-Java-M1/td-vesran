package fr.dauphine.ja.tranyves.threads;

public class ThreadTest {

    private static int n;
    private static Object monitor = new Object();

    public static Runnable display10000times(final int id) {
        return new Runnable() {

            public void run() {
                while (ThreadTest.n < 10000) {
                    synchronized (ThreadTest.monitor) {
                        System.out.println("Je suis le thread " + id + " et j'effectue l'iteration " + ThreadTest.n);
                        ThreadTest.n++;
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
