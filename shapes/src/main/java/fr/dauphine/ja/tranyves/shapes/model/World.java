package fr.dauphine.ja.tranyves.shapes.model;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Shape> shapes;

    public World() {
        this.shapes = new ArrayList<>();
        this.init();
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
