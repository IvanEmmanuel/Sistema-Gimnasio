package Sistema.pojos;

/**
 *
 * @author IVAN
 */
public class Pagos {
    
    private int idPago;
    private String telefonoMiembro;
    private double monto;
    private String fechaPago;
    private String metodoPago;
    private Boolean estadoPago;

    public Pagos(int idPago, String telefonoMiembro, double monto, String fechaPago, String metodoPago, Boolean estadoPago) {
        this.idPago = idPago;
        this.telefonoMiembro = telefonoMiembro;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getTelefonoMiembro() {
        return telefonoMiembro;
    }

    public void setTelefonoMiembro(String telefonoMiembro) {
        this.telefonoMiembro = telefonoMiembro;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

}
