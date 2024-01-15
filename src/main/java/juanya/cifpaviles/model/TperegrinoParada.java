package juanya.cifpaviles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tperegrino_parada")
public class TperegrinoParada {
    @EmbeddedId
    private TperegrinoParadaId id;

    @MapsId("pkfkidParada")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pkfkid_parada", nullable = false)
    private Tparada pkfkidParada;

    @MapsId("pkfkidPeregrino")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pkfkid_peregrino", nullable = false)
    private Tperegrino pkfkidPeregrino;

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