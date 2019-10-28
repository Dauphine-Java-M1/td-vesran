package fr.dauphine.ja.tranyves.shapes.model;

import fr.dauphine.ja.tranyves.shapes.view.ShapeDrawer;

public abstract class MyShape {

    protected ShapeDrawer drawer;

    public abstract boolean contains(Point p);
    public abstract ShapeDrawer getDrawer();

}
