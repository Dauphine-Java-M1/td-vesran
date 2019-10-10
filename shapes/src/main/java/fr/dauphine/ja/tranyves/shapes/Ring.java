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
}
