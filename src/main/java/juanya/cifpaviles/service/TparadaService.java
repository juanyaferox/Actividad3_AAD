package juanya.cifpaviles.service;


import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TparadaService {
    private final TparadaRepository tparadaRepository;

    @Autowired
    public TparadaService(TparadaRepository tparadaRepository) {
        this.tparadaRepository = tparadaRepository;
    }
}
