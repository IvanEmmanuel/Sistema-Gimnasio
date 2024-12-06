package Sistema.datos;

import Sistema.pojos.Membresias;
import Sistema.pojos.MiembroBusqueda;
import Sistema.pojos.Miembros;
import Sistema.pojos.Pagos;
import Sistema.pojos.TiposMembresia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author IVAN
 */
public class BaseDatos {
    
    Connection conn = null;
    PreparedStatement prepSt = null;
    Statement st = null;
    ResultSet rs = null;
    
    public BaseDatos(){
        try {
            /*Traemos los drivers para hacer la conexion desde postgres*/
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**********      Esta clase nos permite añadir a un nuevo miembro a la base de datos         ***************/
    
    public void insertarMiembro(Miembros miembro) throws FileNotFoundException{
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            File fileFoto = miembro.getFotoMiembro();
            FileInputStream fis = new FileInputStream(fileFoto);
            
            String sql = "INSERT INTO miembros (telefono_miembro, correo_miembro, nombre_miembro, apellido_paterno_miembro, "
                    + "apellido_materno_miembro, direccion_miembro, nacimiento_miembro, fecha_inicio_miembro, foto_miembro, estado_miembro) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, miembro.getTelefonoMiembro());
            prepSt.setString(2, miembro.getEmail());
            prepSt.setString(3, miembro.getNombre());
            prepSt.setString(4, miembro.getApellidoPaterno());
            prepSt.setString(5, miembro.getApellidoMaterno());
            prepSt.setString(6, miembro.getDireccion());
            prepSt.setString(7, miembro.getFechaNacimiento());
            prepSt.setString(8, miembro.getFechaInicio());
            long tamanoFoto = fileFoto.length();
            prepSt.setBinaryStream(9, fis, tamanoFoto);
            prepSt.setBoolean(10, miembro.getEstadoMiembro());
            
            
            
            prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public void actualizarMiembro(Miembros miembro){
      
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "UPDATE miembros SET "
           + "telefono_miembro = ?, "
           + "correo_miembro = ?, "
           + "nombre_miembro = ?, "
           + "apellido_paterno_miembro = ?, "
           + "apellido_materno_miembro = ?, "
           + "direccion_miembro = ?, "
           + "nacimiento_miembro = ? "
           + "WHERE telefono_miembro = ?";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, miembro.getTelefonoMiembro());
            prepSt.setString(2, miembro.getEmail());
            prepSt.setString(3, miembro.getNombre());
            prepSt.setString(4, miembro.getApellidoPaterno());
            prepSt.setString(5, miembro.getApellidoMaterno());
            prepSt.setString(6, miembro.getDireccion());
            prepSt.setString(7, miembro.getFechaNacimiento());
            prepSt.setString(8, miembro.getTelefonoMiembro());
            
            prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    /**********      Esta clase nos permite añadir una nueva membresia a la base de datos         ***************/
    
    public void insertarMembresia(Membresias membresia){
        try {
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO membresias (telefono_miembro, tipo_membresia, tiempo_membresia, "
                    + "fecha_inicio_membresia, fecha_fin_membresia, estado_membresia"
                    + ") VALUES (?, ?, ?, ?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, membresia.getTelefonoMiembro());
            prepSt.setString(2, membresia.getTipoMembresia());
            prepSt.setString(3, membresia.getTiempoMembresia());
            prepSt.setString(4, membresia.getFechaInicioMembresia());
            prepSt.setString(5, membresia.getFechaFinMembresia());
            prepSt.setBoolean(6, membresia.getEstadoMembresia());
            
            
            prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void actualizarMembresia(String telefono, String tipoMembresia, String tiempoMembresia, String fechaInicio, String fechaFin){
        
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "UPDATE membresias SET "
           + "tipo_membresia = ?, "
           + "tiempo_membresia = ?, "
           + "fecha_inicio_membresia = ?, "
           + "fecha_fin_membresia = ? "
           + "WHERE telefono_miembro = ?";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, tipoMembresia);
            prepSt.setString(2, tiempoMembresia);
            prepSt.setString(3, fechaInicio);
            prepSt.setString(4, fechaFin);
            prepSt.setString(5, telefono);
            
            prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**********      Esta clase nos permite añadir un nuevo pago a la base de datos         ***************/
    
    public void insertarPagos(Pagos pago){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO pagos (telefono_miembro, monto, "
                    + "fecha_pago, metodo_pago, estado_pago"
                    + ") VALUES (?, ?, ?, ?, ?)";
            
        prepSt = conn.prepareStatement(sql);
        prepSt.setString(1, pago.getTelefonoMiembro());
        prepSt.setDouble(2, pago.getMonto());
        prepSt.setString(3, pago.getFechaPago());
        prepSt.setString(4, pago.getMetodoPago());
        prepSt.setBoolean(5, pago.getEstadoPago());
            
            
        prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**********      Esta clase nos permite añadir un nuevo tipo de membresia a la base de datos         ***************/
    
    public void insertarTipoMembresia(TiposMembresia tipo){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO tipos_membresia (id_tipo, nombre_membresia, estado) "
                    + "VALUES (?, ?, ?)";
            
        prepSt = conn.prepareStatement(sql);
        prepSt.setInt(1, tipo.getIdTipoMembresia());
        prepSt.setString(2, tipo.getNombreMembresia());
        prepSt.setInt(3, tipo.getEstadoMembresia());
            
            
        prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla membresias         ***************/
    
    public ArrayList<Membresias> obtenerMembresia(){
        
        ArrayList<Membresias> listaMembresias = new ArrayList<Membresias>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM membresias";
        
        prepSt = conn.prepareStatement(sql);
        
        rs = prepSt.executeQuery();
                
        while(rs.next()){
            int idMembresia = rs.getInt("id_membresia");
            String telefonoMiembro = rs.getString("telefono_miembro");
            String tipoMembresia = rs.getString("tipo_membresia");
            String tiempoMembresia = rs.getString("tiempo_membresia");
            String fechaInicio = rs.getString("fecha_inicio_membresia");
            String fechaFin = rs.getString("fecha_fin_membresia");
            Boolean estadoMembresia = rs.getBoolean("estado_membresia");
            
            
            Membresias membresia = new Membresias(idMembresia, telefonoMiembro, tipoMembresia, tiempoMembresia, fechaInicio, fechaFin, estadoMembresia);
            listaMembresias.add(membresia);
            
        }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return listaMembresias;
    }
    
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla pagos         ***************/
    
    public ArrayList<Pagos> obtenerPagos(){
        
        ArrayList<Pagos> listaPagos = new ArrayList<Pagos>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM pagos";
        
        prepSt = conn.prepareStatement(sql);
        
        rs = prepSt.executeQuery();
                
        while(rs.next()){
            int idPago = rs.getInt("id_pago");
            String telefonoMiembro = rs.getString("telefono_miembro");
            double monto = rs.getDouble("monto");
            String fechaPago = rs.getString("fecha_pago");
            String metodoPago = rs.getString("metodo_pago");
            Boolean estadoPago = rs.getBoolean("estado_pago");
            
            
            Pagos pago = new Pagos(idPago, telefonoMiembro, monto, fechaPago, metodoPago, estadoPago);
            listaPagos.add(pago);
            
        }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return listaPagos;
    }
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla tipos membresias        ***************/
    
    public ArrayList<TiposMembresia> obtenerTiposMembresias(){
        
        ArrayList<TiposMembresia> listaTiposMembresias = new ArrayList<TiposMembresia>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM tipos_membresia";
        
        prepSt = conn.prepareStatement(sql);
        
        rs = prepSt.executeQuery();
                
        while(rs.next()){
            int idTiposMembresia = rs.getInt("id_tipo");
            String nombreMembresia = rs.getString("nombre_membresia");
            int estado = rs.getInt("estado");
            
            
            TiposMembresia tipos = new TiposMembresia(idTiposMembresia, nombreMembresia, estado);
            listaTiposMembresias.add(tipos);
            
        }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return listaTiposMembresias;
    }
    
    public ArrayList<MiembroBusqueda> obtenerMiembroBusqueda(String criterio){
        ArrayList<MiembroBusqueda> listaBusqueda = new ArrayList<MiembroBusqueda>();
        
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");

            String sql = "SELECT m.*, mb.* "
                    + "FROM miembros m "
                    + "JOIN membresias mb ON m.telefono_miembro = mb.telefono_miembro "
                    + "WHERE m.telefono_miembro LIKE '%" + criterio + "%' "
                    + "OR m.nombre_miembro LIKE '%" + criterio + "%' OR m.apellido_paterno_miembro LIKE '%" + criterio + "%';";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                String telefonoMiembro = rs.getString("telefono_miembro");
                String emailMiembro = rs.getString("correo_miembro");
                String nombreMiembro = rs.getString("nombre_miembro");
                String apellidoPaternoMiembro = rs.getString("apellido_paterno_miembro");
                String apellidoMaternoMiembro = rs.getString("apellido_materno_miembro");
                String direccionMiembro = rs.getString("direccion_miembro");
                //File fotoMiembroMiembro = rs.getFile("foto_miembro");
                String tipoMembresiaMiembro = rs.getString("tipo_membresia");
                String tiempoMembresia = rs.getString("tiempo_membresia");
                String fechaInicioMembresia = rs.getString("fecha_inicio_membresia");
                String fechaFinMembresiaMiembro = rs.getString("fecha_fin_membresia");
                Boolean estadoMembresiaMiembro = rs.getBoolean("estado_membresia");
                Boolean estadoMiembro = rs.getBoolean("estado_miembro");
                String fechaNacimiento = rs.getString("nacimiento_miembro");
                
                MiembroBusqueda miembro = new MiembroBusqueda(telefonoMiembro, emailMiembro, nombreMiembro, 
                        apellidoPaternoMiembro, apellidoMaternoMiembro, direccionMiembro , null, tipoMembresiaMiembro,
                        tiempoMembresia, fechaInicioMembresia, fechaFinMembresiaMiembro, estadoMembresiaMiembro, estadoMiembro, fechaNacimiento);
                listaBusqueda.add(miembro);
            }
            
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaBusqueda;
    }
    
    
    
    
    
    public ArrayList<MiembroBusqueda> obtenerMiembroBusqueda(){
        ArrayList<MiembroBusqueda> listaBusqueda = new ArrayList<MiembroBusqueda>();
        
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");

            String sql = "SELECT m.*, mb.* "
                    + "FROM miembros m "
                    + "LEFT JOIN membresias mb ON m.telefono_miembro = mb.telefono_miembro order by m.telefono_miembro;";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                String telefonoMiembro = rs.getString("telefono_miembro");
                String emailMiembro = rs.getString("correo_miembro");
                String nombreMiembro = rs.getString("nombre_miembro");
                String apellidoPaternoMiembro = rs.getString("apellido_paterno_miembro");
                String apellidoMaternoMiembro = rs.getString("apellido_materno_miembro");
                String direccionMiembro = rs.getString("direccion_miembro");
                //File fotoMiembroMiembro = rs.getFile("foto_miembro");
                String tipoMembresiaMiembro = rs.getString("tipo_membresia");
                String tiempoMembresia = rs.getString("tiempo_membresia");
                String fechaInicioMembresia = rs.getString("fecha_inicio_membresia");
                String fechaFinMembresiaMiembro = rs.getString("fecha_fin_membresia");
                Boolean estadoMembresiaMiembro = rs.getBoolean("estado_membresia");
                Boolean estadoMiembro = rs.getBoolean("estado_miembro");
                String fechaNacimiento = rs.getString("nacimiento_miembro");
                
                MiembroBusqueda miembro = new MiembroBusqueda(telefonoMiembro, emailMiembro, nombreMiembro, 
                        apellidoPaternoMiembro, apellidoMaternoMiembro, direccionMiembro , null, tipoMembresiaMiembro,
                        tiempoMembresia, fechaInicioMembresia, fechaFinMembresiaMiembro, estadoMembresiaMiembro, estadoMiembro, fechaNacimiento);
                listaBusqueda.add(miembro);
            }
            
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaBusqueda;
    }
    
    public void borarMiembro(MiembroBusqueda miembro){
    try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "UPDATE miembros SET estado_miembro = ? WHERE telefono_miembro=?";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setBoolean(1, false);
            prepSt.setString(2,miembro.getTelefonoMiembro());
            
            prepSt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public InputStream buscarFoto(MiembroBusqueda miembro){
        InputStream streamFoto = null;
        
        try{
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "SELECT foto_miembro from miembros WHERE telefono_miembro = ?";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, miembro.getTelefonoMiembro());
            
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                streamFoto = rs.getBinaryStream("foto_miembro");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return streamFoto;
    }
    
    
    
    
}


/**********      Esta clase nos permite obtener todos los registros de la tabla miembros         ***************/
    /*
    public ArrayList<Miembros> obtenerMiembro(){
        
        ArrayList<Miembros> listaMiembros = new ArrayList<Miembros>();
        try {
            
       
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM miembros";
        
        prepSt = conn.prepareStatement(sql);
        
        rs = prepSt.executeQuery();
        
        
        while(rs.next()){
            String telefono_miembro = rs.getString("telefono_miembro");
            String email = rs.getString("correo_miembro");
            String nombre = rs.getString("nombre_miembro");
            String apePaterno = rs.getString("apellido_paterno_miembro");
            String apeMaterno = rs.getString("apellido_materno_miembro");
            String direccionMiembro = rs.getString("direccion_miembro");
            String nacimientoMiembro = rs.getString("nacimiento_miembro");
            String fechaInicio = rs.getString("fecha_inicio_miembro");
            String foto = rs.getString("foto_miembro");
            Boolean estadoMiembro = rs.getBoolean("estado_miembro");
            
            
            Miembros miembro = new Miembros(telefono_miembro, email, nombre, apePaterno, apeMaterno, direccionMiembro, nacimientoMiembro, fechaInicio, null, estadoMiembro);
            listaMiembros.add(miembro);
            
        }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return listaMiembros;
    }
    
    */

