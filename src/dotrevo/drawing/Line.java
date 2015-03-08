/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotrevo.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Phil
 */
public class Line extends AShape {

    public Line() {
        
    }
    
    public static Line create(Point start, Point end){
        Line l = new Line();
        l.start = start;
        l.end = end;
        return l;
    }
    
    public void createLine(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.red);
        g2d.drawLine(
                (int)start.getX(), (int)start.getY(),
                (int)end.getX(), (int)end.getY());
    }
    
    public void drawConcentric(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);
        g2d.drawLine(
                (int)start.getX(), (int)start.getY(),
                (int)end.getX(), (int)end.getY());
    }
    
}
