package juanya.cifpaviles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TperegrinoParadaId implements Serializable {
    private static final long serialVersionUID = 6129697821253778539L;
    @Column(name = "pkfkid_parada", nullable = false)
    private Integer pkfkidParada;

    @Column(name = "pkfkid_peregrino", nullable = false)
    private Integer pkfkidPeregrino;

    public TperegrinoParadaId() {
    }

    public TperegrinoParadaId(Integer pkfkidParada, Integer pkfkidPeregrino) {
        this.pkfkidParada = pkfkidParada;
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

    public Integer getPkfkidParada() {
        return pkfkidParada;
    }

    public void setPkfkidParada(Integer pkfkidParada) {
        this.pkfkidParada = pkfkidParada;
    }

    public Integer getPkfkidPeregrino() {
        return pkfkidPeregrino;
    }

    public void setPkfkidPeregrino(Integer pkfkidPeregrino) {
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TperegrinoParadaId entity = (TperegrinoParadaId) o;
        return Objects.equals(this.pkfkidPeregrino, entity.pkfkidPeregrino) &&
                Objects.equals(this.pkfkidParada, entity.pkfkidParada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkfkidPeregrino, pkfkidParada);
    }

}