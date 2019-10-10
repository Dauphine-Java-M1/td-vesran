package fr.dauphine.ja.tranyves.shapes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PolygonalChain {

    private List<Point> points;

    public PolygonalChain() {
        this.points = new LinkedList<>();
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

//        pc.add(null);

        System.out.println(pc);
        System.out.println(pc.nbPoints());
        System.out.println(pc.contains(null));
        System.out.println(pc.contains(new Point(1, 111)));
        System.out.println(pc.contains(new Point(1, 2)));
    }
}
