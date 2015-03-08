/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotrevo.drawing;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Phil
 */
public interface IShape {
    
    public void setStart(Point p);
    
    public Point getStart();
    
    public void setEnd(Point p);
    
    public Point getEnd();
    
    public boolean isStart(Point p);
    
    public boolean isEnd(Point p);
    
    public void setCP1(Point p);
    
    public Point getCP1();
    
    public void setCP2(Point p);
    
    public Point getCP2();
    
    public boolean isCP1(Point p);
    
    public boolean isCP2(Point p);
    
    public boolean isPoint(Point p);
    
    public boolean isControlPoint(Point p);
    
    public void draw(Graphics g);
    
}
