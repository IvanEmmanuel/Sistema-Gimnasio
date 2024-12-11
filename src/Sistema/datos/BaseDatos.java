package Sistema.datos;

import Sistema.pojos.Membresias;
import Sistema.pojos.MiembroBusqueda;
import Sistema.pojos.Miembros;
import Sistema.pojos.Pagos;
import Sistema.pojos.Personal;
import Sistema.pojos.Roles;
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
    
    public void insertarPersonal(Personal personal) throws FileNotFoundException{
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            File fileFoto = personal.getFoto();
            FileInputStream fis = new FileInputStream(fileFoto);
            
            String sql = "INSERT INTO personal (nombre, apellido_paterno, "
                    + "apellido_materno, telefono, correo, direccion, puesto, "
                    + "salario, fecha_contratacion, estado, genero, horario, foto, dias_descanso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, personal.getNombre());
            prepSt.setString(2, personal.getApellidoPaterno());
            prepSt.setString(3, personal.getApellidoMaterno());
            prepSt.setString(4, personal.getTelefono());
            prepSt.setString(5, personal.getCorreo());
            prepSt.setString(6, personal.getDireccion());
            prepSt.setString(7, personal.getPuesto());
            prepSt.setString(8, personal.getSalario());
            prepSt.setString(9, personal.getFechaContratacion());
            prepSt.setBoolean(10, personal.getEstado());
            prepSt.setString(11, personal.getGenero());
            prepSt.setString(12, personal.getHorario());
            long tamanoFoto = fileFoto.length();
            prepSt.setBinaryStream(13, fis, tamanoFoto);
            prepSt.setString(14, personal.getDias());
            
            
            
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
    
    public void actualizarPersonal(Personal persona){
      
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "UPDATE personal SET "
           + "telefono = ?, "
           + "correo = ?, "
           + "nombre = ?, "
           + "apellido_paterno = ?, "
           + "apellido_materno = ?, "
           + "direccion = ?, "
           + "puesto = ?, "
           + "salario = ?, "
           + "estado = ?, "
           + "genero = ?, "
           + "horario = ?, "
           + "dias_descanso = ? "
           + "WHERE telefono = ?";
            
           prepSt = conn.prepareStatement(sql);
           prepSt.setString(1, persona.getTelefono());
           prepSt.setString(2, persona.getCorreo());
           prepSt.setString(3, persona.getNombre());
           prepSt.setString(4, persona.getApellidoPaterno());
           prepSt.setString(5, persona.getApellidoMaterno());
           prepSt.setString(6, persona.getDireccion());
           prepSt.setString(7, persona.getPuesto());
           prepSt.setString(8, persona.getSalario());
           prepSt.setBoolean(9, persona.getEstado());
           prepSt.setString(10, persona.getGenero());
           prepSt.setString(11, persona.getHorario());
           prepSt.setString(12, persona.getDias());
           prepSt.setString(13, persona.getTelefono());
            
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
    
    public void insertarTipoMmebresia(String nombre){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO tipos_membresia (nombre_membresia, estado) "
                    + "VALUES (?, ?)";
            
        prepSt = conn.prepareStatement(sql);
        prepSt.setString(1, nombre);
        prepSt.setInt(2, 1);
            
            
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
    
    public void insertarPuesto(String nombre){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO puestos (nombre_puesto, estado) "
                    + "VALUES (?, ?)";
            
        prepSt = conn.prepareStatement(sql);
        prepSt.setString(1, nombre);
        prepSt.setInt(2, 1);
            
            
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
    
    public void insertarCategoria(String categoria){
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "INSERT INTO categoria_equipos (nombre, estado) "
                    + "VALUES (?, ?)";
            
        prepSt = conn.prepareStatement(sql);
        prepSt.setString(1, categoria);
        prepSt.setBoolean(2, true);
            
            
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
    
    
    public ArrayList<Pagos> obtenerPagos(String criterio){
        ArrayList<Pagos> listaBusqueda = new ArrayList<Pagos>();
        
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");

            String sql = "SELECT * "
                        + "FROM pagos "
                        + "WHERE telefono_miembro LIKE '%" + criterio + "%' "
                        + "ORDER BY id_pago DESC;";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id_pago");
                String telefono = rs.getString("telefono_miembro");
                double monto = rs.getDouble("monto");
                String fecha = rs.getString("fecha_pago");
                String metodo = rs.getString("metodo_pago");
                
                Pagos pago = new Pagos(id, telefono, monto, fecha, metodo, true);
                listaBusqueda.add(pago);
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
    
    public ArrayList<Roles> obtenerRoles(){
        
        ArrayList<Roles> listaRoles = new ArrayList<Roles>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM puestos";
        
        prepSt = conn.prepareStatement(sql);
        
        rs = prepSt.executeQuery();
                
        while(rs.next()){
            int idPuesto = rs.getInt("id_puesto");
            String nombrePuesto = rs.getString("nombre_puesto");
            int estado = rs.getInt("estado");
            
            
            Roles rol = new Roles(idPuesto, nombrePuesto, estado);
            listaRoles.add(rol);
            
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
        
        return listaRoles;
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
    
    public ArrayList<Personal > obtenerPersonal(){
        
        ArrayList<Personal> listaPrsonal = new ArrayList<Personal>();
        try {
            
        /*Instanciamos el objeto de la clase conexion*/
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
        String sql = "SELECT * FROM personal";
        
        prepSt = conn.prepareStatement(sql);
        
        rs = prepSt.executeQuery();
                
        while(rs.next()){
            int idPersonal = rs.getInt("id_personal");
            String nombre = rs.getString("nombre");
            String apellidoPaterno = rs.getString("apellido_paterno");
            String apellidoMaterno = rs.getString("apellido_materno");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");
            String direccion = rs.getString("direccion");
            String puesto = rs.getString("puesto");
            String salario = rs.getString("salario");
            String fechaContratacion = rs.getString("fecha_contratacion");
            Boolean estado = rs.getBoolean("estado");
            String genero = rs.getString("genero");
            String horario = rs.getString("horario");
            String descanso = rs.getString("dias_descanso");
            //byte[] foto = rs.getBytes("foto");
                        
            Personal personal = new Personal(nombre, apellidoPaterno, apellidoMaterno, telefono, correo, direccion, puesto, salario, fechaContratacion, estado, genero, horario, null, descanso);
            listaPrsonal.add(personal);
            
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
        
        return listaPrsonal;
    }
    
    public ArrayList<Personal> obtenerPersonal(String criterio){
        ArrayList<Personal> listaBusqueda = new ArrayList<Personal>();
        
        try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");

            String sql = "SELECT * "
                        + "FROM personal "
                        + "WHERE telefono LIKE '%" + criterio + "%' OR nombre LIKE '%" + criterio + "%'"
                        + "ORDER BY id_personal DESC;";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String puesto = rs.getString("puesto");
                String salario = rs.getString("salario");
                String fecha = rs.getString("fecha_contratacion");
                Boolean estado = rs.getBoolean("estado");
                String genero = rs.getString("genero");
                String horario = rs.getString("horario");
                String diasDescanso = rs.getString("dias_descanso");
                
                Personal persona = new Personal(nombre, apellidoPaterno, apellidoMaterno, telefono, correo, direccion, puesto, salario, fecha, estado, genero, horario, null, diasDescanso);
                listaBusqueda.add(persona);
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
    
    public void borarPersonal(Personal persona){
    try {
            
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "UPDATE personal SET estado = ? WHERE telefono=?";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setBoolean(1, false);
            prepSt.setString(2,persona.getTelefono());
            
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
    
    public InputStream buscarFotoPersonal(Personal persona){
        InputStream streamFoto = null;
        
        try{
            /*Instanciamos el objeto de la clase conexion*/
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema-gimnasio", "postgres", "Blueteam");
            
            String sql = "SELECT foto from personal WHERE telefono = ?";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, persona.getTelefono());
            
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                streamFoto = rs.getBinaryStream("foto");
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

