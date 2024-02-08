package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TestanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    public int insertarEstanciaVip(Tparada tparada, Tperegrino tperegrino) {
        Testancia testancia = new Testancia(tparada,tperegrino, LocalDate.now(), true);
        Testancia testanciaSaved = testanciaRepository.save(testancia);
        return testanciaSaved.getId();
    }

    @Override
    @Transactional
    public int insertarEstanciaNoVip(Tparada tparada, Tperegrino tperegrino) {
        Testancia testancia = new Testancia(tparada,tperegrino, LocalDate.now(), false);
        Testancia testanciaSaved = testanciaRepository.save(testancia);
        return testanciaSaved.getId();
    }

    @Override
    public List<Testancia> obtenerParadas(Tperegrino tperegrino) {
        return testanciaRepository.findByFkidPeregrino(tperegrino);
    }
}
