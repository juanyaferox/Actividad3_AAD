package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TperegrinoService {

    private final TperegrinoRepository tperegrinoRepository;

    @Autowired
    public TperegrinoService(TperegrinoRepository tperegrinoRepository) {
        this.tperegrinoRepository = tperegrinoRepository;
    }

    public List<Tperegrino> v(String nombre, String nacionalidad) {
        return tperegrinoRepository.Verificacion(nombre, nacionalidad);
    }

}