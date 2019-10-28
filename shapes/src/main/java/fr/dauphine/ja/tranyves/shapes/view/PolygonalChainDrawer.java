package fr.dauphine.ja.tranyves.shapes.view;

import fr.dauphine.ja.tranyves.shapes.model.Point;
import fr.dauphine.ja.tranyves.shapes.model.PolygonalChain;

import java.awt.*;
import java.awt.geom.Line2D;

public class PolygonalChainDrawer implements ShapeDrawer {

    private PolygonalChain chain;
    private Color color = Color.BLUE;

    public PolygonalChainDrawer(PolygonalChain chain) {  // TODO check class
        this.chain = chain;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(this.color);

        for (int i = 0 ; i < this.chain.nbPoints() - 1 ; i++) {
            g2.draw(new Line2D.Double(this.chain.get(i).getX(), this.chain.get(i).getY(),
                                      this.chain.get(i + 1).getX(), this.chain.get(i + 1).getY()));
        }
    }
}
