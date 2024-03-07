package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Direccion;
import juanya.cifpaviles.model.EnvioACasa;

public interface ObjectdbService {
    void persistDireccion(Direccion direccion);

    void persistEnvioACasa(EnvioACasa envioACasa);
}
