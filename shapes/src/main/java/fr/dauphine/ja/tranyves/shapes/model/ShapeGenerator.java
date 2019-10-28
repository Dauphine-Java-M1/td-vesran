package fr.dauphine.ja.tranyves.shapes.model;

import java.util.Random;

public class ShapeGenerator {

    public Shape generateShape() {

        Random genIndex = new Random();

        ShapeName sn = ShapeName.values()[genIndex.nextInt(ShapeName.values().length)];
        Shape shape = null;

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
        Point center = new Point(rand.nextDouble() * 100, rand.nextDouble() * 100);

        return new Circle(center, rand.nextDouble() * 100);
    }

    private Ring genRing() {
        Random rand = new Random();
        Point center = new Point(rand.nextDouble() * 100, rand.nextDouble() * 100);
        double innerRadius = rand.nextDouble() * 50;
        double outerRadius = rand.nextDouble() * 50 + innerRadius;

        return new Ring(center, outerRadius, innerRadius);
    }

    private PolygonalChain genPolygonalChain() {
        Random rand = new Random();
        PolygonalChain chain = new PolygonalChain();

        for (int i = 0 ; i < rand.nextInt(5) + 2 ; i++) {
            chain.add(new Point(rand.nextDouble() * 100, rand.nextDouble() * 100));
        }

        return chain;
    }
}
