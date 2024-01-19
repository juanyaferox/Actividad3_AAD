package juanya.cifpaviles.service;


import juanya.cifpaviles.model.Tparada;

public interface TparadaService {
    boolean existsCnombreTparada(String nombre);
    Tparada objectTparada(String nombre);
}
