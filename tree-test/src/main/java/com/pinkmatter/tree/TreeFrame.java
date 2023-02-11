package com.pinkmatter.tree;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TreeFrame extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new TreeFrame();
        frame.setTitle("Tree");
        frame.add(new TreePanel());
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
