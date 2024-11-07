package Sistema.pojos;

/**
 *
 * @author IVAN
 */
public class Pagos {
    
    private int idPago;
    private int idMembresia;
    private double monto;
    private String fechaPago;
    private String metodoPago;

    public Pagos(int idPago, int idMembresia, double monto, String fechaPago, String metodoPago) {
        this.idPago = idPago;
        this.idMembresia = idMembresia;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
    
}
