package juanya.cifpaviles.service.Tparada;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.model.Tperfil;
import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TparadaServiceImpl implements TparadaService{
    @Autowired
    private final TparadaRepository tparadaRepository;

    public TparadaServiceImpl(TparadaRepository tparadaRepository) {
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

    @Override
    public Tparada getParada(Tperfil tperfil) {
        return tperfil.getFkidParada();
    }

    @Override
    public Optional<Tparada> getParadaById(TperegrinoParada tperegrinoParada) {
        if (tperegrinoParada != null && tperegrinoParada.getPkfkidParada() != null) {
            return tparadaRepository.findById(tperegrinoParada.getPkfkidParada().getId());
        } else {
            return Optional.empty();
        }
    }

}
