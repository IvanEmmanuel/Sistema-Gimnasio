package Sistema.pojos;

/**
 *
 * @author IVAN
 */
public class Membresias {
    
    private int idMembresia;
    private int idMiembro;
    private String tipoMembresia;
    private String fechaInicioMembresia;
    private String fechaFinMembresia;
    private String estadoMembresia;

    public Membresias(int idMembresia, int idMiembro, String tipoMembresia, String fechaInicioMembresia, String fechaFinMembresia, String estadoMembresia) {
        this.idMembresia = idMembresia;
        this.idMiembro = idMiembro;
        this.tipoMembresia = tipoMembresia;
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

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
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

    public String getEstadoMembresia() {
        return estadoMembresia;
    }

    public void setEstadoMembresia(String estadoMembresia) {
        this.estadoMembresia = estadoMembresia;
    }
    
}
