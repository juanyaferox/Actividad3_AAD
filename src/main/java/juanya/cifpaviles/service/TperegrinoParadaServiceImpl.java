package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.model.TperegrinoParadaId;
import juanya.cifpaviles.repository.TperegrinoParadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TperegrinoParadaServiceImpl implements TperegrinoParadaService{

    @Autowired
    private TperegrinoParadaRepository tperegrinoParadaRepository;

    public TperegrinoParadaServiceImpl(TperegrinoParadaRepository tperegrinoParadaRepository) {
        this.tperegrinoParadaRepository = tperegrinoParadaRepository;
    }
    @Override
    public void insertarTperegrinoTparada(Tperegrino tperegrino, Tparada tparada) {
        TperegrinoParadaId tperegrinoParadaId = new TperegrinoParadaId(tperegrino.getId(), tparada.getId());
        TperegrinoParada tperegrinoParada = new TperegrinoParada(tparada, tperegrino);
        tperegrinoParada.setId(tperegrinoParadaId);
        tperegrinoParadaRepository.save(tperegrinoParada);
    }
}
