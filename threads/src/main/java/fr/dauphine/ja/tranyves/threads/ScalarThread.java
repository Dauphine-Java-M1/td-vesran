package fr.dauphine.ja.tranyves.threads;

public class ScalarThread extends Thread {

    private MySafeList l1;
    private MySafeList l2;
    private int begin;
    private int end;

    private double result;

    public ScalarThread(MySafeList l1, MySafeList l2, int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.l1 = l1;
        this.l2 = l2;
    }

    public double getResult() {
        return this.result;
    }

    @Override
    public void run() {
        this.result = MySafeList.scalar(this.l1, this.l2, this.begin, this.end);
    }
}
