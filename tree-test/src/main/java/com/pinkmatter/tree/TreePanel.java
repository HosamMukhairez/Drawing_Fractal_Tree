package com.pinkmatter.tree;

import java.awt.Graphics;
import javax.swing.JPanel;

public class TreePanel extends JPanel {

    private final Scene scene;

    public TreePanel() {
        //Example1.png
        //scene = createScene(20, 200, Math.PI, 5, 15);
        //Example2.png
        //scene = createScene(30, 200, 2 * Math.PI / 3, 8, 10);
        //Example3.png        
        scene = createScene(30, 200, Math.PI / 2, 10, 8);
    }

    @Override
    protected void paintComponent(Graphics g) {
        scene.paint(g);
    }

    private Scene createScene(float trunkThickness, double trunkLength, double initialChildBranchAngle, int maxDepth, int leafSize) {
        //return null; // TODO
        return new Scene(trunkThickness, trunkLength, initialChildBranchAngle, maxDepth, leafSize);
    }
}
