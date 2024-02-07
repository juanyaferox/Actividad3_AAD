package juanya.cifpaviles.etc.dto;

import juanya.cifpaviles.model.Tparada;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.Tcarnet}
 */
public class TcarnetDto implements Serializable {
    private final Integer id;
    private final Tparada fkidParada;
    private final LocalDate fechaexp;
    private final Integer nvips;
    private final Double distancia;

    public TcarnetDto(Integer id, Tparada fkidParada, LocalDate fechaexp, Integer nvips, Double distancia) {
        this.id = id;
        this.fkidParada = fkidParada;
        this.fechaexp = fechaexp;
        this.nvips = nvips;
        this.distancia = distancia;
    }

    public Integer getId() {
        return id;
    }

    public Tparada getFkidParada() {
        return fkidParada;
    }

    public LocalDate getFechaexp() {
        return fechaexp;
    }

    public Integer getNvips() {
        return nvips;
    }

    public Double getDistancia() {
        return distancia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TcarnetDto entity = (TcarnetDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fkidParada, entity.fkidParada) &&
                Objects.equals(this.fechaexp, entity.fechaexp) &&
                Objects.equals(this.nvips, entity.nvips) &&
                Objects.equals(this.distancia, entity.distancia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkidParada, fechaexp, nvips, distancia);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fkidParada = " + fkidParada + ", " +
                "fechaexp = " + fechaexp + ", " +
                "nvips = " + nvips + ", " +
                "distancia = " + distancia + ")";
    }
}