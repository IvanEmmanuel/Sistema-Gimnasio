package Sistema.pojos;

import java.io.File;

/**
 *
 * @author IVAN
 */
public class Miembros {
    private int idMiembro;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String fechaInicio;
    private File fotoMiembro;

    public Miembros(int idMiembro, String nombre, String apellidoPaterno, String apellidoMaterno, 
            String email, String telefono, String direccion, 
            String fechaNacimiento, String fechaInicio, File fotoMiembro) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInicio = fechaInicio;
        this.fotoMiembro = fotoMiembro;
    }

    public File getFotoMiembro() {
        return fotoMiembro;
    }

    public void setFotoMiembro(File fotoMiembro) {
        this.fotoMiembro = fotoMiembro;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
    
    @Override
    public String toString(){
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
    
    
}
