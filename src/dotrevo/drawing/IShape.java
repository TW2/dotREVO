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
