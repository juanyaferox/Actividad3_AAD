package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Direccion;
import juanya.cifpaviles.model.EnvioACasa;

import java.util.List;

public interface ObjectdbRepository {
    void persistDireccion(Direccion direccion);

    void persistEnvioACasa(EnvioACasa envioACasa);
    List<EnvioACasa> obtenerListaEnvioACasa();
}
