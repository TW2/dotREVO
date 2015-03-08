/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotrevo.renderer;

import dotrevo.drawing.ConcentricShape;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

/**
 *
 * @author Phil
 */
public class ConcentricListRenderer extends JPanel implements ListCellRenderer{

    JLabel lblText = new JLabel();
    JLabel lblFill = new JLabel();
    JLabel lblRotation = new JLabel();
    JLabel lblPercent = new JLabel();
    
    public ConcentricListRenderer(){
        setOpaque(true);
        setLayout(null);
        setPreferredSize(new Dimension(getWidth(), 28));
        this.add(lblText);
        lblText.setLocation(0, 0);
        lblText.setSize(60, 28);
        lblText.setOpaque(true);
        this.add(lblFill);
        lblFill.setLocation(60, 0);
        lblFill.setSize(60, 28);
        lblFill.setOpaque(true);
        lblFill.setBorder(new LineBorder(Color.black, 2));
        this.add(lblRotation);
        lblRotation.setLocation(120, 0);
        lblRotation.setSize(60, 28);
        lblRotation.setOpaque(true);
        this.add(lblPercent);
        lblPercent.setLocation(180, 0);
        lblPercent.setSize(60, 28);
        lblPercent.setOpaque(true);
    }

    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof ConcentricShape){
            ConcentricShape c = (ConcentricShape)value;
            
            if(c.getName().isEmpty()){
                lblText.setText("  ID "+index);
            }else{
                lblText.setText("  "+c.getName());
            }
            
            lblRotation.setText("  "+c.getRotation()+"°");
            lblPercent.setText("  "+(c.getPercent()*100)+"%");
            
            if(isSelected==true){
                lblText.setBackground(SystemColor.controlHighlight);
                lblRotation.setBackground(SystemColor.controlHighlight);
                lblPercent.setBackground(SystemColor.controlHighlight);
                setBackground(SystemColor.controlHighlight);
            }else{
                lblText.setBackground(Color.white);
                lblRotation.setBackground(Color.white);
                lblPercent.setBackground(Color.white);
                setBackground(Color.white);
            }
            
            lblFill.setBackground(c.getColor());
            
            
            
        }
        
        return this;

    }
    
}
