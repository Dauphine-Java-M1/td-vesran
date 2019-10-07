package fr.dauphine.ja.tranyves.shapes;


public class Point {

    public static int numberOfPoints;
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

        // Increase the number of points
        Point.numberOfPoints++;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public static void main(String [] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(p1);
        System.out.println(Point.numberOfPoints);
        System.out.println(p2);
    }

}
