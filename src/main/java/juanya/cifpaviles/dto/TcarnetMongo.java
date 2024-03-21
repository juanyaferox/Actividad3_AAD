package juanya.cifpaviles.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class TcarnetMongo {
    @Id
    private Integer id;
    private Integer fkidParada;
    private LocalDate fechaexp;
    private Integer nvips;
    private Double distancia;

    public TcarnetMongo() {
    }

    public TcarnetMongo(Integer id, Integer fkidParada, LocalDate fechaexp, Integer nvips, Double distancia) {
        this.id = id;
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

    public Integer getFkidParada() {
        return fkidParada;
    }

    public void setFkidParada(Integer fkidParada) {
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