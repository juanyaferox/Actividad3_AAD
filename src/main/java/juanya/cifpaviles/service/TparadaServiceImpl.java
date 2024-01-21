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

    @Override
    public boolean existsTparada(String nombre, Character region) {
        return tparadaRepository.existsByCnombreAndAndCregion(nombre, region);
    }

    @Override
    public void insercionParada(String nombre, Character region) {
        Tparada tparada = new Tparada(nombre, region);
        tparadaRepository.save(tparada);
    }
}
