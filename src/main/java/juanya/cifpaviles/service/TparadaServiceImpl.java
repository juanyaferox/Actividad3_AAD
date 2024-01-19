package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TparadaServiceImpl implements TparadaService{

    @Autowired
    private TparadaRepository tparadaRepository;

    public TparadaServiceImpl(TparadaRepository tparadaRepository){
        this.tparadaRepository = tparadaRepository;
    }

    @Override
    public boolean existsCnombreTparada(String nombre) {
        return tparadaRepository.existsByCnombre(nombre);
    }

    @Override
    public Tparada objectTparada(String nombre) {
        return tparadaRepository.findByCnombre(nombre);
    }
}
