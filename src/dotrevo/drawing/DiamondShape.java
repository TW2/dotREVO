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
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Phil
 */
public class DiamondShape {
    
    private Point reference = null; //Point de gravité de la forme d'origine (centroid)
    private Map<Float,Color> colors = new HashMap<>();
    private AShape lastShape = null;
    
    public DiamondShape(){
        
    }
    
    public void setReference(Point reference){
        this.reference = reference;
    }
    
    public Point getReference(){
        return reference;
    }
    
    public void setShape(AShape lastShape){
        this.lastShape = lastShape;
    }
    
    public AShape getShape(){
        return lastShape;
    }
    
    public void setColor(Color c){
        colors.clear();
        colors.put(1f, c);
    }
    
    public void addColor(Color c, float percent){
        colors.put(percent, c);
    }
    
    public void removeColor(float percent){
        colors.remove(percent);
    }
    
    public void clearColors(){
        colors.clear();
    }
    
    private Point getPoint(Point from, Point to, float percent){
        return new Point((int)(from.x+(to.x-from.x)*percent),(int)(from.y+(to.y-from.y)*percent));
    }
    
    public void draw(Graphics g){
        if(colors.isEmpty()==false){
            if(colors.size()==1){
                //generalpath
                GeneralPath gp = new GeneralPath();
                gp.moveTo(reference.getX(), reference.getY());
                gp.lineTo(lastShape.start.getX(), lastShape.start.getY());
                if(lastShape instanceof Line){
                    gp.lineTo(lastShape.end.getX(), lastShape.end.getY());
                }else if(lastShape instanceof Bezier){
                    gp.curveTo(lastShape.cp1.getX(), lastShape.cp1.getY(), lastShape.cp2.getX(), lastShape.cp2.getY(), lastShape.end.getX(), lastShape.end.getY());
                }
                gp.lineTo(reference.getX(), reference.getY());
                //remplissage
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor(colors.get(1f));
                g2d.fill(gp);
            }else{
                
                //generalpath
                
                //remplissage
            }
        }
    }
    
}
