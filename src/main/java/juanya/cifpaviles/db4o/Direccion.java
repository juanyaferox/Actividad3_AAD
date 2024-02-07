package juanya.cifpaviles.db4o;

public class Direccion {
    private int pkid;
    private String direccion;
    private String localidad;

    public Direccion() {
    }

    public Direccion(int pkid, String direccion, String localidad) {
        this.pkid = pkid;
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
