package juanya.cifpaviles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tparada")
public class Tparada {
    @Id
    @Column(name = "pkid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cnombre", nullable = false)
    private String cnombre;

    @Column(name = "cregion", nullable = false, length = 1)
    private Character cregion;

    public Tparada() {
    }

    public Tparada(String cnombre, Character cregion) {
        this.cnombre = cnombre;
        this.cregion = cregion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public Character getCregion() {
        return cregion;
    }

    public void setCregion(Character cregion) {
        this.cregion = cregion;
    }

    @Override
    public String toString() {
        return "Tparada{" +
                "id=" + id +
                ", cnombre='" + cnombre + '\'' +
                ", cregion=" + cregion +
                '}';
    }
}