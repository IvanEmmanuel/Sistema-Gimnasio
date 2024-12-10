package Sistema.pojos;

/**
 *
 * @author IVAN
 */
public class Roles {
    
    private int idPuesto;
    private String nombrePuesto;
    private int estado;

    public Roles(int idPuesto, String nombrePuesto, int estado) {
        this.idPuesto = idPuesto;
        this.nombrePuesto = nombrePuesto;
        this.estado = estado;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return this.nombrePuesto;
    } 
    
}
