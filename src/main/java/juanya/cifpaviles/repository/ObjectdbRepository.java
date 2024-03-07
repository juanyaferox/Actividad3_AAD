package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Direccion;
import juanya.cifpaviles.model.EnvioACasa;

public interface ObjectdbRepository {
    void persistDireccion(Direccion direccion);

    void persistEnvioACasa(EnvioACasa envioACasa);
}
