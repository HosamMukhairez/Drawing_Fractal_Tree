package com.pinkmatter.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

public class Scene extends JPanel {

    float trunkThickness;
    double trunkLength;
    double initialChildBranchAngle;
    int maxDepth;
    int leafSize;
    ArrayList<Shape> shapes = new ArrayList<>();
    Random r = new Random();
    boolean startDrawing = true;

    public Scene(float trunkThickness, double trunkLength, double initialChildBranchAngle, int maxDepth, int leafSize) {
        this.trunkThickness = trunkThickness;
        this.trunkLength = trunkLength;
        this.initialChildBranchAngle = initialChildBranchAngle;
        this.maxDepth = maxDepth;
        this.leafSize = leafSize;
    }

    @Override
    public void paint(Graphics g) {
        double rad = this.initialChildBranchAngle;
        System.out.println(Math.toDegrees(rad));
        if (startDrawing) {
            drawTree(g, 400, 700, -90, this.maxDepth, this.trunkThickness, this.trunkLength);
            drawRedBall(g);
            startDrawing = false;
        } else {
            restoreTree(g);
        }
    }

    private void drawTree(Graphics g, double x1, double y1, double angle, int depth, float stroke, double trunkLength) {
        Graphics2D g2d = (Graphics2D) g;

        double x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * trunkLength);
        double y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * trunkLength);

        if (depth == 0) {//Reached leafs                        
            Shape leaf = new Leaf((int) x1 - (this.leafSize / 2), (int) y1 - (this.leafSize / 2), this.leafSize, Color.GREEN);
            leaf.drawShape(g);
            shapes.add(leaf);//Adding all leafs to shape list
            return;
        }

        int deadBranchProbability = r.nextInt(100);
        if (deadBranchProbability <= 10 && (depth % this.maxDepth) > 2) {//Each branch has a 10% chance of being dead                        
            Shape line = new Line(x1, y1, x2, y2, Color.GRAY, stroke);
            line.drawShape(g);
            shapes.add(line);//Adding all dead lines(Branches) to shape list
            return;
        }//*/

        // Light brown  rgb(153-102-0)
        // Brown        rgb(102-51-0)
        // Dark brown   rgb(51-0-0)        
        Shape l = new Line(x1, y1, x2, y2, new Color(153 - ((102 / this.maxDepth) * depth), 102 - ((102 / this.maxDepth) * depth), 0), stroke);
        l.drawShape(g);
        shapes.add(l);//Adding all created lines(Branches) to shape list

        drawTree(g2d, x2, y2, angle - 20, depth - 1, (stroke * 0.7f), (trunkLength * 0.7));//recursively for any left branch
        drawTree(g2d, x2, y2, angle + 20, depth - 1, (stroke * 0.7f), (trunkLength * 0.7));//recursively for any right branch
    }

    public void drawRedBall(Graphics g) {
        Shape redBall = new RedBall(shapes);
        redBall.drawShape(g);
        shapes.add(redBall);//Adding created redBall to shape list
    }

    public void restoreTree(Graphics g) {//to restore the tree after changing the window size        
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).drawShape(g);
        }
    }//*/
}
