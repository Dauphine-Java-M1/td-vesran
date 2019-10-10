package fr.dauphine.ja.tranyves.shapes;

public class Circle {

    private Point center;
    private double radius;

    public Circle(int x, int y, double radius) {
        this(new Point(x, y), radius);
    }

    public Circle(Point center, double radius) {
        if (radius < 0) {
            throw new RuntimeException("Radius must not be negative.");
        }

        // Building the circle
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public void translate(int dx, int dy) {
        this.center.translate(dx, dy);
    }

    public double surface() {
        return 3.1415 * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "[Circle : center=" + this.center + " radius=" + this.radius + "]";
    }

    public static void main(String [] args) {
        Circle c = new Circle(5, 5, 2.3);
        System.out.println(c);

        c.translate(1, 2);
        System.out.println(c);

        c.getCenter().translate(1, 1);
        System.out.println(c);
        System.out.println(c.getCenter());

        // Surface
        Circle c2 = new Circle(1, 1, 1);
        System.out.println(c2.surface());
    }
}
