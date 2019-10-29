package fr.dauphine.ja.tranyves.shapes.view;

import fr.dauphine.ja.tranyves.shapes.controller.KeyController;
import fr.dauphine.ja.tranyves.shapes.controller.MouseController;
import fr.dauphine.ja.tranyves.shapes.model.Shape;
import fr.dauphine.ja.tranyves.shapes.model.World;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;

public class MyDisplay extends JPanel {

    private World world;

    public MyDisplay(World world) {
        super();
        this.world = world;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape s : this.world.getShapes()) {
            s.getDrawer().draw(g2);
        }
    }

    public static void main(String [] args) {
        World w = new World();

        JFrame frame = new JFrame("Java avancé - Graphic Display");

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDisplay d = new MyDisplay(w);
        frame.add(d);
        d.addMouseMotionListener(new MouseController(w, d));
        d.addKeyListener(new KeyController(w, d));
        d.setFocusable(true);

    }
}
