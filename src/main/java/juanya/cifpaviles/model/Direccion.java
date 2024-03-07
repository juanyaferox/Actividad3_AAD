package juanya.cifpaviles.model;


import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
    private String direccion;
    private String localidad;

    public Direccion() {
    }

    public Direccion(String direccion, String localidad) {
        this.direccion = direccion;
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return String.format("Dirección: %s\nLocalidad: %s", direccion, localidad);
    }
}