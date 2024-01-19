package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tperegrino;

public interface TperegrinoService{

    boolean verificarTperegrino(String nombre, String nacionalidad);

    void insercionTperegrino(Tcarnet tcarnet, String nombre, String nacionalidad);

    Tperegrino selectLastPeregrino();
}