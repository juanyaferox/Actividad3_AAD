package juanya.cifpaviles.model;

public class NMConjuntoServicio {
    private ConjuntoContratado conjuntoContratado;
    private Servicio servicio;

    public NMConjuntoServicio() {
    }

    public NMConjuntoServicio(ConjuntoContratado conjuntoContratado, Servicio servicio) {
        this.conjuntoContratado = conjuntoContratado;
        this.servicio = servicio;
    }

    public ConjuntoContratado getConjuntoContratado() {
        return conjuntoContratado;
    }

    public void setConjuntoContratado(ConjuntoContratado conjuntoContratado) {
        this.conjuntoContratado = conjuntoContratado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
