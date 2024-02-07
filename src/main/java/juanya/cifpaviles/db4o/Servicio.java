package juanya.cifpaviles.db4o;

public class Servicio {
    private int pkid;
    private String nombre;
    private double precio;
    private EnvioACasa envioACasa;

    public Servicio() {
    }

    public Servicio(int pkid, String nombre, double precio, EnvioACasa envioACasa) {
        this.pkid = pkid;
        this.nombre = nombre;
        this.precio = precio;
        this.envioACasa = envioACasa;
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

    public EnvioACasa getEnvioACasa() {
        return envioACasa;
    }

    public void setEnvioACasa(EnvioACasa envioACasa) {
        this.envioACasa = envioACasa;
    }

}
