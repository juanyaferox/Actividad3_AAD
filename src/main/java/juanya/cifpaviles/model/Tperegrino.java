package juanya.cifpaviles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tperegrino")
public class Tperegrino {
    @Id
    @Column(name = "pkfkid", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pkfkid", nullable = false)
    private Tcarnet tcarnet;

    @Column(name = "cnombre", nullable = false)
    private String cnombre;

    @Column(name = "cnacionalidad", nullable = false)
    private String cnacionalidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tcarnet getTcarnet() {
        return tcarnet;
    }

    public void setTcarnet(Tcarnet tcarnet) {
        this.tcarnet = tcarnet;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCnacionalidad() {
        return cnacionalidad;
    }

    public void setCnacionalidad(String cnacionalidad) {
        this.cnacionalidad = cnacionalidad;
    }

}