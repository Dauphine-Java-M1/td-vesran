package fr.dauphine.ja.tranyves.shapes.model;

import fr.dauphine.ja.tranyves.shapes.view.ShapeDrawer;

public abstract class Shape {

    protected ShapeDrawer drawer;

    public abstract boolean contains(Point p);
    public abstract ShapeDrawer getDrawer();
    public abstract void translate(double dx, double dy);

}
