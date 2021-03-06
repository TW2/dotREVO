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
package dotrevo;

import dotrevo.dialog.ConcentricDialog;
import dotrevo.drawing.ConcentricShape;
import dotrevo.lib.Sheet2D;
import dotrevo.renderer.ConcentricListRenderer;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Phil
 */
public class Revolution extends javax.swing.JFrame {

    Sheet2D s2d = new Sheet2D();
    DefaultListModel concentricListModel = new DefaultListModel();
    
    /**
     * Creates new form Revolution
     */
    public Revolution() {
        initComponents();
        init();
    }
    
    private void init(){
        try {
            javax.swing.UIManager.setLookAndFeel(new NimbusLookAndFeel());
            javax.swing.SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException exc) {
            System.out.println("Nimbus LookAndFeel not loaded : "+exc);
        }
        
        //-- dim >> Obtient la taille de l'écran
        //-- gconf >> Obtient la configuration de l'écran
        //-- insets >> Obtient les 'marges' de l'écran
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension dim = toolkit.getScreenSize();
        java.awt.GraphicsConfiguration gconf = java.awt.GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();
        java.awt.Insets insets = toolkit.getScreenInsets(gconf);
        setSize(dim.width - insets.left - insets.right,
                dim.height - insets.top - insets.bottom);
        
        s2d.setPreferredSize(new Dimension(2000, 2000));
        spSheet2D.setViewportView(s2d);
        s2d.revalidate();
        spSheet2D.updateUI();
        
        listConcentricShapes.setCellRenderer(new ConcentricListRenderer());
        listConcentricShapes.setModel(concentricListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDraw = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panView = new javax.swing.JPanel();
        pan2D = new javax.swing.JPanel();
        tb2D = new javax.swing.JToolBar();
        tbNoShape = new javax.swing.JToggleButton();
        tbLine = new javax.swing.JToggleButton();
        tbBezier = new javax.swing.JToggleButton();
        panGraFx2D = new javax.swing.JPanel();
        spSheet2D = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfShape2DName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfShape2DAuthors = new javax.swing.JTextField();
        btnCAdd = new javax.swing.JButton();
        btnCRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listConcentricShapes = new javax.swing.JList();
        pan3D = new javax.swing.JPanel();
        panSFX = new javax.swing.JPanel();
        panScript = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dotREVO :: Revolution :: Started in 2015");

        javax.swing.GroupLayout panViewLayout = new javax.swing.GroupLayout(panView);
        panView.setLayout(panViewLayout);
        panViewLayout.setHorizontalGroup(
            panViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        panViewLayout.setVerticalGroup(
            panViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("View", panView);

        tb2D.setFloatable(false);
        tb2D.setRollover(true);

        bgDraw.add(tbNoShape);
        tbNoShape.setSelected(true);
        tbNoShape.setText("No tool");
        tbNoShape.setFocusable(false);
        tbNoShape.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbNoShape.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tb2D.add(tbNoShape);

        bgDraw.add(tbLine);
        tbLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dotrevo/images/AFM-DrawingLine.png"))); // NOI18N
        tbLine.setToolTipText("Line");
        tbLine.setFocusable(false);
        tbLine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbLine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbLineActionPerformed(evt);
            }
        });
        tb2D.add(tbLine);

        bgDraw.add(tbBezier);
        tbBezier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dotrevo/images/AFM-DrawingBezier.png"))); // NOI18N
        tbBezier.setToolTipText("Bezier");
        tbBezier.setFocusable(false);
        tbBezier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBezier.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbBezier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBezierActionPerformed(evt);
            }
        });
        tb2D.add(tbBezier);

        panGraFx2D.setLayout(new java.awt.BorderLayout());

        spSheet2D.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spSheet2D.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panGraFx2D.add(spSheet2D, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name :");

        tfShape2DName.setText("dotREVO shape 1");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Auth : ");

        tfShape2DAuthors.setText("Me");

        btnCAdd.setText("Add a concentric shape");
        btnCAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCAddActionPerformed(evt);
            }
        });

        btnCRemove.setText("Remove one of them");
        btnCRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRemoveActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listConcentricShapes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listConcentricShapes);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfShape2DAuthors)
                            .addComponent(tfShape2DName)))
                    .addComponent(btnCAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnCRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfShape2DName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfShape2DAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pan2DLayout = new javax.swing.GroupLayout(pan2D);
        pan2D.setLayout(pan2DLayout);
        pan2DLayout.setHorizontalGroup(
            pan2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tb2D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pan2DLayout.createSequentialGroup()
                .addComponent(panGraFx2D, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pan2DLayout.setVerticalGroup(
            pan2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2DLayout.createSequentialGroup()
                .addComponent(tb2D, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panGraFx2D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("2D lab", pan2D);

        javax.swing.GroupLayout pan3DLayout = new javax.swing.GroupLayout(pan3D);
        pan3D.setLayout(pan3DLayout);
        pan3DLayout.setHorizontalGroup(
            pan3DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        pan3DLayout.setVerticalGroup(
            pan3DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("3D lab", pan3D);

        javax.swing.GroupLayout panSFXLayout = new javax.swing.GroupLayout(panSFX);
        panSFX.setLayout(panSFXLayout);
        panSFXLayout.setHorizontalGroup(
            panSFXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        panSFXLayout.setVerticalGroup(
            panSFXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("SFX lab", panSFX);

        javax.swing.GroupLayout panScriptLayout = new javax.swing.GroupLayout(panScript);
        panScript.setLayout(panScriptLayout);
        panScriptLayout.setHorizontalGroup(
            panScriptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        panScriptLayout.setVerticalGroup(
            panScriptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Script", panScript);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbLineActionPerformed
        s2d.setSelection(Sheet2D.ShapeSelected.Line);
    }//GEN-LAST:event_tbLineActionPerformed

    private void tbBezierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBezierActionPerformed
        s2d.setSelection(Sheet2D.ShapeSelected.Bezier);
    }//GEN-LAST:event_tbBezierActionPerformed

    private void btnCAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCAddActionPerformed
        ConcentricShape c = new ConcentricShape();
        ConcentricDialog cd = new ConcentricDialog(this, true);
        boolean b = cd.showDialog();
        if(b == true){
            c.setName(cd.getConcentricName());
            c.setPercent(cd.getConcentricPercent());
            c.setRotation(cd.getConcentricRotation());
            c.setColor(cd.getConcentricColor());
            c.setParents(s2d.getShapes());            
            concentricListModel.addElement(c);
            List<ConcentricShape> co = new ArrayList<>();
            for(int i=0;i<concentricListModel.size();i++){
                co.add((ConcentricShape)concentricListModel.get(i));
            }        
            s2d.updateConcentricShape(co);
        }
    }//GEN-LAST:event_btnCAddActionPerformed

    private void btnCRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCRemoveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Revolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Revolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Revolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Revolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Revolution().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDraw;
    private javax.swing.JButton btnCAdd;
    private javax.swing.JButton btnCRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList listConcentricShapes;
    private javax.swing.JPanel pan2D;
    private javax.swing.JPanel pan3D;
    private javax.swing.JPanel panGraFx2D;
    private javax.swing.JPanel panSFX;
    private javax.swing.JPanel panScript;
    private javax.swing.JPanel panView;
    private javax.swing.JScrollPane spSheet2D;
    private javax.swing.JToolBar tb2D;
    private javax.swing.JToggleButton tbBezier;
    private javax.swing.JToggleButton tbLine;
    private javax.swing.JToggleButton tbNoShape;
    private javax.swing.JTextField tfShape2DAuthors;
    private javax.swing.JTextField tfShape2DName;
    // End of variables declaration//GEN-END:variables
}
