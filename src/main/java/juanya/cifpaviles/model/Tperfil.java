package juanya.cifpaviles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tperfil")
public class Tperfil {
    @Id
    @Column(name = "pkid_usuario", nullable = false)
    private String pkidUsuario;

    @Column(name = "cpassword", nullable = false)
    private String cpassword;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fkid_peregrino")
    private Tperegrino fkidPeregrino;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fkid_parada")
    private Tparada fkidParada;

    public Tperfil() {
    }

    public Tperfil(String pkidUsuario, String cpassword, Tperegrino fkidPeregrino, Tparada fkidParada) {
        this.pkidUsuario = pkidUsuario;
        this.cpassword = cpassword;
        this.fkidPeregrino = fkidPeregrino;
        this.fkidParada = fkidParada;
    }

    public String getPkidUsuario() {
        return pkidUsuario;
    }

    public void setPkidUsuario(String pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public Tperegrino getFkidPeregrino() {
        return fkidPeregrino;
    }

    public void setFkidPeregrino(Tperegrino fkidPeregrino) {
        this.fkidPeregrino = fkidPeregrino;
    }

    public Tparada getFkidParada() {
        return fkidParada;
    }

    public void setFkidParada(Tparada fkidParada) {
        this.fkidParada = fkidParada;
    }

    @Override
    public String toString() {
        return "Tperfil{" +
                "pkidUsuario='" + pkidUsuario + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", fkidPeregrino=" + fkidPeregrino +
                ", fkidParada=" + fkidParada +
                '}';
    }
}