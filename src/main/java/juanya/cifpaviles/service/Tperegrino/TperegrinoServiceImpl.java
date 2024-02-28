package juanya.cifpaviles.service.Tperegrino;

import jakarta.transaction.Transactional;
import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.Tperfil;
import juanya.cifpaviles.repository.TcarnetRepository;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TperegrinoServiceImpl implements TperegrinoService{

    @Autowired
    private TperegrinoRepository tperegrinoRepository;

    @Autowired
    private TcarnetRepository tcarnetRepository;

    public TperegrinoServiceImpl(TperegrinoRepository tperegrinoRepository) {
        this.tperegrinoRepository = tperegrinoRepository;
    }

    private Tperegrino lastPeregrino;

    @Override
    public boolean verificarTperegrino(String nombre, String nacionalidad) {
        return tperegrinoRepository.existsByCnombreAndCnacionalidad(nombre, nacionalidad);
    }

    @Override
    @Transactional
    public void insercionTperegrino(Tcarnet tcarnet, String nombre, String nacionalidad) {
        Tperegrino tperegrino = new Tperegrino(tcarnet.getId(),tcarnet,nombre,nacionalidad);
        tperegrinoRepository.save(tperegrino);
        lastPeregrino = tperegrino;
    }

    @Override
    public Tperegrino selectLastPeregrino() {
        return lastPeregrino;
    }

    @Override
    public Tperegrino selectPeregrino(String nombre, String nacionalidad) {
        return tperegrinoRepository.findByCnombreAndCnacionalidad(nombre, nacionalidad);
    }

    @Override
    public Tperegrino getPeregrino(Tperfil tperfil) {
        return tperfil.getFkidPeregrino();
    }
}
