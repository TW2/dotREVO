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
public class SharedPoint extends AShape {
    
    Kind k = Kind.Point;
    
    public SharedPoint(){
        
    }
    
    public enum Kind{
        Point, ControlPoint, StartPoint, SplinePoint, EndSplinePoint;
    }
    
    public void setKind(Kind k){
        this.k = k;
    }
    
    public Kind getKind(){
        return k;
    }
    
    public static SharedPoint create(Kind k, Point p){
        SharedPoint sp = new SharedPoint();
        sp.setKind(k);
        sp.start = p;
        sp.end = p;
        return sp;
    }
    
    public void createPoint(Kind k, Point p){
        setKind(k);
        start = p;
        end = p;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        switch(k){
            case Point: 
                g2d.setColor(Color.blue);
                g2d.fillRect(start.x-5, start.y-5, 10, 10);
                break;
            case ControlPoint:
                g2d.setColor(Color.orange);
                g2d.fillOval(start.x-5, start.y-5, 10, 10);
                break;
            case StartPoint: 
                g2d.setColor(Color.cyan);
                g2d.fillRect(start.x-5, start.y-5, 10, 10);
                break;
            case SplinePoint: 
                g2d.setColor(Color.pink);
                g2d.fillRoundRect(start.x-5, start.y-5, 10, 10, 3, 3);
                break;
            case EndSplinePoint: 
                g2d.setColor(Color.green);
                g2d.fillRoundRect(start.x-5, start.y-5, 10, 10, 3, 3);
                break;
        }
    }
}
