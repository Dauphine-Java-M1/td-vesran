package fr.dauphine.ja.tranyves.shapes.controller;

import fr.dauphine.ja.tranyves.shapes.model.Point;
import fr.dauphine.ja.tranyves.shapes.model.Shape;
import fr.dauphine.ja.tranyves.shapes.model.World;
import fr.dauphine.ja.tranyves.shapes.view.MyDisplay;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseMotionListener {

    private World model;
    private MyDisplay view;
    private Shape selectedShape;
    private Point previousPosition;

    public MouseController(World world, MyDisplay view) {
        this.model = world;
        this.view = view;
        this.selectedShape = world.getShapes().get(0);
    }

    private Shape selectShapeThatContains(Point p) {
        for (Shape currentShape : this.model.getShapes()) {
            if (currentShape.contains(p)) {

                if (!currentShape.equals(this.selectedShape)) {
                    return currentShape;
                }

            }
        }

        return null;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        this.selectedShape = this.selectShapeThatContains(new Point(mouseEvent.getX(), mouseEvent.getY()));
        this.previousPosition = new Point(mouseEvent.getX(), mouseEvent.getY());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (selectedShape == null) {
            return;

        } else {
            // Init previous position
            if (this.previousPosition == null) {
                this.previousPosition = new Point(mouseEvent.getX(), mouseEvent.getY());
            }

            // Compute delta position
            double deltaX = mouseEvent.getX() - this.previousPosition.getX();
            double deltaY = mouseEvent.getY() - this.previousPosition.getY();

            // Update shape's position
            this.selectedShape.translate(deltaX, deltaY);
            this.previousPosition = new Point(mouseEvent.getX(), mouseEvent.getY());

            this.view.repaint();
        }
    }
}
