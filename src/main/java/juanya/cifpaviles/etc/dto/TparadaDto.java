package juanya.cifpaviles.etc.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.Tparada}
 */
public class TparadaDto implements Serializable {
    private final Integer id;
    private final String cnombre;
    private final Character cregion;

    public TparadaDto(Integer id, String cnombre, Character cregion) {
        this.id = id;
        this.cnombre = cnombre;
        this.cregion = cregion;
    }

    public Integer getId() {
        return id;
    }

    public String getCnombre() {
        return cnombre;
    }

    public Character getCregion() {
        return cregion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TparadaDto entity = (TparadaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cnombre, entity.cnombre) &&
                Objects.equals(this.cregion, entity.cregion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnombre, cregion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cnombre = " + cnombre + ", " +
                "cregion = " + cregion + ")";
    }
}