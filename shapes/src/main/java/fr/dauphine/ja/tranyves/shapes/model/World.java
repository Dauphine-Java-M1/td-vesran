package fr.dauphine.ja.tranyves.shapes.model;

import java.util.ArrayList;
import java.util.List;

public class World {

    private final int boundX;
    private final int boundY;
    private List<Shape> shapes;

    public World(int boundX, int boundY) {
        this.shapes = new ArrayList<>();
        this.boundX = boundX;
        this.boundY = boundY;
//        this.init();
    }

    public int getBoundX() {
        return this.boundX;
    }

    public int getBoundY() {
        return this.boundY;
    }

    public List<Shape> getShapes() {
        return this.shapes;
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void init() {
        this.shapes.add(new Circle(20, 10, 10));

        PolygonalChain pc = new PolygonalChain();
        pc.add(new Point(20, 30));
        pc.add(new Point(40, 170));
        pc.add(new Point(200, 100));
        this.shapes.add(pc);

        this.shapes.add(new Ring(new Point(200, 200), 200, 150));
    }
}
