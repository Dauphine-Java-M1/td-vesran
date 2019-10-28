package fr.dauphine.ja.tranyves.shapes.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        System.out.println("Dragged mouse : " + mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("Mouse is moving : " + mouseEvent);
    }
}
