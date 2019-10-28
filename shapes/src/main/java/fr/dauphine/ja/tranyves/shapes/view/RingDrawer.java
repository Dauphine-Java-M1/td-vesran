package fr.dauphine.ja.tranyves.shapes.view;

import fr.dauphine.ja.tranyves.shapes.model.Circle;
import fr.dauphine.ja.tranyves.shapes.model.Ring;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

public class RingDrawer implements ShapeDrawer {

    private Ring ring;
    private Color color = Color.RED;

    public RingDrawer(Ring ring) {
        this.ring = ring;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(this.color);

        Circle innerCircle = this.ring.getInternalCircle();

        Shape outer = new Ellipse2D.Double(this.ring.getCenter().getX() - this.ring.getRadius(), this.ring.getCenter().getY() - this.ring.getRadius(),2 * this.ring.getRadius(), 2 * this.ring.getRadius());
        Shape inner = new Ellipse2D.Double(innerCircle.getCenter().getX() - innerCircle.getRadius(), innerCircle.getCenter().getY() - innerCircle.getRadius(), 2 *innerCircle.getRadius(), 2 * innerCircle.getRadius());

        Area circle = new Area(outer);
        circle.subtract(new Area(inner));

        g2.fill(circle);
        g2.draw(circle);

    }
}
