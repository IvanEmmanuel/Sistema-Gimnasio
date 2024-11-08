package Sistema.pojos;

/**
 *
 * @author IVAN
 */
public class TiposMembresia {
    
    private int idTipoMembresia;
    private String nombreMembresia;
    private int estadoMembresia;

    public TiposMembresia(int idTipoMembresia, String nombreMembresia, int estadoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
        this.nombreMembresia = nombreMembresia;
        this.estadoMembresia = estadoMembresia;
    }

    public int getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(int idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public String getNombreMembresia() {
        return nombreMembresia;
    }

    public void setNombreMembresia(String nombreMembresia) {
        this.nombreMembresia = nombreMembresia;
    }

    public int getEstadoMembresia() {
        return estadoMembresia;
    }

    public void setEstadoMembresia(int estadoMembresia) {
        this.estadoMembresia = estadoMembresia;
    }
    
    
    
    
    
}
