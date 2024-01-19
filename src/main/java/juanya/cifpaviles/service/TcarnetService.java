package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;

public interface TcarnetService {
    void insertCarnet(Tparada tparada);
    Tcarnet selectLastCarnet();
}

