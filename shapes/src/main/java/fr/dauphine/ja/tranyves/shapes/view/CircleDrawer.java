package fr.dauphine.ja.tranyves.shapes.view;

import fr.dauphine.ja.tranyves.shapes.model.Circle;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleDrawer implements ShapeDrawer {

    private Circle circle;
    private Color color = Color.GREEN;

    public CircleDrawer(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(this.color);

        double r = circle.getRadius();
        double topLeftX = (circle.getCenter().getX() - r);
        double topLeftY = (circle.getCenter().getY() - r);

        Shape circle = new Ellipse2D.Double(topLeftX, topLeftY, 2 * r, 2 * r);
        g2.draw(circle);
        g2.fill(circle);
    }
}
