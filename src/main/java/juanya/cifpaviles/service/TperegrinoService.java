package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.Tperfil;

public interface TperegrinoService{

    boolean verificarTperegrino(String nombre, String nacionalidad);

    void insercionTperegrino(Tcarnet tcarnet, String nombre, String nacionalidad);

    Tperegrino selectLastPeregrino();

    Tperegrino selectPeregrino(String nombre, String nacionalidad);

    Tperegrino getPeregrino(Tperfil tperfil);
}