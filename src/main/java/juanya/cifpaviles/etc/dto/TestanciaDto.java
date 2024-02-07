package juanya.cifpaviles.etc.dto;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.Testancia}
 */
public class TestanciaDto implements Serializable {
    private final Integer id;
    private final Tparada fkidParada;
    private final Tperegrino fkidPeregrino;
    private final LocalDate fecha;
    private final Boolean vip;

    public TestanciaDto(Integer id, Tparada fkidParada, Tperegrino fkidPeregrino, LocalDate fecha, Boolean vip) {
        this.id = id;
        this.fkidParada = fkidParada;
        this.fkidPeregrino = fkidPeregrino;
        this.fecha = fecha;
        this.vip = vip;
    }

    public Integer getId() {
        return id;
    }

    public Tparada getFkidParada() {
        return fkidParada;
    }

    public Tperegrino getFkidPeregrino() {
        return fkidPeregrino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Boolean getVip() {
        return vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestanciaDto entity = (TestanciaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fkidParada, entity.fkidParada) &&
                Objects.equals(this.fkidPeregrino, entity.fkidPeregrino) &&
                Objects.equals(this.fecha, entity.fecha) &&
                Objects.equals(this.vip, entity.vip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkidParada, fkidPeregrino, fecha, vip);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fkidParada = " + fkidParada + ", " +
                "fkidPeregrino = " + fkidPeregrino + ", " +
                "fecha = " + fecha + ", " +
                "vip = " + vip + ")";
    }
}