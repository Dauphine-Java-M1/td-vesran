package fr.dauphine.ja.tranyves.shapes.model;

import fr.dauphine.ja.tranyves.shapes.view.CircleDrawer;
import fr.dauphine.ja.tranyves.shapes.view.ShapeDrawer;

public class Circle extends Shape {

    private Point center;
    private double radius;

    public Circle() {
        super.drawer = new CircleDrawer(this);
    }

    public Circle(int x, int y, double radius) {
        this(new Point(x, y), radius);
    }

    public Circle(Point center, double radius) {
        this();

        if (radius < 0) {
            throw new IllegalArgumentException("Radius must not be negative.");
        }

        // Building the circle
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

    public ShapeDrawer getDrawer() {
        return super.drawer;
    }

    public void translate(int dx, int dy) {
        this.center.translate(dx, dy);
    }

    public double surface() {
        return 3.1415 * this.radius * this.radius;
    }

    public boolean contains(Point p) {
        double dist;

        // Compute distance the given point and the center of the circle
        dist = Math.sqrt(Math.pow(p.getX() - this.center.getX(), 2) + Math.pow(p.getY() - this.center.getY(), 2));

        // The given point is out of the circle if the computed distance is higher than the radius
        return dist <= this.radius;
    }

    public static boolean contains(Point p, Circle... circles) {
        for (Circle c : circles) {
            if (c != null && c.contains(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void translate(double dx, double dy) {
        this.center.translate(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle another = (Circle) o;
            return this.radius == another.radius && this.center.equals(another.center);
        }
        return false;
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

        // Contains
        Circle c3 = new Circle(1, 1, 1);
        System.out.println(c3.contains(new Point(1, 0)));
        System.out.println(c3.contains(new Point(0, 0)));

        System.out.println(Circle.contains(new Point(0, 0), new Circle(1, 0, 1), new Circle(1, 0, 2)));
        System.out.println(Circle.contains(new Point(10, 0), new Circle(1, 0, 1), new Circle(1, 0, 2)));

    }
}
