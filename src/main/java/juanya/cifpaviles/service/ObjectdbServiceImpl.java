package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Direccion;
import juanya.cifpaviles.model.EnvioACasa;

import juanya.cifpaviles.repository.ObjectdbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectdbServiceImpl implements ObjectdbService {
    private ObjectdbRepository objectdbRepository;
    @Autowired
    public ObjectdbServiceImpl(ObjectdbRepository objectdbRepository) {
        this.objectdbRepository = objectdbRepository;
    }
    @Override
    public void persistDireccion(Direccion direccion) {
        objectdbRepository.persistDireccion(direccion);
    }

    @Override
    public void persistEnvioACasa(EnvioACasa envioACasa) {
        objectdbRepository.persistEnvioACasa(envioACasa);
    }
}
