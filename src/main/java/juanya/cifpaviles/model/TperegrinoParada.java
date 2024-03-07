package juanya.cifpaviles.model;


import jakarta.persistence.*;

@Entity
@Table (name = "tperegrino_parada")
@IdClass (TperegrinoParadaId.class)
public class TperegrinoParada {

    @Id
    @ManyToOne (fetch = FetchType.EAGER, optional = false,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pkfkid_parada", nullable = false)
    private Tparada pkfkidParada;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pkfkid_peregrino", nullable = false)
    private Tperegrino pkfkidPeregrino;

    public TperegrinoParada() {
    }

    public TperegrinoParada(Tparada pkfkidParada, Tperegrino pkfkidPeregrino) {
        this.pkfkidParada = pkfkidParada;
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

    public Tparada getPkfkidParada() {
        return pkfkidParada;
    }

    public void setPkfkidParada(Tparada pkfkidParada) {
        this.pkfkidParada = pkfkidParada;
    }

    public Tperegrino getPkfkidPeregrino() {
        return pkfkidPeregrino;
    }

    public void setPkfkidPeregrino(Tperegrino pkfkidPeregrino) {
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

}