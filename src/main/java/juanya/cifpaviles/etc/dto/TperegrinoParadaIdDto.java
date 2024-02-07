package juanya.cifpaviles.etc.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.TperegrinoParadaId}
 */
public class TperegrinoParadaIdDto implements Serializable {
    private final Integer pkfkidParada;
    private final Integer pkfkidPeregrino;

    public TperegrinoParadaIdDto(Integer pkfkidParada, Integer pkfkidPeregrino) {
        this.pkfkidParada = pkfkidParada;
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

    public Integer getPkfkidParada() {
        return pkfkidParada;
    }

    public Integer getPkfkidPeregrino() {
        return pkfkidPeregrino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TperegrinoParadaIdDto entity = (TperegrinoParadaIdDto) o;
        return Objects.equals(this.pkfkidParada, entity.pkfkidParada) &&
                Objects.equals(this.pkfkidPeregrino, entity.pkfkidPeregrino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkfkidParada, pkfkidPeregrino);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "pkfkidParada = " + pkfkidParada + ", " +
                "pkfkidPeregrino = " + pkfkidPeregrino + ")";
    }
}