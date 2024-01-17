package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TperegrinoServiceImpl implements TperegrinoService{

    @Autowired
    private TperegrinoRepository tperegrinoRepository;

    public TperegrinoServiceImpl(TperegrinoRepository tperegrinoRepository) {
        this.tperegrinoRepository = tperegrinoRepository;
    }

    @Override
    public boolean verificarTperegrino(String nombre, String nacionalidad) {
        return tperegrinoRepository.existsByCnombreAndCnacionalidad(nombre, nacionalidad);
    }
}
