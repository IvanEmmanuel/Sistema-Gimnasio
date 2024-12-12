/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Sistema.gui;

import Sistema.datos.BaseDatos;
import Sistema.pojos.Membresias;
import Sistema.pojos.Miembros;
import Sistema.pojos.Pagos;
import Sistema.pojos.TiposMembresia;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author IVAN
 */
public class NuevoMiembroFrame extends javax.swing.JDialog {
    
    DefaultComboBoxModel <TiposMembresia> tipoMembresias;
    BaseDatos base;

    public NuevoMiembroFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        tipoMembresias = new DefaultComboBoxModel<TiposMembresia>();
        base = new BaseDatos();
        cargarTiposMembresias();
        initComponents();
        lblFechaInicio.setText(fecha());
        String tipoMembresiaSeleccionada = comboTiposMembresias.getSelectedItem().toString();
        lblTipoMembresia.setText(tipoMembresiaSeleccionada);
        cargarPrecioMembresi();
    }

    private void cargarTiposMembresias(){
        ArrayList<TiposMembresia> listaTiposMembresia;
        listaTiposMembresia = base.obtenerTiposMembresias();
        
        for(TiposMembresia tiposMembresias : listaTiposMembresia){
            tipoMembresias.addElement(tiposMembresias);
        }
    }
    
    private void cargarPrecioMembresi(){
        // Obtener la membresía seleccionada en el combo box
        String tipoMembresia = comboTiposMembresias.getSelectedItem().toString();
        String precio = ""; // Variable para almacenar el precio en formato de texto

        // Asignar el precio dependiendo del tipo de membresía seleccionada
        switch (tipoMembresia) {
            case "Membresía Básica":
                precio = "$300 MXN";
                break;
            case "Membresía Estándar":
                precio = "$500 MXN";
                break;
            case "Membresía Premium":
                precio = "$800 MXN";
                break;
            case "Membresía VIP o Platino":
                precio = "$1,200 MXN";
                break;
            case "Membresía de Fin de Semana":
                precio = "$250 MXN";
                break;
            case "Membresía para Adultos Mayores":
                precio = "$300 MXN";
                break;
            case "Membresía Corporativa":
                precio = "$400 MXN";
                break;
            default:
                precio = "No disponible";
                break;
        }

        // Asignar el precio al label
        precioMembresia.setText(precio);
    }
    
    
    private void cargarPrecio() {
    // Obtener el tipo de membresía seleccionado
    String tipoMembresia = comboTiposMembresias.getSelectedItem().toString();
    
    // Obtener el número de meses seleccionado (convirtiendo el texto a un número)
    String tiempoSeleccionado = comboTiempo.getSelectedItem().toString();
    
    if(tiempoSeleccionado != "- - - - - -"){
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
            lblDescuento.setText((descuento * 100) + "%");
            lblTotal.setText("$" + precioConDescuento);
            lblTotalDesc.setText("$" + totalDescuentoPesos); // Asignar el total de descuento en pesos
        } else {
            lblDescuento.setText("0.0%");
            lblTotal.setText("$0.0");
            lblTotalDesc.setText("$0.0");
        }
    
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardarMiembro = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        campoPaterno = new javax.swing.JTextField();
        campoCorreo = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoMaterno = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        comboTiposMembresias = new javax.swing.JComboBox<>();
        comboTiempo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblImagenMiembro = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        comboMes = new javax.swing.JComboBox<>();
        campoAno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblFechaTermino = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        btnInformacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTipoMembresia = new javax.swing.JLabel();
        lblNumeroMeses = new javax.swing.JLabel();
        lblProximoPago = new javax.swing.JLabel();
        comboMetodoPago = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        precioMembresia = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblTotalDesc = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nombre(s):");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Apellido Paterno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Materno:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Correo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Dirección:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tipo de Membresía:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tiempo de la Membresía:");

        btnGuardarMiembro.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardarMiembro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardarMiembro.setForeground(new java.awt.Color(255, 204, 51));
        btnGuardarMiembro.setText("Pagar");
        btnGuardarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMiembroActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 204, 0));
        jLabel12.setText("Total a Pagar:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotal.setText("0.00");

        comboTiposMembresias.setModel(tipoMembresias);
        comboTiposMembresias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTiposMembresiasActionPerformed(evt);
            }
        });

        comboTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - - - - -", "1 mes", "2 meses", "3 meses", "4 meses", "5 meses", "6 meses", "7 meses", "8 meses", "9 meses", "10 meses", "11 meses", "12 meses" }));
        comboTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTiempoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblImagenMiembro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblImagenMiembro.setForeground(new java.awt.Color(255, 255, 255));
        lblImagenMiembro.setText("        Añadir Foto");
        lblImagenMiembro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenMiembroMousePressed(evt);
            }
        });

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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Datos Personales");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Datos de la Membresía");

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " - ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - - - - - -", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Fecha de Inicio:");

        lblFechaInicio.setText("DD/MM/YYYY");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Fecha del Proximo Pago:");

        lblFechaTermino.setText("DD/MM/YYYY");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("Información del Pago");

        btnInformacion.setText("?");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Tipo de Membresia");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Numero de Meses");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Fecha proximo Pago");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Metodo de Pago");

        lblTipoMembresia.setText("...");

        lblNumeroMeses.setText("...");

        comboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - - - - - - - - - - -", "Efectivo", "Tarjeta de Credito", "Tarjeta de Debito", "Transferencia" }));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Precio de la Membresía");

        precioMembresia.setText("...");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Total Descuento");

        lblTotalDesc.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTipoMembresia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(precioMembresia)
                        .addGap(132, 132, 132)
                        .addComponent(lblNumeroMeses)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel23)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel24)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblTotalDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProximoPago)
                        .addGap(102, 102, 102)
                        .addComponent(comboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoMembresia)
                    .addComponent(lblNumeroMeses)
                    .addComponent(lblProximoPago)
                    .addComponent(comboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioMembresia)
                    .addComponent(lblTotalDesc))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 51));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText("YYYY");

        jLabel11.setText("/");

        jLabel16.setText("MM");

        jLabel18.setText("/");

        jLabel29.setText("DD");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Descuento");

        lblDescuento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescuento.setText("0.0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnGuardarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(107, 107, 107)
                .addComponent(lblTotal)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoDireccion)
                                            .addComponent(campoMaterno)
                                            .addComponent(campoNombre)
                                            .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(campoPaterno)
                                            .addComponent(campoTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(23, 23, 23)
                                                        .addComponent(jLabel29)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel16))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel10)
                                                        .addGap(27, 27, 27))
                                                    .addComponent(campoAno)))))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaInicio)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboTiposMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFechaTermino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDescuento)
                                        .addGap(24, 24, 24))))
                            .addComponent(jLabel14))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(campoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(campoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel29))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboTiposMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInformacion)
                    .addComponent(jLabel22))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblFechaInicio)
                    .addComponent(jLabel17)
                    .addComponent(lblFechaTermino)
                    .addComponent(lblDescuento))
                .addGap(43, 43, 43)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblTotal)
                    .addComponent(btnGuardarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton3.getAccessibleContext().setAccessibleName("btnCancelar");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    File imgMiembroFile;
    private void lblImagenMiembroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMiembroMousePressed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, jpeg, o png", "jpg", "jpeg", "png");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            int anchoImagen = lblImagenMiembro.getWidth();
            int altoImagen = lblImagenMiembro.getHeight();
            
            imgMiembroFile = chooser.getSelectedFile();
            ImageIcon icono = new ImageIcon(imgMiembroFile.getAbsolutePath());
            Image imagen = icono.getImage();
            Image imagenRedimensionada = imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);
            
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            
            lblImagenMiembro.setIcon(iconoRedimensionado);
        }
    }//GEN-LAST:event_lblImagenMiembroMousePressed

    private void btnGuardarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMiembroActionPerformed
        String telefono = campoTelefono.getText();
        String correo = campoCorreo.getText();
        String nombre = campoNombre.getText();
        String apellidoPaterno = campoPaterno.getText();
        String apellidoMaterno = campoMaterno.getText();
        String direccion = campoDireccion.getText();
        String fechaNacimiento = comboDia.getSelectedItem() + "/" + comboMes.getSelectedItem() + "/" + campoAno.getText();
        TiposMembresia tipoMembresia = (TiposMembresia)comboTiposMembresias.getSelectedItem();
        String tiempoMembresia = comboTiempo.getSelectedItem().toString();
        String fechaInicio = lblFechaInicio.getText();
        String fechaTermino = lblFechaTermino.getText();
        String metodoPago = comboMetodoPago.getSelectedItem().toString();
        
        String totalString = lblTotal.getText();
        String precioSinSimbolo = totalString.replace("$", ""); // Quita el símbolo de pesos
        double total = Double.parseDouble(precioSinSimbolo); // Convierte a double
        
        String tipoMem = tipoMembresia.getNombreMembresia();
        
        if(imgMiembroFile == null){
            JOptionPane.showMessageDialog(this, "Debes Cargar una Fotografia");
        }
        else if(tiempoMembresia != "- - - - - -" && metodoPago != "- - - - - - - - - - - -"){
            try {
                Miembros miembro = new Miembros(telefono, correo, nombre, apellidoPaterno, apellidoMaterno, direccion, fechaNacimiento, fechaInicio, imgMiembroFile, true);
                Membresias membresia = new Membresias(0, telefono, tipoMem, tiempoMembresia, fechaInicio, fechaTermino, true);
                Pagos pago = new Pagos(0, telefono, total, fechaInicio, metodoPago, true);
                base.insertarMiembro(miembro);
                base.insertarMembresia(membresia);
                base.insertarPagos(pago);
                JOptionPane.showMessageDialog(this, "Datos Guardados Correctamente");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NuevoMiembroFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No has seleccionado todos los campos");
        }
    }//GEN-LAST:event_btnGuardarMiembroActionPerformed

    private void comboTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTiempoActionPerformed
        int mesesSeleccionados = comboTiempo.getSelectedIndex();
        
        switch (mesesSeleccionados) {
            case 1:
                lblFechaTermino.setText(fechaTermino(1));
                lblProximoPago.setText(fechaTermino(1));
                lblNumeroMeses.setText("1");
                break;
            case 2:
                lblFechaTermino.setText(fechaTermino(2));
                lblProximoPago.setText(fechaTermino(2));
                lblNumeroMeses.setText("2");
                break;
            case 3:
                lblFechaTermino.setText(fechaTermino(3));
                lblProximoPago.setText(fechaTermino(3));
                lblNumeroMeses.setText("3");
                break;
            case 4:
                lblFechaTermino.setText(fechaTermino(4));
                lblProximoPago.setText(fechaTermino(4));
                lblNumeroMeses.setText("4");
                break;
            case 5:
                lblFechaTermino.setText(fechaTermino(5));
                lblProximoPago.setText(fechaTermino(5));
                lblNumeroMeses.setText("5");
                break;
            case 6:
                lblFechaTermino.setText(fechaTermino(6));
                lblProximoPago.setText(fechaTermino(6));
                lblNumeroMeses.setText("6");
                break;
            case 7:
                lblFechaTermino.setText(fechaTermino(7));
                lblProximoPago.setText(fechaTermino(7));
                lblNumeroMeses.setText("7");
                break;
            case 8:
                lblFechaTermino.setText(fechaTermino(8));
                lblProximoPago.setText(fechaTermino(8));
                lblNumeroMeses.setText("8");
                break;
            case 9:
                lblFechaTermino.setText(fechaTermino(9));
                lblProximoPago.setText(fechaTermino(9));
                lblNumeroMeses.setText("9");
                break;
            case 10:
                lblFechaTermino.setText(fechaTermino(10));
                lblProximoPago.setText(fechaTermino(10));
                lblNumeroMeses.setText("10");
                break;
            case 11:
                lblFechaTermino.setText(fechaTermino(11));
                lblProximoPago.setText(fechaTermino(11));
                lblNumeroMeses.setText("11");
                break;
            case 12:
                lblFechaTermino.setText(fechaTermino(12));
                lblProximoPago.setText(fechaTermino(12));
                lblNumeroMeses.setText("12");
                break;
            default:
                lblFechaTermino.setText("DD/MM/YYYY");
                lblProximoPago.setText(" ");
                lblNumeroMeses.setText(" ");
                break;
        }
        
        cargarPrecio();
    }//GEN-LAST:event_comboTiempoActionPerformed

    private void comboTiposMembresiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTiposMembresiasActionPerformed
        String tipoMembresiaSeleccionada = comboTiposMembresias.getSelectedItem().toString();
        lblTipoMembresia.setText(tipoMembresiaSeleccionada);
        cargarPrecioMembresi();
    }//GEN-LAST:event_comboTiposMembresiasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        return formato.format(fecha);
    }
    
    public static String fechaTermino(int mesesASumar){
        String fecha = fecha();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicial = LocalDate.parse(fecha, formato);
        
        // Sumar los meses
        LocalDate fechaFinal = fechaInicial.plusMonths(mesesASumar);
        
        // Formatear la fecha final como String
        return fechaFinal.format(formato);
    }
    
    
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
            java.util.logging.Logger.getLogger(NuevoMiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoMiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoMiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoMiembroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoMiembroFrame dialog = new NuevoMiembroFrame(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardarMiembro;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoMaterno;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPaterno;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JComboBox<String> comboMetodoPago;
    private javax.swing.JComboBox<String> comboTiempo;
    private javax.swing.JComboBox<TiposMembresia> comboTiposMembresias;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaTermino;
    private javax.swing.JLabel lblImagenMiembro;
    private javax.swing.JLabel lblNumeroMeses;
    private javax.swing.JLabel lblProximoPago;
    private javax.swing.JLabel lblTipoMembresia;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalDesc;
    private javax.swing.JLabel precioMembresia;
    // End of variables declaration//GEN-END:variables
}
