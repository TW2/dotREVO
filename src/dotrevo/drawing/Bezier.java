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
import java.awt.geom.CubicCurve2D;

/**
 *
 * @author Phil
 */
public class Bezier extends AShape {
    
    public Bezier() {
        
    }
    
    public static Bezier create(Point start, Point end){
        Bezier b = new Bezier();
        b.start = start;
        b.end = end;
        
        int xdiff = (int)end.getX() - (int)start.getX();
        int ydiff = (int)end.getY() - (int)start.getY();

        int x1_3 = (int)start.getX() + xdiff/3;
        int x2_3 = (int)start.getX() + xdiff*2/3;
        int y1_3 = (int)start.getY() + ydiff/3;
        int y2_3 = (int)start.getY() + ydiff*2/3;
        
        b.cp1 = new Point(x1_3, y1_3);
        b.cp2 = new Point(x2_3, y2_3);
        
        return b;
    }
    
    public static Bezier create(Point start, Point cp1, Point cp2, Point end){
        Bezier b = new Bezier();
        b.start = start;
        b.cp1 = cp1;
        b.cp2 = cp2;
        b.end = end;
        
        return b;
    }
    
    public void createBezier(Point start, Point end){
        this.start = start;
        this.end = end;
        
        int xdiff = (int)end.getX() - (int)start.getX();
        int ydiff = (int)end.getY() - (int)start.getY();

        int x1_3 = (int)start.getX() + xdiff/3;
        int x2_3 = (int)start.getX() + xdiff*2/3;
        int y1_3 = (int)start.getY() + ydiff/3;
        int y2_3 = (int)start.getY() + ydiff*2/3;
        
        this.cp1 = new Point(x1_3, y1_3);
        this.cp2 = new Point(x2_3, y2_3);
    }
    
    public void createBezier(Point start, Point cp1, Point cp2, Point end){
        this.start = start;
        this.cp1 = cp1;
        this.cp2 = cp2;
        this.end = end;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        CubicCurve2D c = new CubicCurve2D.Double();
        c.setCurve(
                (int)start.getX(), (int)start.getY(),
                (int)cp1.getX(), (int)cp1.getY(),
                (int)cp2.getX(), (int)cp2.getY(),
                (int)end.getX(), (int)end.getY());
        g2d.setColor(Color.magenta);
        g2d.draw(c);
    }
    
    public void drawConcentric(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        CubicCurve2D c = new CubicCurve2D.Double();
        c.setCurve(
                (int)start.getX(), (int)start.getY(),
                (int)cp1.getX(), (int)cp1.getY(),
                (int)cp2.getX(), (int)cp2.getY(),
                (int)end.getX(), (int)end.getY());
        g2d.setColor(Color.black);
        g2d.draw(c);
    }
}
