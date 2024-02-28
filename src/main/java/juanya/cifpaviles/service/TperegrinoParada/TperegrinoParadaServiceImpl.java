package juanya.cifpaviles.service.TperegrinoParada;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.repository.TperegrinoParadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TperegrinoParadaServiceImpl implements TperegrinoParadaService{

    @Autowired
    private TperegrinoParadaRepository tperegrinoParadaRepository;

    public TperegrinoParadaServiceImpl(TperegrinoParadaRepository tperegrinoParadaRepository) {
        this.tperegrinoParadaRepository = tperegrinoParadaRepository;
    }
    @Override
    public void insertarTperegrinoTparada(Tperegrino tperegrino, Tparada tparada) {
        TperegrinoParada tperegrinoParada = new TperegrinoParada(tparada, tperegrino);
        tperegrinoParadaRepository.save(tperegrinoParada);
    }

    @Override
    public List<TperegrinoParada> obtenerPeregrinoParada(Tperegrino tperegrino) {
        return tperegrinoParadaRepository.findByPkfkidPeregrino(tperegrino);
    }
}
