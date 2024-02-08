package juanya.cifpaviles.db4o;

import juanya.cifpaviles.model.Testancia;

import java.util.UUID;

public class ConjuntoContratado {
    private String pkid;
    private double precioTotal;
    private char metodoPago;
    private String extra;
    private int testanciaPkid;

    public ConjuntoContratado() {
    }

    public ConjuntoContratado(double precioTotal, char metodoPago, String extra, int testanciaPkid) {
        this.pkid = UUID.randomUUID().toString();
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.extra = extra;
        this.testanciaPkid = testanciaPkid;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public char getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(char metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getTestanciaPkid() {
        return testanciaPkid;
    }

    public void setTestanciaPkid(int testanciaPkid) {
        this.testanciaPkid = testanciaPkid;
    }
}
