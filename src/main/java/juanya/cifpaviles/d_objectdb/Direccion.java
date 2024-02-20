package juanya.cifpaviles.d_objectdb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Direccion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int pkid;
    private String direccion;
    private String localidad;

    public Direccion() {
    }

    public Direccion(String direccion, String localidad) {
        this.direccion = direccion;
        this.localidad = localidad;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
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
}