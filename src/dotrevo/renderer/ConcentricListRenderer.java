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
