package juanya.cifpaviles.d_objectdb;

import com.objectdb.o.INT;
import jakarta.persistence.*;
import juanya.cifpaviles.db4o.Servicio;
import juanya.cifpaviles.model.Tparada;

import java.lang.reflect.Array;
import java.util.List;

@Entity
public class EnvioACasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkid;
    private double peso;
    private int[] dimensiones = new int[3];
    private boolean urgente;
    private int paradaid;
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
}
