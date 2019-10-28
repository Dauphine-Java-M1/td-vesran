package fr.dauphine.ja.tranyves.shapes.controller;

import fr.dauphine.ja.tranyves.shapes.model.ShapeGenerator;
import fr.dauphine.ja.tranyves.shapes.model.World;
import fr.dauphine.ja.tranyves.shapes.view.MyDisplay;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

    private ShapeGenerator shapeGenerator;
    private World model;
    private MyDisplay view;

    public KeyController(World model, MyDisplay view) {
        this.shapeGenerator = new ShapeGenerator();
        this.model = model;
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Typed : " + e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed : " + e);

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.model.add(this.shapeGenerator.generateShape());
            System.out.println(this.model.getShapes().size());
        }

        this.view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("Released : " + keyEvent);
    }
}
