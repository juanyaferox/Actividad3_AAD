package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Direccion;
import juanya.cifpaviles.model.EnvioACasa;

import java.util.List;

public interface ObjectdbService {
    void persistDireccion(Direccion direccion);

    void persistEnvioACasa(EnvioACasa envioACasa);
    List<EnvioACasa> obtenerListaEnvioACasa();
}
