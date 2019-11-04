package fr.dauphine.ja.tranyves.shapes.model;

import java.util.Random;

public class ShapeGenerator {

    private final int boundX;
    private final int boundY;
    private double originX;
    private double originY;

    public ShapeGenerator(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
    }

    public Shape generateShape() {
        Random genIndex = new Random();

        ShapeName sn = ShapeName.values()[genIndex.nextInt(ShapeName.values().length)];
        Shape shape = null;

        this.updateOrigin();

        switch (sn) {
            case CIRCLE:
                shape = genCircle();
                break;

            case RING:
                shape = genRing();
                break;

            case POLYGONAL_SHAPE:
                shape = genPolygonalChain();
                break;
        }

        return shape;
    }

    private Circle genCircle() {
        Random rand = new Random();
        Point center = new Point(this.originX, this.originY);

        return new Circle(center, rand.nextDouble() * 50);
    }

    private Ring genRing() {
        Random rand = new Random();
        Point center = new Point(this.originX, this.originY);
        double innerRadius = rand.nextDouble() * 50;
        double outerRadius = (rand.nextDouble() * 50) + innerRadius;

        return new Ring(center, outerRadius, innerRadius);
    }

    private PolygonalChain genPolygonalChain() {
        Random rand = new Random();
        PolygonalChain chain = new PolygonalChain();

        for (int i = 0 ; i < rand.nextInt(5) + 2 ; i++) {
            chain.add(new Point(rand.nextDouble() * 50 * i + this.originX, rand.nextDouble() * 50 * i + this.originY));
        }

        return chain;
    }

    private void updateOrigin() {
        Random rand = new Random();

        this.originX = rand.nextInt(this.boundX);
        this.originY = rand.nextInt(this.boundY);
    }
}
