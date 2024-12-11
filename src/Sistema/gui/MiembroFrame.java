package Sistema.gui;

import Sistema.datos.BaseDatos;
import Sistema.pojos.MiembroBusqueda;
import Sistema.pojos.Miembros;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author IVAN
 */
public class MiembroFrame extends javax.swing.JDialog {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos base = new BaseDatos();
    MiembroBusqueda miembroSeleccionado = null;
    
    public MiembroFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarColumnasTabla();
        cargarModeloTabla();
    }
    
    private void cargarColumnasTabla(){
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Nombre");
        //modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Tipo Membresia");
        modeloTabla.addColumn("Fecha Proximo Pago");
        modeloTabla.addColumn("Tiempo");
        modeloTabla.addColumn("Estado de la Membresia");
        modeloTabla.addColumn("Estado del Miembro");
    }

    /*  Este metodo carga el modelo de la tabla de miembros     */
    private void cargarModeloTabla(){
        //ArrayList<Miembros>listaMiembros = base.obtenerMiembro();
        ArrayList<MiembroBusqueda>listaMiembros = base.obtenerMiembroBusqueda();
        int numeroMiembros = listaMiembros.size();
        modeloTabla.setNumRows(numeroMiembros);
        
        for(int i = 0; i < numeroMiembros; i++){
            MiembroBusqueda miembro = listaMiembros.get(i);
            
            //String telefonoMiembro = miembro.getTelefonoMiembro();
            String nombre = miembro.getNombre() + " " + miembro.getApellidoPaterno() + " " + miembro.getApellidoMaterno(); // Concatenamos todo el nombre del Miembro
            String tipoMembresia = miembro.getTipoMembresia();
            String fechaProximo = miembro.getFechaFinMembresia();
            Boolean estado = miembro.getEstadoMembresia();
            String tiempo = miembro.getTiempoMembresia();
            Boolean estadomiembro = miembro.getEstadoMiembro();
            
            //if(miembro.getEstadoMiembro() == true){
                modeloTabla.setValueAt(miembro, i, 0);
                modeloTabla.setValueAt(nombre, i, 1);
                modeloTabla.setValueAt(tipoMembresia, i, 2);
                modeloTabla.setValueAt(fechaProximo, i, 3);
                modeloTabla.setValueAt(tiempo, i, 4);
                if(estado)
                    modeloTabla.setValueAt("Activa", i, 5);
                else
                    modeloTabla.setValueAt("Inactiva", i, 5);
                
                if(estadomiembro)
                    modeloTabla.setValueAt("Activo", i, 6);
                else
                    modeloTabla.setValueAt("Inactivo", i, 6);
            //}
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMiembros = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblFin = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagenMiembro = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEstadoMiembro = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 204, 0));
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Teléfono o Nombre del Miembro:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre(s): ");

        lblNombre.setText("...");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Telefono");

        lblTelefono.setText("...");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Tipo de membresía:");

        lblTipo.setText("...");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Estado de la membresía:");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setText("...");

        tablaMiembros.setModel(modeloTabla);
        tablaMiembros.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tablaMiembros.getSelectedRow() >= 0)){
                        int filaSeleccionada = tablaMiembros.getSelectedRow();
                        MiembroBusqueda miembro = (MiembroBusqueda)modeloTabla.getValueAt(filaSeleccionada, 0);                
                        String telefono = String.valueOf(miembro.getTelefonoMiembro());
                        lblTelefono.setText(telefono);
                        lblNombre.setText(miembro.getNombre() + " " + miembro.getApellidoPaterno() + " " + miembro.getApellidoMaterno());
                        lblDomicilio.setText(miembro.getDireccion());
                        lblTipo.setText(miembro.getTipoMembresia());
                        lblFin.setText(miembro.getFechaFinMembresia());

                        if(miembro.getEstadoMembresia()){
                            lblEstado.setText("Activa");
                            lblEstado.setOpaque(true);
                            lblEstado.setForeground(Color.BLACK);
                            lblEstado.setBackground(Color.GREEN);
                        }else{
                            lblEstado.setOpaque(true);
                            lblEstado.setForeground(Color.WHITE);
                            lblEstado.setBackground(Color.RED);
                            lblEstado.setText("Inactiva");
                        }
                        if(miembro.getEstadoMiembro()){
                            lblEstadoMiembro.setText("Activo");
                            lblEstadoMiembro.setOpaque(true);
                            lblEstadoMiembro.setForeground(Color.BLACK);
                            lblEstadoMiembro.setBackground(Color.GREEN);
                        }else{
                            lblEstadoMiembro.setText("Inactivo");
                            lblEstadoMiembro.setOpaque(true);
                            lblEstadoMiembro.setForeground(Color.WHITE);
                            lblEstadoMiembro.setBackground(Color.RED);
                        }
                        miembroSeleccionado = miembro;
                        desplegarFoto(miembro);
                    }
                }
            }
        );
        jScrollPane1.setViewportView(tablaMiembros);

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 204, 204));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 0, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Fecha Proximo pago: ");

        lblFin.setText("...");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("Datos Personales");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("Opciones de Bsqueda");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblImagenMiembro.setBackground(new java.awt.Color(102, 102, 102));
        lblImagenMiembro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblImagenMiembro.setForeground(new java.awt.Color(255, 255, 255));
        lblImagenMiembro.setText("            ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblImagenMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblImagenMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Domiciolio:");

        lblDomicilio.setText("...");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Estado del Miembro:");

        lblEstadoMiembro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstadoMiembro.setText("...");

        jToggleButton1.setBackground(new java.awt.Color(102, 102, 102));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 102, 0));
        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel9))
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblDomicilio)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblTipo)
                                                            .addComponent(lblFin, javax.swing.GroupLayout.Alignment.LEADING))
                                                        .addGap(164, 164, 164)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel15)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel4))
                                                        .addGap(41, 41, 41)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblEstadoMiembro)
                                                            .addComponent(lblEstado)
                                                            .addComponent(lblNombre)))))))
                                    .addComponent(jLabel19)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel20)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel19)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel20)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblTelefono)
                                            .addGap(38, 38, 38)
                                            .addComponent(lblTipo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(113, 113, 113)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblFin)
                                                .addComponent(jLabel4)
                                                .addComponent(lblEstadoMiembro))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(38, 38, 38)
                                        .addComponent(lblEstado)
                                        .addGap(59, 59, 59))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDomicilio))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NuevoMiembroFrame nuevoMiembro = new NuevoMiembroFrame(null,true);
        nuevoMiembro.setVisible(true);
        nuevoMiembro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevoMiembro.setLocation(600, 150);
        nuevoMiembro.setAlwaysOnTop(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombreMiembro = miembroSeleccionado.getNombre() + " " + miembroSeleccionado.getApellidoPaterno() + " " + miembroSeleccionado.getApellidoMaterno();
        ImageIcon imagenMiembro = null;
        EditarMiembroFrame frameMiem = null;
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estas Seguro de modificar el Miembro " + nombreMiembro + "?");
        
        if(opcion == 0){
            try{
                /* Obtener Imagen*/
                InputStream is = base.buscarFoto(miembroSeleccionado);
                BufferedImage bi = ImageIO.read(is);
                imagenMiembro = new ImageIcon(bi);
                
                /*Crear Ventana de Actualizacion*/
                frameMiem = new EditarMiembroFrame(null, true, miembroSeleccionado, imagenMiembro, "Actualizar Miembro");
                frameMiem.setVisible(true);
                
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        
        
       
    }//GEN-LAST:event_btnEditarActionPerformed

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Retorna la cadena tal cual si está vacía o es nula
        }
        
        // Convierte la primera letra a mayúscula y concatena con el resto de la cadena
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        limpiarTabla();
        String cadena = campoBuscar.getText();
        String cadenaBusqueda = capitalizeFirstLetter(cadena);
        ArrayList<MiembroBusqueda> listaMiembros = base.obtenerMiembroBusqueda(cadenaBusqueda);
        
        int numeroMiembros = listaMiembros.size();
        modeloTabla.setNumRows(numeroMiembros);
        for(int i = 0; i < numeroMiembros; i++){
            MiembroBusqueda miembro = listaMiembros.get(i);
            String telefonoMiembro = miembro.getTelefonoMiembro();
            String nombre = miembro.getNombre() + " " + miembro.getApellidoPaterno() + " " + miembro.getApellidoMaterno(); // Concatenamos todo el nombre del Miembro
            String tipoMembresia = miembro.getTipoMembresia();
            String fechaProximo = miembro.getFechaFinMembresia();
            Boolean estado = miembro.getEstadoMembresia();
            String tiempo = miembro.getTiempoMembresia();
            Boolean estadoMiembro = miembro.getEstadoMiembro();
            
            
            modeloTabla.setValueAt(miembro, i, 0);
            modeloTabla.setValueAt(nombre, i, 1);
            modeloTabla.setValueAt(tipoMembresia, i, 2);
            modeloTabla.setValueAt(fechaProximo, i, 3);
            modeloTabla.setValueAt(tiempo, i, 4);
            if(estado)
                modeloTabla.setValueAt("Activa", i, 5);
            else
                modeloTabla.setValueAt("Inactiva", i, 5);
                
            if(estadoMiembro)
                modeloTabla.setValueAt("Activo", i, 6);
            else
                modeloTabla.setValueAt("Inactivo", i, 6);
            
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Boolean miembroEstado = miembroSeleccionado.getEstadoMiembro();
        if(miembroEstado == true){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas Seguro de Borar este Miembro?");
                if(opcion == 0){
                    base.borarMiembro(miembroSeleccionado);
                }
        }else
            JOptionPane.showMessageDialog(this, "El Miembro ya esta Inactivo");         
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MiembroFrame dialog = new MiembroFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void desplegarFoto(MiembroBusqueda miembro){
        ImageIcon imagenMiembro = null;
        try{
                /* Obtener Imagen*/
            InputStream is = base.buscarFoto(miembro);
            BufferedImage bi = ImageIO.read(is);
            imagenMiembro = new ImageIcon(bi);
            
            
            Image imgMiembro = imagenMiembro.getImage();
            int anchoEtiqueta = lblImagenMiembro.getWidth();
            int altoEtiqueta = lblImagenMiembro.getHeight();
            
            Image imgRedimensionada = imgMiembro.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
            
            ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
            lblImagenMiembro.setIcon(iconRedimensionado);
            
            } catch (IOException ex){
                    ex.printStackTrace();
            }
    
    }
    
    private void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modeloTabla.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoMiembro;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblImagenMiembro;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTable tablaMiembros;
    // End of variables declaration//GEN-END:variables
}
