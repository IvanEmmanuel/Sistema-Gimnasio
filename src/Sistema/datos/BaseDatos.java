package Sistema.datos;

import Sistema.pojos.Membresias;
import Sistema.pojos.Miembros;
import Sistema.pojos.Pagos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
    
    public void insertarMiembro(Miembros miembro){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            //FileImputStream fis = new FileImputStream(miembro.getFotoMiembro());
            
            String sql = "INSERT INTO miembros (id_miembro, nombre_miembro, apellido_paterno_miembro, "
                    + "apellido_materno_miembro, email_miembro, telefono_miembro, direccion_miembro, "
                    + "nacimiento_miembro, foto_miembro, fecha_inicio_miembro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            st = conn.prepareStatement(sql);
            st.setInt(1, miembro.getIdMiembro());
            st.setString(2, miembro.getNombre());
            st.setString(3, miembro.getApellidoPaterno());
            st.setString(4, miembro.getEmail());
            st.setString(5, miembro.getTelefono());
            st.setString(6, miembro.getDireccion());
            st.setString(7, miembro.getFechaNacimiento());
            st.setString(8, miembro.getFechaInicio());
            //st.setBinaryStream(9, fis, (int)miembro.getFotoMiembro().length());
            st.setString(10, miembro.getApellidoMaterno());
            
            
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
    
    public void insertarMembresia(Membresias membresia){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            //FileImputStream fis = new FileImputStream(miembro.getFotoMiembro());
            
            String sql = "INSERT INTO membresias (id_membresia, id_miembro, tipo_membresia, "
                    + "fecha_inicio_membresia, fecha_fin_membresia, estado_membresia"
                    + ") VALUES (?, ?, ?, ?, ?, ?)";
            
            st = conn.prepareStatement(sql);
            st.setInt(1, membresia.getIdMembresia());
            st.setInt(2, membresia.getIdMiembro());
            st.setString(3, membresia.getTipoMembresia());
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
    
    public void insertarPagos(Pagos pago){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            //FileImputStream fis = new FileImputStream(miembro.getFotoMiembro());
            
            String sql = "INSERT INTO membresias (id_pago, id_membresia, monto, "
                    + "fecha_pago, metodo_pago"
                    + ") VALUES (?, ?, ?, ?, ?)";
            
        st = conn.prepareStatement(sql);
        st.setInt(1, pago.getIdPago());
        st.setInt(2, pago.getIdMembresia());
        st.setDouble(3, pago.getMonto());
        st.setString(4, pago.getFechaPago());
        st.setString(5, pago.getMetodoPago());
            
            
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
    
    public void obtenerMiembro(){
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        //FileImputStream fis = new FileImputStream(miembro.getFotoMiembro());
            
        String sql = "SELECT * FROM miembros";
        
        st = conn.prepareStatement(sql);
        
        rs = st.executeQuery();
        
        //id_miembro, nombre_miembro, apellido_paterno_miembro, "+ "apellido_materno_miembro, email_miembro, telefono_miembro, direccion_miembro, "+ "nacimiento_miembro, foto_miembro, fecha_inicio_miembro
        
        while(rs.next()){
            int id = rs.getInt("id_miembro");
            String nombre = rs.getString("nombre_miembro");
            String apePaterno = rs.getString("apellido_paterno_miembro");
            String apeMaterno = rs.getString("apellido_materno_miembro");
            String email = rs.getString("nombre_miembro");
            String telefonoMiembro = rs.getString("nombre_miembro");
            String direccionMiembro = rs.getString("nombre_miembro");
            String nacimientoMiembro = rs.getString("nombre_miembro");
            String foto = rs.getString("foto_miembro");
            String fechaInicio = rs.getString("fecha_inicio_miembro");
            
            
            Miembros miembro = new Miembros(id, nombre, apePaterno, apeMaterno, email, telefonoMiembro, direccionMiembro, nacimientoMiembro, fechaInicio, null);
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