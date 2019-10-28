package fr.dauphine.ja.tranyves.shapes.model;

import fr.dauphine.ja.tranyves.shapes.view.PolygonalChainDrawer;
import fr.dauphine.ja.tranyves.shapes.view.ShapeDrawer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PolygonalChain extends Shape {

    private List<Point> points;

    public PolygonalChain() {
        super.drawer = new PolygonalChainDrawer(this);
        this.points = new LinkedList<>();
    }

    @Override
    public ShapeDrawer getDrawer() {
        return super.drawer;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public Point get(int i) {
        return this.points.get(i);
    }

    public int nbPoints() {
        return this.points.size();
    }

    public boolean contains(Point p) {
        return this.points.contains(p);
    }

    public void add(Point p) {
        Objects.requireNonNull(p);
        this.points.add(p);
    }

    public String toString() {
        return this.points.toString();
    }

    public static void main(String [] args) {
        PolygonalChain pc = new PolygonalChain();

        for (int i = 0 ; i < 13 ; i ++) {
            pc.add(new Point(1, 2));
        }

        System.out.println(pc);
        System.out.println(pc.nbPoints());
        System.out.println(pc.contains(null));
        System.out.println(pc.contains(new Point(1, 111)));
        System.out.println(pc.contains(new Point(1, 2)));
    }
}
