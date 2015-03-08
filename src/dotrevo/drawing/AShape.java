/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotrevo.drawing;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Phil
 */
public abstract class AShape implements IShape {
    
    protected Point start = new Point(0, 0);
    protected Point end = new Point(0, 0);
    protected Point cp1 = new Point(0, 0);
    protected Point cp2 = new Point(0, 0);
    
    public AShape(){
        
    }
    
    @Override
    public void setStart(Point p){
        start = p;
    }
    
    @Override
    public Point getStart(){
        return start;
    }
    
    @Override
    public void setEnd(Point p){
        end = p;
    }
    
    @Override
    public Point getEnd(){
        return end;
    }
    
    @Override
    public boolean isStart(Point p){
        return p.getLocation().equals(start.getLocation());
    }
    
    @Override
    public boolean isEnd(Point p){
        return p.getLocation().equals(end.getLocation());
    }
    
    @Override
    public void setCP1(Point p){
        cp1 = p;
    }
    
    @Override
    public Point getCP1(){
        return cp1;
    }
    
    @Override
    public void setCP2(Point p){
        cp2 = p;
    }
    
    @Override
    public Point getCP2(){
        return cp2;
    }
    
    @Override
    public boolean isCP1(Point p){
        return p.getLocation().equals(cp1.getLocation());
    }
    
    @Override
    public boolean isCP2(Point p){
        return p.getLocation().equals(cp2.getLocation());
    }
    
    @Override
    public boolean isPoint(Point p){
        return isStart(p) | isEnd(p);
    }
    
    @Override
    public boolean isControlPoint(Point p){
        return isCP1(p) | isCP2(p);
    }
    
    public boolean isStartNear(Point p){
        Rectangle r = new Rectangle(p.x-5, p.y-5, 10, 10);
        return r.contains(start.getLocation());
    }
    
    public boolean isEndNear(Point p){
        Rectangle r = new Rectangle(p.x-5, p.y-5, 10, 10);
        return r.contains(end.getLocation());
    }
    
    public boolean isCP1Near(Point p){
        Rectangle r = new Rectangle(p.x-5, p.y-5, 10, 10);
        return r.contains(cp1.getLocation());
    }
    
    public boolean isCP2Near(Point p){
        Rectangle r = new Rectangle(p.x-5, p.y-5, 10, 10);
        return r.contains(cp2.getLocation());
    }
    
    public boolean isPointNear(Point p){
        return isStartNear(p) | isEndNear(p);
    }
    
    public boolean isControlPointNear(Point p){
        return isCP1Near(p) | isCP2Near(p);
    }
    
    public static SharedPoint getLastSharedPoint(List<AShape> shapes){
        for(int i=shapes.size()-1; i>=0; i--){
            AShape a = shapes.get(i);
            if(a instanceof SharedPoint){
                return (SharedPoint)a;
            }
        }
        return null;
    }
    
    public static Point getLastEnd(List<AShape> shapes){
        if(!shapes.isEmpty()){
            return shapes.get(shapes.size()-1).end;
        }
        return null;
    }
    
    public static List<AShape> getShapesNear(List<AShape> shapes, Point p){
        List<AShape> rshapes = new ArrayList<>();
        shapes.stream().filter((a) -> (a.isPointNear(p) | a.isControlPointNear(p))).forEach((a) -> {
            rshapes.add(a);
        });
        return rshapes;
    }
    
    public static void tryUpdatePoint(AShape shape, Point old, Point update){
        if(shape.isStartNear(old)){
            shape.start = update;
        }
        if(shape.isEndNear(old)){
            shape.end = update;
        }
        if(shape.isCP1Near(old)){
            shape.cp1 = update;
        }
        if(shape.isCP2Near(old)){
            shape.cp2 = update;
        }
    }
    
    public static void updatePoint(List<AShape> shapes, Point old, Point update){
        List<AShape> rshapes = getShapesNear(shapes, old);
        rshapes.stream().forEach((a) -> {
            tryUpdatePoint(a, old, update);
        });
    }
    
    public static GeneralPath getGeneralPath(List<AShape> shapes){
        GeneralPath gp = new GeneralPath();
        shapes.stream().forEach((a) -> {
            if(a instanceof SharedPoint){
                SharedPoint sp = (SharedPoint)a;
                if(sp.getKind() == SharedPoint.Kind.StartPoint){
                    gp.moveTo(sp.start.getX(), sp.start.getY());
                }
            }else if(a instanceof Line){
                Line l = (Line)a;
                gp.lineTo(l.end.getX(), l.end.getY());
            }else if(a instanceof Bezier){
                Bezier b = (Bezier)a;
                gp.curveTo(b.cp1.getX(), b.cp1.getY(), b.cp2.getX(), b.cp2.getY(), b.end.getX(), b.end.getY());
            }
        });
        return gp;
    }
    
    public static Point getCentroid(List<AShape> shapes){
        List<Point> knots = new ArrayList<>();
        shapes.stream().filter((a) -> (a instanceof SharedPoint)).map((a) -> (SharedPoint)a).forEach((sp) -> {
            if(sp.getKind() == SharedPoint.Kind.StartPoint){
                knots.add(sp.start);
            }else if(sp.getKind() == SharedPoint.Kind.Point){
                knots.add(sp.start);
            }else if(sp.getKind() == SharedPoint.Kind.ControlPoint){
                knots.add(sp.start);
            }
        });
        
        double centroidX = 0, centroidY = 0;

        for(Point knot : knots) {
            centroidX += knot.getX();
            centroidY += knot.getY();
        }
        
        try{
            return new Point((int)(centroidX / knots.size()), (int)(centroidY / knots.size()));
        }catch(Exception ex){
            return null;
        }
    }
    
    public static Point getPoint(Point from, Point to, float percent){
        return new Point((int)(from.x+(to.x-from.x)*percent),(int)(from.y+(to.y-from.y)*percent));
    }
    
    public static Map<ConcentricShape,List<AShape>> getConcentrics(List<ConcentricShape> co){
        Map<ConcentricShape,List<AShape>> map = new HashMap<>();
        
        for(ConcentricShape c : co){
            List<AShape> parents = c.getParents();
            List<AShape> child = new ArrayList<>();
            Point centroid = getCentroid(parents);
            
            for(AShape a : parents){
                if(a instanceof SharedPoint){
                    SharedPoint sp = (SharedPoint)a;
                    if(sp.getKind() == SharedPoint.Kind.StartPoint){
                        Point p = getPoint(centroid, sp.start, c.getPercent());
                        SharedPoint n = SharedPoint.create(SharedPoint.Kind.StartPoint, p);
                        child.add(n);
                    }else if(sp.getKind() == SharedPoint.Kind.Point){
                        Point p = getPoint(centroid, sp.start, c.getPercent());
                        SharedPoint n = SharedPoint.create(SharedPoint.Kind.Point, p);
                        child.add(n);
                    }else if(sp.getKind() == SharedPoint.Kind.ControlPoint){
                        Point p = getPoint(centroid, sp.start, c.getPercent());
                        SharedPoint n = SharedPoint.create(SharedPoint.Kind.ControlPoint, p);
                        child.add(n);
                    }
                }else if(a instanceof Line){
                    Line l = (Line)a;
                    Point p1 = getPoint(centroid, l.start, c.getPercent());
                    Point p2 = getPoint(centroid, l.end, c.getPercent());
                    Line n = Line.create(p1, p2);
                    child.add(n);
                }else if(a instanceof Bezier){
                    Bezier b = (Bezier)a;
                    Point p1 = getPoint(centroid, b.start, c.getPercent());
                    Point p2 = getPoint(centroid, b.cp1, c.getPercent());
                    Point p3 = getPoint(centroid, b.cp2, c.getPercent());
                    Point p4 = getPoint(centroid, b.end, c.getPercent());
                    Bezier n = Bezier.create(p1, p2, p3, p4);
                    child.add(n);
                }
            }
            
            map.put(c, child);
        }
        
        return map;
    }
}
