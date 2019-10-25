package fr.dauphine.ja.tranyves.shapes.view;

import javax.swing.*;
import java.awt.*;

public class MyDisplay extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawLine(10, 10, 400, 350);
    }

    public static void main(String [] args) {
        JFrame frame = new JFrame("Java avancé - Graphic Display");

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDisplay d = new MyDisplay();
        frame.add(d);
    }
}
