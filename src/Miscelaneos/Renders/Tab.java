/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscelaneos.Renders;

import Archivos.Archivos;
import Miscelaneos.Miscelaneo;
import Ventanas.Inicio;
import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB-INV-07
 */
public class Tab extends javax.swing.JPanel {

    /**
     * Creates new form Tab
     */
    public Tab(Archivos archivo,Inicio inicio) {
        
        initComponents();
        this.inicio=inicio;
        this.archivo=archivo;
        this.lbl_nombre.setText(this.archivo.nombre_archivo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nombre = new javax.swing.JLabel();
        lbl_cerrar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbl_nombre.setText("jLabel1");
        lbl_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nombreMouseClicked(evt);
            }
        });

        lbl_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cerrar.setText("X");
        lbl_cerrar.setOpaque(true);
        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbl_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
         Miscelaneo.guardar_archivo(archivo, inicio,true,false);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void lbl_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseEntered
        //System.out.println("asd");
        lbl_cerrar.setBackground(new Color(255,158,158,255));
    }//GEN-LAST:event_lbl_cerrarMouseEntered

    private void lbl_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseExited
        lbl_cerrar.setBackground(new Color(255,255,255,0));
    }//GEN-LAST:event_lbl_cerrarMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void lbl_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nombreMouseClicked
        inicio.archivo_seleccionado=archivo;
        Miscelaneo.seleccionar_tab(inicio.tabs, inicio.archivos_abiertos, archivo);
    }//GEN-LAST:event_lbl_nombreMouseClicked

    public Archivos archivo; 
    public Inicio inicio;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_nombre;
    // End of variables declaration//GEN-END:variables
}
