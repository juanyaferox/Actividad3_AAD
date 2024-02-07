package juanya.cifpaviles.etc.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link juanya.cifpaviles.model.Tperfil}
 */
public class TperfilDto implements Serializable {
    private final String pkidUsuario;
    private final String cpassword;
    private final TperegrinoDto fkidPeregrino;
    private final TparadaDto fkidParada;

    public TperfilDto(String pkidUsuario, String cpassword, TperegrinoDto fkidPeregrino, TparadaDto fkidParada) {
        this.pkidUsuario = pkidUsuario;
        this.cpassword = cpassword;
        this.fkidPeregrino = fkidPeregrino;
        this.fkidParada = fkidParada;
    }

    public String getPkidUsuario() {
        return pkidUsuario;
    }

    public String getCpassword() {
        return cpassword;
    }

    public TperegrinoDto getFkidPeregrino() {
        return fkidPeregrino;
    }

    public TparadaDto getFkidParada() {
        return fkidParada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TperfilDto entity = (TperfilDto) o;
        return Objects.equals(this.pkidUsuario, entity.pkidUsuario) &&
                Objects.equals(this.cpassword, entity.cpassword) &&
                Objects.equals(this.fkidPeregrino, entity.fkidPeregrino) &&
                Objects.equals(this.fkidParada, entity.fkidParada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkidUsuario, cpassword, fkidPeregrino, fkidParada);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "pkidUsuario = " + pkidUsuario + ", " +
                "cpassword = " + cpassword + ", " +
                "fkidPeregrino = " + fkidPeregrino + ", " +
                "fkidParada = " + fkidParada + ")";
    }
}