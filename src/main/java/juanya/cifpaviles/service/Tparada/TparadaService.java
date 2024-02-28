package juanya.cifpaviles.service.Tparada;


import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.model.Tperfil;

import java.util.Optional;

public interface TparadaService{
    boolean existsCnombreTparada(String nombre);
    Tparada objectTparada(String nombre);

    boolean existsTparada(String nombre, Character region);
    void insercionParada(String nombre, Character region);
    Tparada getParada(Tperfil tperfil);

    Optional<Tparada> getParadaById(TperegrinoParada tperegrinoParada);
}
