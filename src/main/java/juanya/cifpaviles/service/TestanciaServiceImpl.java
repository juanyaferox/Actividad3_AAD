package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.repository.TestanciaRepository;
import juanya.cifpaviles.repository.TparadaRepository;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class TestanciaServiceImpl implements TestanciaService{

    @Autowired
    private TestanciaRepository testanciaRepository;

    public TestanciaServiceImpl(TestanciaRepository testanciaRepository) {
        this.testanciaRepository = testanciaRepository;
    }
    @Override
    public List<Object[]> encontrarEstanciaPorFechas(LocalDate fecha1, LocalDate fecha2, Tparada tparada) {
        return testanciaRepository.findByFechaBetweenAndFkidParada(fecha1, fecha2, tparada);
    }
}
