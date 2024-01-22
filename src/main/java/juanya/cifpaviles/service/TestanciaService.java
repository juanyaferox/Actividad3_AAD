package juanya.cifpaviles.service;


import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.repository.TestanciaRepository;
import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TestanciaService{
    List<Object[]> encontrarEstanciaPorFechas(LocalDate fechaInicio, LocalDate fechafinal, int idparada);
}
