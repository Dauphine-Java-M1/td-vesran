package fr.dauphine.ja.tranyves.shapes.controller;

import fr.dauphine.ja.tranyves.shapes.model.ShapeGenerator;
import fr.dauphine.ja.tranyves.shapes.model.World;
import fr.dauphine.ja.tranyves.shapes.view.MyDisplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController extends Controller implements KeyListener {

    private ShapeGenerator shapeGenerator;

    public KeyController(World model, MyDisplay view) {
        this.shapeGenerator = new ShapeGenerator(view.getBoundX(), view.getBoundY());
        super.model = model;
        super.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.model.add(this.shapeGenerator.generateShape());
        }

        this.view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}
}
