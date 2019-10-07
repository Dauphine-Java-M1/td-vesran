package fr.dauphine.ja.tranyves.shapes;


import java.util.ArrayList;

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

    public boolean isSameAs(Point another) {
        if (another != null) {
            return ((this.x == another.x) && (this.y == another.y));
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            return this.isSameAs((Point) o);
        }
        return false;
    }

    public static void main(String [] args) {
        Point p1 = new Point(1, 2);
        Point p2 = p1;
        Point p3 = new Point(1, 2);

        ArrayList<Point> list = new ArrayList<>();
        list.add(p1);
        System.out.println(list.indexOf(p2));
        System.out.println(list.indexOf(p3));
    }

}
