package fr.dauphine.ja.tranyves.shapes;

public class Point {

    private int x;
    private int y;

    public void test() {
        Point p = new Point();
        System.out.println(p.x + " " + p.y);
    }

    public static void main(String [] args) {
        Point p = new Point();
        p.test();
    }

}
