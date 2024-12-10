/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Sistema.gui;

import Sistema.datos.BaseDatos;
import Sistema.pojos.Personal;
import java.awt.Color;
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
public class PersonalFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos base = new BaseDatos();
    Personal personaSeleccionada = null;
    
    
    public PersonalFrame() {
        initComponents();
        cargarColumnasTabla();
        cargarModeloTabla();
    }

    private void cargarColumnasTabla(){
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Puesto");
        //modeloTabla.addColumn("Salario");
        modeloTabla.addColumn("Horario");
    }
    
    private void cargarModeloTabla(){
        ArrayList<Personal>listaPersonal = base.obtenerPersonal();
        int numeroPersonas = listaPersonal.size();
        modeloTabla.setNumRows(numeroPersonas);
        
        for(int i = 0; i < numeroPersonas; i++){
            Personal persona = listaPersonal.get(i);
            
            String telefono = persona.getTelefono();
            String nombre = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(); // Concatenamos todo el nombre del Miembro
            String correo = persona.getCorreo();
            String puesto = persona.getPuesto();
            //String salario = persona.getSalario();
            String horario = persona.getHorario(); 
            
            modeloTabla.setValueAt(persona, i, 0);
            modeloTabla.setValueAt(nombre, i, 1);
            modeloTabla.setValueAt(correo, i, 2);
            modeloTabla.setValueAt(puesto, i, 3);
           //modeloTabla.setValueAt(salario, i, 4);
            modeloTabla.setValueAt(horario, i, 4);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblDescanso = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonal = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        setTitle("Gestión de Personal");
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setPreferredSize(new java.awt.Dimension(1000, 500));

        btnNuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(204, 255, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Telefono o Nombre del Empleado:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        lblNombre.setText("...");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Rol del Empleado:");

        lblRol.setText("...");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de Ingreso:");

        lblFecha.setText("...");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Horario Laboral:");

        lblHorario.setText("...");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Telefono:");

        lblTelefono.setText("...");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Correo Electronico:");

        lblCorreo.setText("...");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Salario: ");

        lblSalario.setText("...");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Dias Descanso:");

        lblDescanso.setText("...");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Estado:");

        lblEstado.setText("...");

        tablaPersonal.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tablaPersonal.getSelectedRow() >= 0)){
                        int filaSeleccionada = tablaPersonal.getSelectedRow();
                        ImageIcon imagenPersona = null;
                        Personal persona = (Personal)modeloTabla.getValueAt(filaSeleccionada, 0);                
                        lblTelefono.setText(persona.getTelefono());
                        lblNombre.setText(persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
                        lblRol.setText(persona.getPuesto());
                        lblFecha.setText(persona.getFechaContratacion());
                        lblHorario.setText(persona.getHorario());
                        lblSalario.setText(persona.getSalario());
                        lblCorreo.setText(persona.getCorreo());
                        lblDescanso.setText(persona.getDias());
                        if(persona.getEstado()){
                            lblEstado.setText("Activo");
                            lblEstado.setOpaque(true);
                            lblEstado.setForeground(Color.BLACK);
                            lblEstado.setBackground(Color.GREEN);
                        }else{
                            lblEstado.setOpaque(true);
                            lblEstado.setForeground(Color.WHITE);
                            lblEstado.setBackground(Color.RED);
                            lblEstado.setText("Inactivo");
                        }
                        personaSeleccionada = persona;

                        try{
                            /* Obtener Imagen*/
                            InputStream is = base.buscarFotoPersonal(personaSeleccionada);
                            BufferedImage bi = ImageIO.read(is);
                            imagenPersona = new ImageIcon(bi);

                        } catch (IOException ex){
                            ex.printStackTrace();
                        }

                        lblFoto.setIcon(imagenPersona);
                    }
                }
            }
        );
        tablaPersonal.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaPersonal);

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 204, 204));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 153, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        lblFoto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setText("             FOTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnActualizar.setBackground(new java.awt.Color(102, 102, 102));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 102));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(207, 207, 207)
                                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel9))
                                        .addGap(163, 163, 163)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel21))
                                                .addGap(75, 75, 75)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNombre)
                                                    .addComponent(lblEstado)
                                                    .addComponent(lblSalario)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblCorreo)))))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblRol)
                                    .addComponent(lblHorario)
                                    .addComponent(lblDescanso)
                                    .addComponent(lblFecha))))
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(lblTelefono)
                            .addComponent(lblNombre))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblRol)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(lblCorreo)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lblSalario)
                            .addComponent(jLabel19)
                            .addComponent(lblDescanso)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblEstado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblFecha)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblHorario))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarModeloTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modeloTabla.removeRow(i);
            }
        }
    }
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        AltaPersonalFrame nuevoPersonal = new AltaPersonalFrame(null,true);
        nuevoPersonal.setVisible(true);
        nuevoPersonal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevoPersonal.setLocation(600, 150);
        nuevoPersonal.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        limpiarTabla();
        String cadenaBusqueda = campoBuscar.getText();
        ArrayList<Personal> listaPersonal = base.obtenerPersonal(cadenaBusqueda);
        
        int numeroPersonas = listaPersonal.size();
        modeloTabla.setNumRows(numeroPersonas);
        for(int i = 0; i < numeroPersonas; i++){
            Personal persona = listaPersonal.get(i);
            String telefono = persona.getTelefono();
            String nombre = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(); // Concatenamos todo el nombre del Miembro
            String correo = persona.getCorreo();
            String puesto = persona.getPuesto();
            String horario = persona.getHorario();
            
            
            modeloTabla.setValueAt(persona, i, 0);
            modeloTabla.setValueAt(nombre, i, 1);
            modeloTabla.setValueAt(correo, i, 2);
            modeloTabla.setValueAt(puesto, i, 3);
            modeloTabla.setValueAt(horario, i, 4);
            
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Boolean estado = personaSeleccionada.getEstado();
        if(estado == true){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas Seguro de Borar este Miembro?");
                if(opcion == 0){
                    base.borarPersonal(personaSeleccionada);
                }
        }else
            JOptionPane.showMessageDialog(this, "El Miembro ya esta Inactivo");  
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombrePersonal = personaSeleccionada.getNombre() + " " + personaSeleccionada.getApellidoPaterno() + " " + personaSeleccionada.getApellidoMaterno();
        ImageIcon imagenPersona = null;
        EditarPersonalFrame framePersona = null;
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estas Seguro de modificar a " + nombrePersonal + "?");
        
        if(opcion == 0){
            try{
                /* Obtener Imagen*/
                InputStream is = base.buscarFotoPersonal(personaSeleccionada);
                BufferedImage bi = ImageIO.read(is);
                imagenPersona = new ImageIcon(bi);
                
                /*Crear Ventana de Actualizacion*/
                framePersona = new EditarPersonalFrame(null, true, personaSeleccionada, imagenPersona, "Actualizar Miembro");
                framePersona.setVisible(true);
                
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDescanso;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tablaPersonal;
    // End of variables declaration//GEN-END:variables
}
