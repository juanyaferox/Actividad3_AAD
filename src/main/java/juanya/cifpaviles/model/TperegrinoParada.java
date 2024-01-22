package juanya.cifpaviles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tperegrino_parada")
public class TperegrinoParada {
    @EmbeddedId
    private TperegrinoParadaId id;

    @MapsId("pkfkidParada")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pkfkid_parada", nullable = false)
    private Tparada pkfkidParada;

    @MapsId("pkfkidPeregrino")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pkfkid_peregrino", nullable = false)
    private Tperegrino pkfkidPeregrino;

    public TperegrinoParada() {
    }

    public TperegrinoParada(TperegrinoParadaId id, Tparada pkfkidParada, Tperegrino pkfkidPeregrino) {
        this.id = id;
        this.pkfkidParada = pkfkidParada;
        this.pkfkidPeregrino = pkfkidPeregrino;
    }

    public TperegrinoParadaId getId() {
        return id;
    }

    public void setId(TperegrinoParadaId id) {
        this.id = id;
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