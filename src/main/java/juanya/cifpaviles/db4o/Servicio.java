package juanya.cifpaviles.db4o;

import java.util.List;
import java.util.UUID;

//posible modifiacion: añadir idEnvioACasa as nullable
public class Servicio {
    private String pkid;
    private String nombre;
    private double precio;
    private List<Integer> arrayIdParadas;
    private boolean esEnvio = false;

    public Servicio() {
    }

    public Servicio(String nombre, double precio, List<Integer> arrayIdParadas) {
        this.pkid = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.precio = precio;
        this.arrayIdParadas = arrayIdParadas;
    }
    public Servicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio) {
        this.pkid = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.precio = precio;
        this.arrayIdParadas = arrayIdParadas;
        this.esEnvio = esEnvio;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
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

    public boolean isEsEnvio() {
        return esEnvio;
    }

    public void setEsEnvio(boolean esEnvio) {
        this.esEnvio = esEnvio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(pkid).append("\n");
        sb.append("Nombre: '").append(nombre).append("'\n");
        sb.append("Precio: ").append(precio).append("\n");
        sb.append("ID de paradas asociadas:\n");

        // Agrega cada elemento de la lista en una nueva línea
        for (int idParada : arrayIdParadas) {
            sb.append("- ").append(idParada).append("\n");
        }

        return sb.toString();
    }
}
