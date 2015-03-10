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
