package fr.dauphine.ja.tranyves.shapes;

public class Ring extends Circle {

    private Circle internalCircle;

    public Ring(Point center, double externalRadius, double internalRadius) {
        super(center, externalRadius);

        if (externalRadius < internalRadius) {
            throw new IllegalArgumentException("The radius for the external circle must be higher than the internal circle's");
        }

        this.internalCircle = new Circle(center, internalRadius);
    }

    public static boolean contains(Point p, Ring... rings) {
        for (Ring ring : rings) {
            if (ring != null && ring.contains(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Point p) {
        return super.contains(p) && !this.internalCircle.contains(p);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Ring) {
            Ring another = (Ring) o;
            return super.getRadius() == another.getRadius()
                    && this.internalCircle.equals(another.internalCircle);
        }
        return false;
    }

    @Override
    public String toString() {
        return "[external circle : " + super.toString() + ", internal circle : " + this.internalCircle + "]";
    }

    public static void main(String [] args) {
        Ring r1 = new Ring(new Point(0, 0), 4, 2);
        Ring r2 = new Ring(new Point(1, 0), 4, 2);
        System.out.println(r1.equals(r2));

        // Contains
        Ring r3 = new Ring(new Point(0, 0), 2, 1);
        System.out.println(r3.contains(new Point(0, 0)));
        System.out.println(r3.contains(new Point(10, 0)));
        System.out.println(r3.contains(new Point(1.3, 1.3)));

        boolean v = Ring.contains(new Point(1.5, 1.5), new Ring(new Point(0, 0), 2, 1),
                new Ring(new Point(0, 0), 3, 2));
        boolean x = Ring.contains(new Point(1.5, 1.5), new Ring(new Point(0, 0), 2, 1),
                new Ring(new Point(0, 0), 30, 20));
        System.out.println(v);
        System.out.println(x);
    }
}
