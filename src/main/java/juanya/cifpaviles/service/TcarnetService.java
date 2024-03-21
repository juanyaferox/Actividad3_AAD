package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;

import java.util.List;

public interface TcarnetService {
    void insertCarnet(Tparada tparada);
    Tcarnet selectLastCarnet();

    Tcarnet selectCarnet(Tperegrino tperegrino);
    void updateTcarnetVIP(Tcarnet tcarnet);

    void updateCarnet(Tcarnet tcarnet);
    List<Tcarnet> selectAllCarnet();
}

