package fr.dauphine.ja.tranyves.shapes;

public class Circle {

    private Point center;
    private double radius;

    public Circle(int x, int y, double radius) {
        this(new Point(x, y), radius);
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center.clone();
    }

    public Circle translate(int dx, int dy) {
        return new Circle(this.center.translate(dx, dy), this.radius);
    }

    @Override
    public String toString() {
        return "[Circle : center=" + this.center + " radius=" + this.radius + "]";
    }

    public static void main(String [] args) {
        Circle c = new Circle(5, 5, 2.3);
        System.out.println(c);

        System.out.println(c.translate(1, 2));

        System.out.println(c.getCenter().translate(1, 1));
        System.out.println(c.getCenter());
    }
}
