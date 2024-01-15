package juanya.cifpaviles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tparada")
public class Tparada {
    @Id
    @Column(name = "pkid", nullable = false)
    private Integer id;

    @Column(name = "cnombre", nullable = false)
    private String cnombre;

    @Column(name = "cregion", nullable = false)
    private Character cregion;

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

}