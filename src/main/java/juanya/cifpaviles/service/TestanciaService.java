package juanya.cifpaviles.service;


import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TestanciaRepository;
import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TestanciaService{
    List<Object[]> encontrarEstanciaPorFechas(LocalDate fecha1, LocalDate fecha2, Tparada tparada);

    void insertarEstanciaVip(Tparada tparada, Tperegrino tperegrino);

    void insertarEstanciaNoVip(Tparada tparada, Tperegrino tperegrino);

    List<Testancia> obtenerParadas(Tperegrino tperegrino);
}
