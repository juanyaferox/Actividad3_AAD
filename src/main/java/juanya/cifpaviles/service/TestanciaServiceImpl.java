package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TestanciaRepository;
import juanya.cifpaviles.repository.TparadaRepository;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void insertarEstanciaVip(Tparada tparada, Tperegrino tperegrino) {
        Testancia testancia = new Testancia(tparada,tperegrino, LocalDate.now(), true);
        testanciaRepository.save(testancia);
    }

    @Override
    @Transactional
    public void insertarEstanciaNoVip(Tparada tparada, Tperegrino tperegrino) {
        Testancia testancia = new Testancia(tparada,tperegrino, LocalDate.now(), false);
        testanciaRepository.save(testancia);
    }

    @Override
    public List<Testancia> obtenerParadas(Tperegrino tperegrino) {
        return testanciaRepository.findByFkidPeregrino(tperegrino);
    }
}
