package juanya.cifpaviles.db4o;

import juanya.cifpaviles.d_objectdb.EnvioACasa;

//posible modifiacion: añadir idEnvioACasa as nullable
public class Servicio {
    private int pkid;
    private String nombre;
    private double precio;
    private int tparadaPkid;

    public Servicio() {
    }

    public Servicio(int pkid, String nombre, double precio, int tparadaPkid) {
        this.pkid = pkid;
        this.nombre = nombre;
        this.precio = precio;
        this.tparadaPkid = tparadaPkid;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTparadaPkid() {
        return tparadaPkid;
    }

    public void setTparadaPkid(int tparadaPkid) {
        this.tparadaPkid = tparadaPkid;
    }

}
