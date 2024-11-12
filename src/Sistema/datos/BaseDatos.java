package Sistema.datos;

import Sistema.pojos.Membresias;
import Sistema.pojos.Miembros;
import Sistema.pojos.Pagos;
import Sistema.pojos.TiposMembresia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    PreparedStatement st = null;
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
            
            String sql = "INSERT INTO miembros (nombre_miembro, apellido_paterno_miembro, "
                    + "apellido_materno_miembro, email_miembro, telefono_miembro, direccion_miembro, "
                    + "nacimiento_miembro, foto_miembro, fecha_inicio_miembro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            st = conn.prepareStatement(sql);
            st.setString(1, miembro.getNombre());
            st.setString(2, miembro.getApellidoPaterno());
            st.setString(3, miembro.getApellidoMaterno());
            st.setString(4, miembro.getEmail());
            st.setString(5, miembro.getTelefono());
            st.setString(6, miembro.getDireccion());
            st.setString(7, miembro.getFechaNacimiento());
            long tamanoFoto = fileFoto.length();
            st.setBinaryStream(8, fis, tamanoFoto);
            st.setString(9, miembro.getFechaInicio());
            
            
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
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
    }
    
    
    /**********      Esta clase nos permite añadir una nueva membresia a la base de datos         ***************/
    
    public void insertarMembresia(Membresias membresia){
        try {
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO membresias (id_miembro, tipo_membresia, tiempo_membresia, "
                    + "fecha_inicio_membresia, fecha_fin_membresia, estado_membresia"
                    + ") VALUES (?, ?, ?, ?, ?, ?)";
            
            st = conn.prepareStatement(sql);
            st.setInt(1, membresia.getIdMiembro());
            st.setString(2, membresia.getTipoMembresia());
            st.setString(3, membresia.gettiempoMembresia());
            st.setString(4, membresia.getFechaInicioMembresia());
            st.setString(5, membresia.getFechaFinMembresia());
            st.setString(6, membresia.getEstadoMembresia());
            
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
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
    }
    
    /**********      Esta clase nos permite añadir un nuevo pago a la base de datos         ***************/
    
    public void insertarPagos(Pagos pago){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO pagos (id_membresia, monto, "
                    + "fecha_pago, metodo_pago"
                    + ") VALUES (?, ?, ?, ?)";
            
        st = conn.prepareStatement(sql);
        st.setInt(1, pago.getIdMembresia());
        st.setDouble(2, pago.getMonto());
        st.setString(3, pago.getFechaPago());
        st.setString(4, pago.getMetodoPago());
            
            
        st.executeUpdate();
            
            
        } catch (SQLException ex) {
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
    }
    
    /**********      Esta clase nos permite añadir un nuevo tipo de membresia a la base de datos         ***************/
    
    public void insertarTipoMembresia(TiposMembresia tipo){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO tipos_membresia (id_tipo, nombre_membresia, estado) "
                    + "VALUES (?, ?, ?)";
            
        st = conn.prepareStatement(sql);
        st.setInt(1, tipo.getIdTipoMembresia());
        st.setString(2, tipo.getNombreMembresia());
        st.setInt(3, tipo.getEstadoMembresia());
            
            
        st.executeUpdate();
            
            
        } catch (SQLException ex) {
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
    }
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla miembros         ***************/
    
    public ArrayList<Miembros> obtenerMiembro(){
        
        ArrayList<Miembros> listaMiembros = new ArrayList<Miembros>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM miembros";
        
        st = conn.prepareStatement(sql);
        
        rs = st.executeQuery();
        
        //id_miembro, nombre_miembro, apellido_paterno_miembro, "+ "apellido_materno_miembro, email_miembro, telefono_miembro, direccion_miembro, "+ "nacimiento_miembro, foto_miembro, fecha_inicio_miembro
        
        while(rs.next()){
            int idMiembro = rs.getInt("id_miembro");
            String nombre = rs.getString("nombre_miembro");
            String apePaterno = rs.getString("apellido_paterno_miembro");
            String apeMaterno = rs.getString("apellido_materno_miembro");
            String email = rs.getString("email_miembro");
            String telefonoMiembro = rs.getString("telefono_miembro");
            String direccionMiembro = rs.getString("direccion_miembro");
            String nacimientoMiembro = rs.getString("nacimiento_miembro");
            //String foto = rs.getString("foto_miembro");
            String fechaInicio = rs.getString("fecha_inicio_miembro");
            
            
            Miembros miembro = new Miembros(idMiembro, nombre, apePaterno, apeMaterno, email, telefonoMiembro, direccionMiembro, nacimientoMiembro, fechaInicio, null);
            listaMiembros.add(miembro);
            
        }
            
            
        } catch (SQLException ex) {
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
        
        return listaMiembros;
    }
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla membresias         ***************/
    
    public ArrayList<Membresias> obtenerMembresia(){
        
        ArrayList<Membresias> listaMembresias = new ArrayList<Membresias>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM membresias";
        
        st = conn.prepareStatement(sql);
        
        rs = st.executeQuery();
                
        while(rs.next()){
            int idMembresia = rs.getInt("id_membresia");
            int idMiembro = rs.getInt("id_miembro");
            String tipoMembresia = rs.getString("tipo_membresia");
            String tiempoMembresia = rs.getString("tiempo_membresia");
            String fechaInicio = rs.getString("fecha_inicio_membresia");
            String fechaFin = rs.getString("fecha_fin_membresia");
            String estadoMembresia = rs.getString("estado_membresia");
            
            
            Membresias membresia = new Membresias(idMembresia, idMiembro, tipoMembresia, tiempoMembresia, fechaInicio, fechaFin, estadoMembresia);
            listaMembresias.add(membresia);
            
        }
            
            
        } catch (SQLException ex) {
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
        
        return listaMembresias;
    }
    
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla pagos         ***************/
    
    public ArrayList<Pagos> obtenerPagos(){
        
        ArrayList<Pagos> listaPagos = new ArrayList<Pagos>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM pagos";
        
        st = conn.prepareStatement(sql);
        
        rs = st.executeQuery();
                
        while(rs.next()){
            int idPago = rs.getInt("id_pago");
            int idMembresia = rs.getInt("id_membresia");
            double monto = rs.getDouble("monto");
            String fechaPago = rs.getString("fecha_pago");
            String metodoPago = rs.getString("metodo_pago");
            
            
            Pagos pago = new Pagos(idPago, idMembresia, monto, fechaPago, metodoPago);
            listaPagos.add(pago);
            
        }
            
            
        } catch (SQLException ex) {
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
        
        return listaPagos;
    }
    
    /**********      Esta clase nos permite obtener todos los registros de la tabla tipos membresias        ***************/
    
    public ArrayList<TiposMembresia> obtenerTiposMembresias(){
        
        ArrayList<TiposMembresia> listaTiposMembresias = new ArrayList<TiposMembresia>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM tipos_membresia";
        
        st = conn.prepareStatement(sql);
        
        rs = st.executeQuery();
                
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
                st.close();            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return listaTiposMembresias;
    }
    
    
}


/*Query para traer todos los datos de una BD*/
            
            //rs = st.executeQuery("SELECT * FROM \"miembros\"");
            /*
            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String ape_paterno = rs.getString(3);
                String email = rs.getString(4);
                String tel = rs.getString(5);
                String direc = rs.getString(6);
                String fecha_nac = rs.getString(7);
                String fecha_inicio = rs.getString(8);
                String ape_materno = rs.getString(10);
                
                System.out.println("Id: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido Paterno: " + ape_paterno);
                System.out.println("Apellido Materno: " + ape_materno);
                System.out.println("Email: " + email);
                System.out.println("Telefono: " + tel);
                System.out.println("Direccion: " + direc);
                System.out.println("Fecha de Nacimiento: " + fecha_nac);
                System.out.println("Miembro Desde: " + fecha_inicio);
            }
            */