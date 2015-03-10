/*
 * Copyright (C) 2015 Phil
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
