package Sistema.pojos;

import java.io.File;

/**
 *
 * @author IVAN
 */
public class Miembros {
    private String telefonoMiembro;
    private String email;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String fechaNacimiento;
    private String fechaInicio;
    private File fotoMiembro;
    private Boolean estadoMiembro;

    public Miembros(String telefonoMiembro, String email, String nombre, 
            String apellidoPaterno, String apellidoMaterno, 
            String direccion, String fechaNacimiento, String fechaInicio, 
            File fotoMiembro, Boolean estadoMiembro) {
        this.telefonoMiembro = telefonoMiembro;
        this.email = email;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInicio = fechaInicio;
        this.fotoMiembro = fotoMiembro;
        this.estadoMiembro = estadoMiembro;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public File getFotoMiembro() {
        return fotoMiembro;
    }

    public void setFotoMiembro(File fotoMiembro) {
        this.fotoMiembro = fotoMiembro;
    }

    public Boolean getEstadoMiembro() {
        return estadoMiembro;
    }

    public void setEstadoMiembro(Boolean estadoMiembro) {
        this.estadoMiembro = estadoMiembro;
    }
    
    
    @Override
    public String toString(){
        return this.telefonoMiembro;
    }
    
    
}
