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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Ring) {
            Ring another = (Ring) o;
            return super.getCenter().equals(another.getCenter())
                    && super.getRadius() == another.getRadius()
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
    }
}
