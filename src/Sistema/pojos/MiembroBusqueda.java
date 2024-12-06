package Sistema.pojos;

import java.io.File;

/**
 *
 * @author IVAN
 */
public class MiembroBusqueda {
    private String telefonoMiembro;
    private String email;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private File fotoMiembro;
    private String tipoMembresia;
    private String tiempoMembresia;
    private String fechaInicioMembresia;
    private String fechaFinMembresia;
    private Boolean estadoMembresia;
    private Boolean estadoMiembro;
    private String fechaNacimiento;

    public MiembroBusqueda(String telefonoMiembro, String email, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String direccion, File fotoMiembro, String tipoMembresia, String tiempoMembresia, String fechaInicioMembresia,  
            String fechaFinMembresia, Boolean estadoMembresia, Boolean estadoMiembro, String fechaNacimiento) {
        this.telefonoMiembro = telefonoMiembro;
        this.email = email;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.fotoMiembro = fotoMiembro;
        this.tipoMembresia = tipoMembresia;
        this.tiempoMembresia = tiempoMembresia;
        this.fechaInicioMembresia = fechaInicioMembresia;
        this.fechaFinMembresia = fechaFinMembresia;
        this.estadoMembresia = estadoMembresia;
        this.estadoMiembro = estadoMiembro;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoMiembro() {
        return telefonoMiembro;
    }

    public void setTelefonoMiembro(String telefonoMiembro) {
        this.telefonoMiembro = telefonoMiembro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public File getFotoMiembro() {
        return fotoMiembro;
    }

    public void setFotoMiembro(File fotoMiembro) {
        this.fotoMiembro = fotoMiembro;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public String getTiempoMembresia() {
        return tiempoMembresia;
    }

    public void setTiempoMembresia(String tiempoMembresia) {
        this.tiempoMembresia = tiempoMembresia;
    }
    
    public String getFechaInicioMembresia() {
        return fechaInicioMembresia;
    }

    public void setFechaInicioMembresia(String fechaInicioMembresia) {
        this.fechaInicioMembresia = fechaInicioMembresia;
    }

    public String getFechaFinMembresia() {
        return fechaFinMembresia;
    }

    public void setFechaFinMembresia(String fechaFinMembresia) {
        this.fechaFinMembresia = fechaFinMembresia;
    }

    public Boolean getEstadoMembresia() {
        return estadoMembresia;
    }

    public void setEstadoMembresia(Boolean estadoMembresia) {
        this.estadoMembresia = estadoMembresia;
    }
    
    public Boolean getEstadoMiembro() {
        return estadoMiembro;
    }

    public void setEstadoMiembro(Boolean estadoMiembro) {
        this.estadoMiembro = estadoMiembro;
    }
    
    public void setfechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getfechaNacimiento() {
        return fechaNacimiento;
    }
    
    @Override
    public String toString(){
        return this.telefonoMiembro;
    }
    
}
