package juanya.cifpaviles.d_objectdb;

import com.objectdb.o.INT;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import juanya.cifpaviles.model.Tparada;

import java.util.List;

@Entity
public class EnvioACasa {
    @Id
    private int pkid;
    private double peso;
    private List<Integer> dimensiones;
    private boolean urgente;
    @ManyToOne
    private Tparada tparada;
    @ManyToOne
    private Direccion direccion;

    public EnvioACasa() {
    }

    public EnvioACasa(int pkid, double peso, List<Integer> dimensiones, boolean urgente, Tparada tparada, Direccion direccion) {
        this.pkid = pkid;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.urgente = urgente;
        this.tparada = tparada;
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

    public List<Integer> getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(List<Integer> dimensiones) {
        this.dimensiones = dimensiones;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public Tparada getTparada() {
        return tparada;
    }

    public void setTparada(Tparada tparada) {
        this.tparada = tparada;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}