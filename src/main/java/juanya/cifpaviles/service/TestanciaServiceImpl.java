package juanya.cifpaviles.service;

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
    public List<Object[]> encontrarEstanciaPorFechas(LocalDate fechaInicio, LocalDate fechafinal, int idparada) {
        return testanciaRepository.findByFechaBetweenAndFkidParada(fechaInicio, fechafinal, idparada);
    }
}
