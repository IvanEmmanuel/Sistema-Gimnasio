/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Sistema.gui;

import Sistema.datos.BaseDatos;
import Sistema.pojos.Equipo;
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
public class InventarioFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos base = new BaseDatos();
    Equipo equipoSeleccionado = null;
    
    
    public InventarioFrame() {
        initComponents();
        cargarColumnasTabla();
        cargarModeloTabla();
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    private void cargarColumnasTabla(){
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Categoria");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Ubicación");
        modeloTabla.addColumn("Fecha Adquisición");
    }
    
    private void cargarModeloTabla(){
        ArrayList<Equipo>listaInventario = base.obtenerInventario();
        int numeroRegistros = listaInventario.size();
        modeloTabla.setNumRows(numeroRegistros);
        
        for(int i = 0; i < numeroRegistros; i++){
            Equipo equipo = listaInventario.get(i);
            
            String nombre = equipo.getNombre();
            String categoria = equipo.getCategoria(); 
            int cantidad = equipo.getCantidad();
            String ubicacion = equipo.getUbicacion();
            String fecha = equipo.getFechaCompra(); 
            
            modeloTabla.setValueAt(equipo, i, 0);
            modeloTabla.setValueAt(categoria, i, 1);
            modeloTabla.setValueAt(cantidad, i, 2);
            modeloTabla.setValueAt(ubicacion, i, 3);
            modeloTabla.setValueAt(fecha, i, 4);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        lblCondicion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        campoBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setTitle("Inventario");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nombre del Equipo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Categoria:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad en Stok:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ubicación:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de Adquisición:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Condición:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Precio de Compra:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Estado:");

        lblNombre.setText("...");

        jLabel11.setText("...");

        lblCantidad.setText("...");

        lblCategoria.setText("...");

        lblFecha.setText("...");

        lblPrecio.setText("...");

        lblUbicacion.setText("...");

        lblCondicion.setText("...");

        tablaInventario.setModel(modeloTabla);
        tablaInventario.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tablaInventario.getSelectedRow() >= 0)){
                        int filaSeleccionada = tablaInventario.getSelectedRow();

                        Equipo equipo = (Equipo)modeloTabla.getValueAt(filaSeleccionada, 0);
                        lblNombre.setText(equipo.getNombre());
                        lblCategoria.setText(equipo.getCategoria());
                        String cantidad = String.valueOf(equipo.getCantidad());
                        String precio = String.valueOf(equipo.getPrecio());
                        lblCantidad.setText(cantidad);
                        lblUbicacion.setText(equipo.getUbicacion());
                        lblFecha.setText(equipo.getFechaCompra());
                        lblCondicion.setText(equipo.getCondicion());
                        lblPrecio.setText(precio);

                        if(equipo.getEstado()){
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
                        equipoSeleccionado = equipo;
                        desplegarFoto(equipo);
                        btnEditar.setEnabled(true);
                        btnEliminar.setEnabled(true);
                    }
                }
            }
        );
        jScrollPane1.setViewportView(tablaInventario);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Nombre del Equipo:");

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

        btnActualizar.setBackground(new java.awt.Color(102, 102, 102));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 102));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(204, 255, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        lblFoto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setText("                ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblEstado.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(26, 26, 26)
                                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblCantidad)
                                    .addComponent(lblFecha)
                                    .addComponent(lblPrecio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(34, 34, 34)))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUbicacion)
                            .addComponent(lblCondicion)
                            .addComponent(lblCategoria)
                            .addComponent(lblEstado))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblNombre)
                            .addComponent(jLabel2)
                            .addComponent(lblCategoria))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(lblCantidad)
                            .addComponent(lblUbicacion))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblFecha)
                            .addComponent(jLabel7)
                            .addComponent(lblCondicion))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(lblEstado))))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombreEquipo = equipoSeleccionado.getNombre();
        ImageIcon imagenEquipo = null;
        EditarEquipoFrame frameEquipo = null;
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estas Seguro de modificar " + nombreEquipo + "?");
        
        if(opcion == 0){
            try{
                /* Obtener Imagen*/
                InputStream is = base.buscarFotoInventario(equipoSeleccionado);
                BufferedImage bi = ImageIO.read(is);
                imagenEquipo = new ImageIcon(bi);
                
                /*Crear Ventana de Actualizacion*/
                frameEquipo = new EditarEquipoFrame(null, true, equipoSeleccionado, imagenEquipo, "Actualizar Equipo");
                frameEquipo.setVisible(true);
                
                btnEditar.setEnabled(false);
                btnEliminar.setEnabled(false);
                campoBuscar.setText("");
                lblNombre.setText("");
                lblCategoria.setText("");
                lblCantidad.setText("");
                lblUbicacion.setText("");
                lblFecha.setText("");
                lblCondicion.setText("");
                lblPrecio.setText("");
                lblEstado.setText("");
                lblFoto.setIcon(null);
                cargarModeloTabla();
                
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Boolean estado = equipoSeleccionado.getEstado();
        if(estado == true){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas Seguro de Borar este Registro?");
                if(opcion == 0){
                    base.borarEquipo(equipoSeleccionado);
                    cargarModeloTabla();
                    JOptionPane.showMessageDialog(this, "Datos Borrados Correctamente");
                    btnEditar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    campoBuscar.setText("");
                    lblNombre.setText("");
                    lblCategoria.setText("");
                    lblCantidad.setText("");
                    lblUbicacion.setText("");
                    lblFecha.setText("");
                    lblCondicion.setText("");
                    lblPrecio.setText("");
                    lblEstado.setText("");
                    lblFoto.setIcon(null);
                }
        }else
            JOptionPane.showMessageDialog(this, "El Elemento ya esta Inactivo"); 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       cargarModeloTabla();
       campoBuscar.setText("");
       //lblNombre.setText("");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        AltaEquipoFrame nuevoEquipo = new AltaEquipoFrame(null,true);
        nuevoEquipo.setVisible(true);
        nuevoEquipo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nuevoEquipo.setLocation(600, 150);
        nuevoEquipo.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

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
        ArrayList<Equipo> listaInventario = base.obtenerInventario(cadenaBusqueda);
        
        int numeroEquipo = listaInventario.size();
        modeloTabla.setNumRows(numeroEquipo);
        for(int i = 0; i < numeroEquipo; i++){
            Equipo equipo = listaInventario.get(i);
            String nombre = equipo.getNombre();
            String categoria = equipo.getCategoria(); // Concatenamos todo el nombre del Miembro
            int cantidad = equipo.getCantidad();
            String ubicacion = equipo.getUbicacion();
            String fecha = equipo.getFechaCompra();
            
            
            modeloTabla.setValueAt(equipo, i, 0);
            modeloTabla.setValueAt(categoria, i, 1);
            modeloTabla.setValueAt(cantidad, i, 2);
            modeloTabla.setValueAt(ubicacion, i, 3);
            modeloTabla.setValueAt(fecha, i, 4);
            
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modeloTabla.removeRow(i);
            }
        }
    }
    
    private void desplegarFoto(Equipo equipo){
        ImageIcon imagenEquipo = null;
        try{
                /* Obtener Imagen*/
            InputStream is = base.buscarFotoInventario(equipo);
            BufferedImage bi = ImageIO.read(is);
            imagenEquipo = new ImageIcon(bi);
            
            Image imgEquipo = imagenEquipo.getImage();
            int anchoEtiqueta = lblFoto.getWidth();
            int altoEtiqueta = lblFoto.getHeight();
            
            Image imgRedimensionada = imgEquipo.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
            
            ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
            lblFoto.setIcon(iconRedimensionado);
            
            } catch (IOException ex){
                ex.printStackTrace();
            }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCondicion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables
}
