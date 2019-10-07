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

    public static void main(String [] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(p1);
        Point p3 = new Point(1, 4);
        System.out.println(Point.numberOfPoints);
        System.out.println(p1.isSameAs(p2));
        System.out.println(p1.isSameAs(null));
    }

}
