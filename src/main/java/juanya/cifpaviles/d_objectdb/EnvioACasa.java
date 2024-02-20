package juanya.cifpaviles.d_objectdb;

import jakarta.persistence.*;


//El servicio de envio a casa se ha creado con anterioridad, con valor 50 y nombre "Envio a casa"
//Además fue asignado a todas las paradas existentes en el servidor local actualmente (1 a 8)
@Entity
public class EnvioACasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkid;
    private double peso;
    private int[] dimensiones = new int[3];
    private boolean urgente;
    private int paradaid;
    private String idServicio;
    @ManyToOne
    private Direccion direccion;


    public EnvioACasa() {
    }

    public EnvioACasa(double peso, int[] dimensiones, boolean urgente, int paradaid, Direccion direccion) {
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.urgente = urgente;
        this.paradaid = paradaid;
        this.direccion = direccion;
    }

    public EnvioACasa(double peso, int[] dimensiones, boolean urgente, int paradaid, String idServicio, Direccion direccion) {
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.urgente = urgente;
        this.paradaid = paradaid;
        this.idServicio = idServicio;
        this.direccion = direccion;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int[] getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int[] dimensiones) {
        this.dimensiones = dimensiones;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public int getParadaid() {
        return paradaid;
    }

    public void setParadaid(int paradaid) {
        this.paradaid = paradaid;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
}
