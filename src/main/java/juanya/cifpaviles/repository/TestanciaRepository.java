package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Testancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestanciaRepository extends JpaRepository<Testancia, Integer> {
}