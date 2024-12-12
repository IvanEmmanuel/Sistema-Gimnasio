/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Sistema.gui;

import Sistema.datos.BaseDatos;
import static Sistema.gui.NuevoMiembroFrame.fecha;
import static Sistema.gui.NuevoMiembroFrame.fechaTermino;
import Sistema.pojos.MiembroBusqueda;
import Sistema.pojos.Pagos;
import Sistema.pojos.TiposMembresia;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author IVAN
 */
public class PagosFrame extends javax.swing.JDialog {
    DefaultComboBoxModel <TiposMembresia> tipoMembresias;
    BaseDatos base;
    
    
    public PagosFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        base = new BaseDatos();
        tipoMembresias = new DefaultComboBoxModel<TiposMembresia>();
        initComponents();
        cargarTipoMembresia();
        comboTipoMembresia.setVisible(false);
        comboTiempo.setVisible(false);
        comboTipoPago.setVisible(false);
        btnPagar.setEnabled(false);
        fechaSis.setText(fecha());
        fechaSis.setVisible(false);
        fechaTermino.setVisible(false);
    }
    
    private void cargarTipoMembresia(){
        ArrayList<TiposMembresia> listaTiposMembresia;
        listaTiposMembresia = base.obtenerTiposMembresias();
        
        for(TiposMembresia tiposMembresias : listaTiposMembresia){
            tipoMembresias.addElement(tiposMembresias);
        }
    }
    
    
    private void cargarPrecio() {
    // Obtener el tipo de membresía seleccionado
    String tipoMembresia = comboTipoMembresia.getSelectedItem().toString();
    
    // Obtener el número de meses seleccionado (convirtiendo el texto a un número)
    String tiempoSeleccionado = comboTiempo.getSelectedItem().toString();
    
    if(tiempoSeleccionado != "- - - - - - - - - - - -"){
        int meses = Integer.parseInt(tiempoSeleccionado.split(" ")[0]);

        // Variables para precio base y descuento
        double precioBase = 0;
        double descuento = 0;

        // Establecer el precio base y el descuento según el tipo de membresía y meses
        switch (tipoMembresia) {
            case "Membresía Básica":
                precioBase = 300;
                if (meses == 6) descuento = 0.05; // 5% de descuento
                else if (meses == 8) descuento = 0.10; // 10% de descuento
                else if (meses == 10) descuento = 0.15; // 15% de descuento
                else if (meses == 12) descuento = 0.20; // 20% de descuento
                else descuento = 0.0;
                break;
            case "Membresía Estándar":
                precioBase = 500;
                if (meses == 6) descuento = 0.05;
                else if (meses == 8) descuento = 0.10;
                else if (meses == 10) descuento = 0.15;
                else if (meses == 12) descuento = 0.20;
                else descuento = 0.0;
                break;
            case "Membresía Premium":
                precioBase = 800;
                if (meses == 6) descuento = 0.05;
                else if (meses == 8) descuento = 0.10;
                else if (meses == 10) descuento = 0.15;
                else if (meses == 12) descuento = 0.20;
                break;
            case "Membresía VIP o Platino":
                precioBase = 1200;
                if (meses == 6) descuento = 0.05;
                else if (meses == 8) descuento = 0.10;
                else if (meses == 10) descuento = 0.15;
                else if (meses == 12) descuento = 0.20;
                break;
            case "Membresía de Fin de Semana":
                precioBase = 250;
                if (meses == 6) descuento = 0.05;
                else if (meses == 8) descuento = 0.10;
                else if (meses == 10) descuento = 0.15;
                else if (meses == 12) descuento = 0.20;
                break;
            case "Membresía para Adultos Mayores":
                precioBase = 300;
                if (meses == 6) descuento = 0.05;
                else if (meses == 8) descuento = 0.10;
                else if (meses == 10) descuento = 0.15;
                else if (meses == 12) descuento = 0.20;
                break;
            case "Membresía Corporativa":
                precioBase = 400;
                if (meses == 6) descuento = 0.05;
                else if (meses == 8) descuento = 0.10;
                else if (meses == 10) descuento = 0.15;
                else if (meses == 12) descuento = 0.20;
                break;
            default:
                break;
        }

            // Calcular el precio total sin descuento
            double totalSinDescuento = precioBase * meses;

            // Calcular el descuento total en pesos
            double totalDescuentoPesos = totalSinDescuento * descuento;

            // Calcular el precio total con el descuento aplicado
            double precioConDescuento = totalSinDescuento - totalDescuentoPesos;

            // Asignar el descuento y el total a los labels
            lblTotal.setText("$" + precioConDescuento);
        } else {
            lblTotal.setText("$0.0");
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTipoMembresia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTiempoMembresia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblExpiracion = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        comboTipoMembresia = new javax.swing.JComboBox<>();
        comboTiempo = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblInicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fechaSis = new javax.swing.JLabel();
        fechaTermino = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboTipoPago = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Telefono");

        campoNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 204, 0));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre del Miembro: ");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("...");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tipo de Membresia: ");

        lblTipoMembresia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipoMembresia.setText("...");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tiempo de la membresia:");

        lblTiempoMembresia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTiempoMembresia.setText("...");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Estado de la Membresía:");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado.setText("...");

        btnPagar.setBackground(new java.awt.Color(102, 102, 102));
        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(153, 255, 0));
        btnPagar.setText("Renovar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Fecha de expiración:");

        lblExpiracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblExpiracion.setText("...");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 204, 0));
        jLabel12.setText("Total a Pagar:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotal.setText("00.0");

        comboTipoMembresia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboTipoMembresia.setModel(tipoMembresias);
        comboTipoMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoMembresiaActionPerformed(evt);
            }
        });

        comboTiempo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - - - - - - - - - - -", "1 mes", "2 meses", "3 meses", "4 meses", "5 meses", "6 meses", "7 meses", "8 meses", "9 meses", "10 meses", "11 meses", "12 meses" }));
        comboTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTiempoActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(102, 102, 102));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 51, 0));
        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        lblInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInicio.setText("...");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Fecha de Inicio:");

        fechaSis.setText(".");

        fechaTermino.setText("..");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Metodo de Pago:");

        comboTipoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - - - - - - - - - - -", "Efectivo", "Tarjeta de Credito", "Tarjeta de Debito", "Transferencia" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Pagos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaSis)
                    .addComponent(fechaTermino))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(comboTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPagar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTipoMembresia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboTipoMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTiempoMembresia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboTiempo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblExpiracion)
                                    .addComponent(lblEstado)
                                    .addComponent(lblInicio))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTipoMembresia)
                    .addComponent(comboTipoMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTiempoMembresia)
                    .addComponent(comboTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblInicio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblExpiracion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fechaTermino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaSis)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoMembresiaActionPerformed
        cargarPrecio();
    }//GEN-LAST:event_comboTipoMembresiaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnPagar.setEnabled(false);
        comboTipoMembresia.setVisible(false);
        comboTiempo.setVisible(false);
        lblTipoMembresia.setVisible(true);
        lblTiempoMembresia.setVisible(true);
        comboTipoPago.setVisible(false);
        String numero = campoNumero.getText().trim(); // Eliminar espacios en blanco
        if (!numero.isEmpty()) { // Verificar si el campo no está vacío
            try {
                ArrayList<MiembroBusqueda> listaMiembros = base.obtenerMiembroBusqueda(numero);
            
                if (listaMiembros.isEmpty()) { // Verificar si la lista está vacía
                    JOptionPane.showMessageDialog(this, "No se encontraron miembros con el número proporcionado.");
                } else {
                    MiembroBusqueda miembro = listaMiembros.get(0);
                    Boolean estadomiembro = miembro.getEstadoMiembro();
                    lblNombre.setText(miembro.getNombre() + " " + miembro.getApellidoPaterno() + " " + miembro.getApellidoMaterno());
                    lblExpiracion.setText(miembro.getFechaFinMembresia());
                    lblInicio.setText(miembro.getFechaInicioMembresia());
                    
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

                    // Fecha del sistema
                    String fechaSistema = formatoFecha.format(new Date());

                    // Fecha a comparar
                    String fechaUsuario = miembro.getFechaFinMembresia();
                    
                    // Convertir las fechas a objetos Date
                    Date fecha1 = formatoFecha.parse(fechaSistema);
                    Date fecha2 = formatoFecha.parse(fechaUsuario);

                    // Comparar fechas
                    if (fecha1.compareTo(fecha2) < 0) {
                        estadomiembro = true;
                    } else if(fecha1.compareTo(fecha2) > 0) {
                        estadomiembro = false;
                    }
 
                    if(estadomiembro){
                        lblTipoMembresia.setText(miembro.getTipoMembresia());
                        lblTiempoMembresia.setText(miembro.getTiempoMembresia());
                        lblEstado.setText("Activa");
                        lblEstado.setOpaque(true);
                        lblEstado.setForeground(Color.BLACK);
                        lblEstado.setBackground(Color.GREEN);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Membresia Inactiva.");
                        lblEstado.setText("Inactiva");
                        lblEstado.setOpaque(true);
                        lblEstado.setForeground(Color.WHITE);
                        lblEstado.setBackground(Color.RED);
                        btnPagar.setEnabled(true);
                        comboTipoMembresia.setVisible(true);
                        comboTiempo.setVisible(true);
                        lblTipoMembresia.setVisible(false);
                        lblTiempoMembresia.setVisible(false);
                        comboTipoPago.setVisible(true);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al buscar el miembro: " + e.getMessage());
        }
        } else {
            JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTiempoActionPerformed
        int mesesSeleccionados = comboTiempo.getSelectedIndex();
        
        switch (mesesSeleccionados) {
            case 1:
                fechaTermino.setText(fechaTermino(1));
                
                break;
            case 2:
                fechaTermino.setText(fechaTermino(2));
                break;
            case 3:
                fechaTermino.setText(fechaTermino(3));
                break;
            case 4:
                fechaTermino.setText(fechaTermino(4));
                break;
            case 5:
                fechaTermino.setText(fechaTermino(5));
                break;
            case 6:
                fechaTermino.setText(fechaTermino(6));
                break;
            case 7:
                fechaTermino.setText(fechaTermino(7));
                break;
            case 8:
                fechaTermino.setText(fechaTermino(8));
                break;
            case 9:
                fechaTermino.setText(fechaTermino(9));
                break;
            case 10:
                fechaTermino.setText(fechaTermino(10));
                break;
            case 11:
                fechaTermino.setText(fechaTermino(11));
                break;
            case 12:
                fechaTermino.setText(fechaTermino(12));
                break;
            default:
                fechaTermino.setText("DD/MM/YYYY");
                break;
        }
        
        cargarPrecio();
    }//GEN-LAST:event_comboTiempoActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        String tiempoSeleccionado = comboTiempo.getSelectedItem().toString();
        String tipoPago = comboTipoPago.getSelectedItem().toString();
        if((tiempoSeleccionado != "- - - - - - - - - - - -") && (tipoPago != "- - - - - - - - - - - -")) {
            String telefono = campoNumero.getText();
            TiposMembresia tipoMembresia = (TiposMembresia)comboTipoMembresia.getSelectedItem();
            
            //Actualizamos la membresia
            String nombre = lblNombre.getText();
            String tiempoMembresia = comboTiempo.getSelectedItem().toString();
            String fechaInicio = fechaSis.getText();
            String fechaFin = fechaTermino.getText();
            String tipoMem = tipoMembresia.getNombreMembresia();
            
            base.actualizarMembresia(telefono, tipoMem, tiempoMembresia, fechaInicio, fechaFin);
            
            //Insertamos un nuevo pago en la Base de Datos
            String metodoPago = comboTipoPago.getSelectedItem().toString();
            
            String totalString = lblTotal.getText();
            String precioSinSimbolo = totalString.replace("$", ""); // Quita el símbolo de pesos
            double total = Double.parseDouble(precioSinSimbolo); // Convierte a double
            
            Pagos pago = new Pagos(0, telefono, total, fechaInicio, metodoPago, true);
            
            base.insertarPagos(pago);
            JOptionPane.showMessageDialog(this, "Datos Actualizados Correctamente");
            
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No has seleccionado el tiempo o el metodo de pago de la Membresia");
        }
        
    }//GEN-LAST:event_btnPagarActionPerformed

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
            java.util.logging.Logger.getLogger(PagosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PagosFrame dialog = new PagosFrame(new javax.swing.JFrame(), true);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JComboBox<String> comboTiempo;
    private javax.swing.JComboBox<TiposMembresia> comboTipoMembresia;
    private javax.swing.JComboBox<String> comboTipoPago;
    private javax.swing.JLabel fechaSis;
    private javax.swing.JLabel fechaTermino;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblExpiracion;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTiempoMembresia;
    private javax.swing.JLabel lblTipoMembresia;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
