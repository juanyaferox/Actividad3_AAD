package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Testancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TestanciaRepository extends JpaRepository<Testancia, Integer> {
    List<Object[]> findByFechaBetweenAndFkidParada(LocalDate fechaInicio, LocalDate fechafinal, int idparada);
}