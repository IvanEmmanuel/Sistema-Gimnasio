/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Sistema.gui;

import javax.swing.JDialog;

/**
 *
 * @author IVAN
 */
public class MembresiasFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form Membresias
     */
    public MembresiasFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorMembresiasPagos = new javax.swing.JDesktopPane();
        btnPagos = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnMembresia = new javax.swing.JButton();

        setTitle("Membresías y Pagos");

        btnPagos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnPagos.setText("Pagos");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });

        btnHistorial.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnMembresia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnMembresia.setText("Miembros");
        btnMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMembresiaActionPerformed(evt);
            }
        });

        contenedorMembresiasPagos.setLayer(btnPagos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedorMembresiasPagos.setLayer(btnHistorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedorMembresiasPagos.setLayer(btnMembresia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorMembresiasPagosLayout = new javax.swing.GroupLayout(contenedorMembresiasPagos);
        contenedorMembresiasPagos.setLayout(contenedorMembresiasPagosLayout);
        contenedorMembresiasPagosLayout.setHorizontalGroup(
            contenedorMembresiasPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorMembresiasPagosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        contenedorMembresiasPagosLayout.setVerticalGroup(
            contenedorMembresiasPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMembresia, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addComponent(btnPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorMembresiasPagos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorMembresiasPagos)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMembresiaActionPerformed
        MiembroFrame miembro = new MiembroFrame(null,true);
        miembro.setVisible(true);
        miembro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        miembro.setLocation(600, 150);
        miembro.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnMembresiaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        HistorialFrame historial = new HistorialFrame(null,true);
        historial.setVisible(true);
        historial.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        historial.setLocation(600, 150);
        historial.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        PagosFrame pago = new PagosFrame(null,true);
        pago.setVisible(true);
        pago.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pago.setLocation(600, 150);
        pago.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnPagosActionPerformed
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMembresia;
    private javax.swing.JButton btnPagos;
    private javax.swing.JDesktopPane contenedorMembresiasPagos;
    // End of variables declaration//GEN-END:variables
}
