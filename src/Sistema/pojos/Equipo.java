
package Sistema.pojos;

import java.io.File;


public class Equipo {
    private int idEquipo;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;
    private String condicion;
    private String ubicacion;
    private String fechaCompra;
    private File foto;
    private boolean estado;

    public Equipo(int idEquipo, String nombre, String categoria, int cantidad, double precio, String condicion, String ubicacion, String fechaCompra, File foto, boolean estado) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.condicion = condicion;
        this.ubicacion = ubicacion;
        this.fechaCompra = fechaCompra;
        this.foto = foto;
        this.estado = estado;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return this.nombre;
    } 
    
}
