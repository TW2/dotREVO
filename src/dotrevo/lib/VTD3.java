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
package dotrevo.lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Phil
 */
public class VTD3 extends JPanel{
    
    private BufferedImage mainImage = null;
    private int mainframe = 0;
    private int width = 1280, virtualWidth = 1280;
    private int height = 720, virtualHeight = 720;
    
    public VTD3(){        
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
    
    // <editor-fold defaultstate="collapsed" desc="-----<EVENTS>-----">
    public void vtdtMouseClicked(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
        repaint();
    }
    
    public void vtdMousePressed(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
    }
    
    public void vtdMouseReleased(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
        
    }
    
    public void vtdMouseDragged(java.awt.event.MouseEvent evt){
        double xa = evt.getXOnScreen()-getLocationOnScreen().getX();
        double ya = evt.getYOnScreen()-getLocationOnScreen().getY();
        
    }
    
    public void vtdMouseMoved(java.awt.event.MouseEvent evt){
        
    }
    // </editor-fold>
    
    public void init(){
        setSize(width, height);
    }
    
    public void setImage(BufferedImage mainImage){
        this.mainImage = mainImage;
        repaint();
    }
    
    public void setFrame(int mainframe){
        this.mainframe = mainframe;
        repaint();
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public void setVirtualWidth(int virtualWidth){
        this.virtualWidth = virtualWidth;        
        if(virtualWidth<width){
            setSize(virtualWidth, virtualWidth*height/width);
            System.out.println(virtualWidth+" / "+virtualWidth*height/width);
        }else{
            setSize(width, height);
        }
    }
    
    public void setVirtualHeight(int virtualHeight){
        this.virtualHeight = virtualHeight;
        if(virtualHeight<height){
            setSize(virtualHeight*width/height, virtualHeight);
            System.out.println(virtualHeight*width/height+" / "+virtualHeight);
        }else{
            setSize(width, height);
        }
    }
    
    public void updateDrawing(){
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        
        //On crÃ©e des graphics afin de peindre sur notre composant VTD2.
        Graphics2D g2 = (Graphics2D)g;
        
        //On crÃ©e une image avec une taille correspondant Ã  la vidÃ©o d'origine
        //afin de pouvoir dessiner dessus et puis aprÃ¨s on pourra rÃ©duire cette image
        //en utilisant la taille virtuel de la limite de notre composant hÃ´te.
        //Cette image sera peinte sur le VTD2 Ã  la fin.
        BufferedImage drawingTool = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gDT = drawingTool.createGraphics();
        
        //On commance notre processus de peinture sur l'image drawingTool
        
        gDT.setColor(Color.black);
        gDT.fillRect(0, 0, width, height);
        
        if(mainImage!=null){
            gDT.drawImage(mainImage, null, 0, 0);
        }
        
        //Le processus de peinture sur drawingToll est fini alors on met l'image
        //Ã  la bonne taille afin de crÃ©er l'aperÃ§u pour le VTD2.
        Image thumbnail = drawingTool.getScaledInstance(virtualWidth, virtualHeight, Image.SCALE_FAST);
        g2.drawImage(thumbnail, null, this);
        
    }
    
}
