package fr.dauphine.ja.tranyves.shapes.model;

import fr.dauphine.ja.tranyves.shapes.view.ShapeDrawer;

public abstract class Shape {

    protected ShapeDrawer drawer;

    public abstract ShapeDrawer getDrawer();

}
