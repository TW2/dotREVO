/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotrevo.lib;

import dotrevo.drawing.AShape;
import dotrevo.drawing.Bezier;
import dotrevo.drawing.ConcentricShape;
import dotrevo.drawing.Line;
import dotrevo.drawing.SharedPoint;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author Phil
 */
public class Sheet2D extends JPanel {

    private List<AShape> shapes = new ArrayList<>();
    private ShapeSelected shapeSelected = ShapeSelected.None;
    private Point oldPoint = new Point(0, 0);
    private boolean inModification = false;
    private List<ConcentricShape> cshapes = new ArrayList<>();
    
    
    public Sheet2D() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vtdtMouseClicked(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vtdMousePressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vtdMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                vtdMouseDragged(evt);
            }
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                vtdMouseMoved(evt);
            }
        });
    }
    
    public enum ShapeSelected{
        None, Line, Bezier, Spline;
    }
    
    // <editor-fold defaultstate="collapsed" desc="-----<EVENTS>-----">
    public void vtdtMouseClicked(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
        if(evt.getButton() == 1){
            if(shapes.isEmpty()){
                //Si la liste est vide alors on ajoute le premier point qui
                //est un SharedPoint du type StartPoint.
                SharedPoint sp = SharedPoint.create(SharedPoint.Kind.StartPoint, evt.getPoint());
                shapes.add(sp);
            }else{
                if(shapeSelected == ShapeSelected.Line){
                    Line l = Line.create(AShape.getLastEnd(shapes), evt.getPoint());
                    shapes.add(l);
                    SharedPoint sp = SharedPoint.create(SharedPoint.Kind.Point, l.getEnd());
                    shapes.add(sp);
                }else if(shapeSelected == ShapeSelected.Bezier){
                    Bezier b = Bezier.create(AShape.getLastEnd(shapes), evt.getPoint());
                    shapes.add(b);
                    SharedPoint cp1 = SharedPoint.create(SharedPoint.Kind.ControlPoint, b.getCP1());
                    shapes.add(cp1);
                    SharedPoint cp2 = SharedPoint.create(SharedPoint.Kind.ControlPoint, b.getCP2());
                    shapes.add(cp2);
                    SharedPoint sp = SharedPoint.create(SharedPoint.Kind.Point, b.getEnd());
                    shapes.add(sp);
                }else if(shapeSelected == ShapeSelected.Spline){
                    //TODO
                }
            }        
        }
        
        
        repaint();
    }
    
    public void vtdMousePressed(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
        if(evt.getButton()==3){
            oldPoint = evt.getPoint(); inModification = true;
            repaint();
        }
    }
    
    public void vtdMouseReleased(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
        if(evt.getButton()==3){
            AShape.updatePoint(shapes, oldPoint, evt.getPoint()); inModification = false;
            repaint();
        }
    }
    
    public void vtdMouseDragged(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
        if(inModification == true){
            AShape.updatePoint(shapes, oldPoint, evt.getPoint());
            oldPoint = evt.getPoint();
            repaint();
        }
    }
    
    public void vtdMouseMoved(java.awt.event.MouseEvent evt){
        
    }
    // </editor-fold>
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        //Efface la zone
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        //Dessin des lignes
        g2d.setColor(new Color(216,255,253));
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawLine(getWidth()/2, 0, getWidth()/2, getHeight()); //vertical
        g2d.drawLine(0, getHeight()/2, getWidth(), getHeight()/2); //horizontal
        g2d.setColor(new Color(234,216,255));
        g2d.setStroke(new BasicStroke(1f));
        int i = getWidth()/2;
        while(i>=0){ i=i-25; g2d.drawLine(i, 0, i, getHeight()); }
        i = getWidth()/2;
        while(i<=getWidth()){ i=i+25; g2d.drawLine(i, 0, i, getHeight()); }
        i = getHeight()/2;
        while(i>=0){ i=i-25; g2d.drawLine(0, i, getWidth(), i); }
        i = getHeight()/2;
        while(i<=getHeight()){ i=i+25; g2d.drawLine(0, i, getWidth(), i); }

        //Dessine la zone
        g2d.setColor(Color.green);
        g2d.fill(AShape.getGeneralPath(shapes));
        
        //Dessine les formes concentriques et leur zone
        Map<ConcentricShape,List<AShape>> map = AShape.getConcentrics(cshapes);
        for(ConcentricShape c : cshapes){
            //Récupère les données
            List<AShape> rshapes = map.get(c);
            //Dessine la zone
            g2d.setColor(c.getColor());
            g2d.fill(AShape.getGeneralPath(rshapes));
            //Dessine la forme concentrique            
            for(AShape a : rshapes){
                if(a instanceof Line){
                    Line l = (Line)a;
                    l.drawConcentric(g);
                }else if(a instanceof Bezier){
                    Bezier b = (Bezier)a;
                    b.drawConcentric(g);
                }else if(a instanceof SharedPoint){
                    //SharedPoint sp = (SharedPoint)a;
                    //sp.draw(g);
                }
            }
        }
        
        //Dessine les formes
        shapes.stream().forEach((a) -> {
            if(a instanceof Line){
                Line l = (Line)a;
                l.draw(g);
            }else if(a instanceof Bezier){
                Bezier b = (Bezier)a;
                b.draw(g);
            }else if(a instanceof SharedPoint){
                SharedPoint sp = (SharedPoint)a;
                sp.draw(g);
            }
        });        
                
        //Dessine la milieu de la forme s'il existe
        Point centroid = AShape.getCentroid(shapes);
        if(centroid != null){
            g2d.setColor(Color.black);
            g2d.fillRect(centroid.x-5, centroid.y-5, 10, 10);
        }
        
    }
    
    public void setSelection(ShapeSelected s){
        shapeSelected = s;
    }
    
    public void updateConcentricShape(List<ConcentricShape> cshapes){
        this.cshapes = cshapes;
        repaint();
    }
    
    public List<AShape> getShapes(){
        return shapes;
    }
    
}
