package juanya.cifpaviles.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tcarnet")
public class Tcarnet {
    @Id
    @Column(name = "pkid",  nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkid_parada", nullable = false)
    private Tparada fkidParada;

    @Column(name = "fechaexp", nullable = false)
    private LocalDate fechaexp;

    @Column(name = "nvips", nullable = false, columnDefinition = "int default 0")
    private Integer nvips;

    @Column(name = "distancia", nullable = false, columnDefinition = "double default 0.0")
    private Double distancia;

    public Tcarnet() {
    }

    public Tcarnet(Tparada fkidParada, LocalDate fechaexp, Integer nvips, Double distancia) {
        this.fkidParada = fkidParada;
        this.fechaexp = fechaexp;
        this.nvips = nvips;
        this.distancia = distancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tparada getFkidParada() {
        return fkidParada;
    }

    public void setFkidParada(Tparada fkidParada) {
        this.fkidParada = fkidParada;
    }

    public LocalDate getFechaexp() {
        return fechaexp;
    }

    public void setFechaexp(LocalDate fechaexp) {
        this.fechaexp = fechaexp;
    }

    public Integer getNvips() {
        return nvips;
    }

    public void setNvips(Integer nvips) {
        this.nvips = nvips;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

}