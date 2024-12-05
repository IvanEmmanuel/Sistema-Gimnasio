package Sistema.pojos;

/**
 *
 * @author IVAN
 */
public class Membresias {
    
    private int idMembresia;
    private String telefonoMiembro;
    private String tipoMembresia;
    private String tiempoMembresia;
    private String fechaInicioMembresia;
    private String fechaFinMembresia;
    private Boolean estadoMembresia;

    public Membresias(int idMembresia, String telefonoMiembro, String tipoMembresia, String tiempoMembresia, String fechaInicioMembresia, String fechaFinMembresia, Boolean estadoMembresia) {
        this.idMembresia = idMembresia;
        this.telefonoMiembro = telefonoMiembro;
        this.tipoMembresia = tipoMembresia;
        this.tiempoMembresia = tiempoMembresia;
        this.fechaInicioMembresia = fechaInicioMembresia;
        this.fechaFinMembresia = fechaFinMembresia;
        this.estadoMembresia = estadoMembresia;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public String getTelefonoMiembro() {
        return telefonoMiembro;
    }

    public void setTelefonoMiembro(String telefonoMiembro) {
        this.telefonoMiembro = telefonoMiembro;
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

    
}
