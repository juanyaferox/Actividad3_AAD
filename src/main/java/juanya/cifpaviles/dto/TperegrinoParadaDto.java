package juanya.cifpaviles.dto;

import juanya.cifpaviles.model.TperegrinoParadaId;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.TperegrinoParada}
 */
public class TperegrinoParadaDto implements Serializable {
    private final TperegrinoParadaId id;
    private final TparadaDto pkfkidParada;
    private final TperegrinoDto pkfkidPeregrino;

    public TperegrinoParadaDto(TperegrinoParadaId id, TparadaDto pkfkidParada, TperegrinoDto pkfkidPeregrino) {
        this.id = id;
        this.pkfkidParada = pkfkidParada;
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

    public TperegrinoParadaId getId() {
        return id;
    }

    public TparadaDto getPkfkidParada() {
        return pkfkidParada;
    }

    public TperegrinoDto getPkfkidPeregrino() {
        return pkfkidPeregrino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TperegrinoParadaDto entity = (TperegrinoParadaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.pkfkidParada, entity.pkfkidParada) &&
                Objects.equals(this.pkfkidPeregrino, entity.pkfkidPeregrino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pkfkidParada, pkfkidPeregrino);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "pkfkidParada = " + pkfkidParada + ", " +
                "pkfkidPeregrino = " + pkfkidPeregrino + ")";
    }
}