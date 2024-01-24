package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TestanciaRepository extends JpaRepository<Testancia, Integer> {
    List<Object[]> findByFechaBetweenAndFkidParada(LocalDate fecha, LocalDate fecha2, Tparada tparada);

    List<Testancia> findByFkidPeregrino(Tperegrino tperegrino);
}