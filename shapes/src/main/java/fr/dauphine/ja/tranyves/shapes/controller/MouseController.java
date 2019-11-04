package fr.dauphine.ja.tranyves.shapes.controller;

import fr.dauphine.ja.tranyves.shapes.model.Point;
import fr.dauphine.ja.tranyves.shapes.model.Shape;
import fr.dauphine.ja.tranyves.shapes.model.World;
import fr.dauphine.ja.tranyves.shapes.view.MyDisplay;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController extends Controller implements MouseMotionListener {

    private Shape selectedShape;
    private Point previousPosition;
    private Point currentPosition;

    public MouseController(World world, MyDisplay view) {
        super.model = world;
        super.view = view;
    }

    private Shape selectShapeThatContains(Point p) {
        for (Shape currentShape : this.model.getShapes()) {
            if (currentShape.contains(p)) {
                return currentShape;
            }
        }
        return null;
    }

    private void updateMousePosition(MouseEvent mouseEvent) {
        this.previousPosition = this.currentPosition;
        this.currentPosition = new Point(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

        if (this.selectedShape == null) {
            this.selectedShape = this.selectShapeThatContains(this.currentPosition);
        }

        // Compute delta position
        double deltaX = this.currentPosition.getX() - this.previousPosition.getX();
        double deltaY = this.currentPosition.getY() - this.previousPosition.getY();

        // Update shape's position
        this.selectedShape.translate(deltaX, deltaY);

        this.view.repaint();

        this.updateMousePosition(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.selectedShape = null;
        this.updateMousePosition(mouseEvent);
    }
}
