package fr.dauphine.ja.tranyves.shapes;

public class PolygonalChain {

    private Point [] points;

    public PolygonalChain(int size) {
        this.points = new Point[size];
    }

    public Point[] getPoints() {
        return this.points;
    }

    public int nbPoints() {
        for (int i = 0 ; i < this.points.length ; i++) {
            if (this.points[i] == null) {
                return i;
            }
        }
        return this.points.length;
    }

    public int pointCapacity() {
        return this.points.length - this.nbPoints();
    }

    public void add(Point p) {
        for (int i = 0 ; i < this.points.length ; i++) {
            if (this.points[i] == null) {
                this.points[i] = p;
                return;
            }
        }
        System.out.println("The array of points is full !");
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("[");

        for (Point p : this.points) {
            strb.append(p + " ");
        }

        return strb.toString();
    }

    public static void main(String [] args) {
        PolygonalChain pc = new PolygonalChain(10);

        for (int i = 0 ; i < 13 ; i ++) {
            pc.add(new Point(1, 2));
        }

        System.out.println(pc);
    }
}
