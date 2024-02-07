package juanya.cifpaviles.etc.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.Tperegrino}
 */
public class TperegrinoDto implements Serializable {
    private final Integer id;
    private final TcarnetDto tcarnet;
    private final String cnombre;
    private final String cnacionalidad;

    public TperegrinoDto(Integer id, TcarnetDto tcarnet, String cnombre, String cnacionalidad) {
        this.id = id;
        this.tcarnet = tcarnet;
        this.cnombre = cnombre;
        this.cnacionalidad = cnacionalidad;
    }

    public Integer getId() {
        return id;
    }

    public TcarnetDto getTcarnet() {
        return tcarnet;
    }

    public String getCnombre() {
        return cnombre;
    }

    public String getCnacionalidad() {
        return cnacionalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TperegrinoDto entity = (TperegrinoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tcarnet, entity.tcarnet) &&
                Objects.equals(this.cnombre, entity.cnombre) &&
                Objects.equals(this.cnacionalidad, entity.cnacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tcarnet, cnombre, cnacionalidad);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tcarnet = " + tcarnet + ", " +
                "cnombre = " + cnombre + ", " +
                "cnacionalidad = " + cnacionalidad + ")";
    }
}