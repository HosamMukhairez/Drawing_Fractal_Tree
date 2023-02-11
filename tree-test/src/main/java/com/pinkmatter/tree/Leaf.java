/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pinkmatter.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Dell
 */
public class Leaf implements Shape {

    int x, y, size;
    Color c;

    public Leaf(int x, int y, int size, Color c) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.c = c;
    }

    @Override
    public void drawShape(Graphics g) {
        try {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            //g2d.fillOval((int) this.x - (this.size / 2), (int) this.y - (this.size / 2), this.size, this.size);
            g2d.fillOval((int) this.x, (int) this.y, this.size, this.size);
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
