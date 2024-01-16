package juanya.cifpaviles.service;


import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.repository.TperegrinoParadaRepository;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TperegrinoParadaService {
    private final TperegrinoParadaRepository tperegrinoParadaRepository;

    @Autowired
    public TperegrinoParadaService(TperegrinoParadaRepository tperegrinoParadaRepository) {
        this.tperegrinoParadaRepository = tperegrinoParadaRepository;
    }
}
