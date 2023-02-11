/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pinkmatter.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class RedBall implements Shape {

    int x, y;
    int redBallRandomPlace;
    Shape line, coupledLine;

    public RedBall(ArrayList<Shape> shapes) {
        while (true) {
            redBallRandomPlace = getRandomNumber(2, shapes.size());
            line = shapes.get(redBallRandomPlace);//Selecting randomly branch from the list
            if (line instanceof Line) {
                break;
            }
        }

        coupledLine = line;
        for (int i = 0; i < shapes.size(); i++) {//Getting the coupled branch of the selected previous branch
            if (line.getX1() == shapes.get(i).getX1() && line.getY1() == shapes.get(i).getY1() && line.getX2() != shapes.get(i).getX2() && line.getY2() != shapes.get(i).getY2()) {
                coupledLine = shapes.get(i);
                break;
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void drawShape(Graphics g) {
        try {
            Graphics2D g2d = (Graphics2D) g;

            Point firstPoint = new Point((int) (line.getX1() + line.getX2()) / 2, (int) (line.getY1() + line.getY2()) / 2);
            Point secondPoint = new Point((int) (coupledLine.getX1() + coupledLine.getX2()) / 2, (int) (coupledLine.getY1() + coupledLine.getY2()) / 2);
            Point midPoint = new Point((firstPoint.x + secondPoint.x) / 2, (firstPoint.y + secondPoint.y) / 2);

            g2d.setColor(Color.RED);
            g2d.fillOval(midPoint.x - 10, midPoint.y - 10, 20, 20);//Drawing the red ball between the coupled branches
            x = midPoint.x - 10;
            y = midPoint.y - 10;            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getX1() {
        return x;
    }

    @Override
    public double getY1() {
        return y;
    }

    @Override
    public double getX2() {
        return 0.0;
    }

    @Override
    public double getY2() {
        return 0.0;
    }
}
