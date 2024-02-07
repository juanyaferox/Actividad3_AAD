package juanya.cifpaviles.db4o;

import juanya.cifpaviles.d_objectdb.EnvioACasa;

import java.util.List;

//posible modifiacion: añadir idEnvioACasa as nullable
public class Servicio {
    private int pkid;
    private String nombre;
    private double precio;
    private List<Integer> arrayIdParadas;
    private static int lastId = 0;

    public Servicio() {
    }

    public Servicio(String nombre, double precio, List<Integer> arrayIdParadas) {
        this.pkid = ++lastId;
        this.nombre = nombre;
        this.precio = precio;
        this.arrayIdParadas = arrayIdParadas;
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

    public List<Integer> getArrayIdParadas() {
        return arrayIdParadas;
    }

    public void setArrayIdParadas(List<Integer> arrayIdParadas) {
        this.arrayIdParadas = arrayIdParadas;
    }

}
