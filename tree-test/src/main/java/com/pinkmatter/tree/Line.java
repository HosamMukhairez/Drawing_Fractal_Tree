/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pinkmatter.tree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Dell
 */
public class Line implements Shape {
    
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private float stroke;
    private Color c;

    public Line(double x1, double y1, double x2, double y2, Color c, float stroke) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c = c;
        this.stroke = stroke;
    }

    @Override
    public void drawShape(Graphics g) {
        try {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(stroke));
            g2d.setColor(c);//Adjusting brown color from dark to light based on the depth level
            g2d.drawLine((int) getX1(), (int) getY1(), (int) getX2(), (int) getY2());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getX1() {
        return x1;
    }

    @Override
    public double getY1() {
        return y1;
    }

    @Override
    public double getX2() {
        return x2;
    }

    @Override
    public double getY2() {
        return y2;
    }

}
