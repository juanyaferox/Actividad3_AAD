package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tparada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TparadaRepository extends JpaRepository<Tparada, Integer> {
    boolean existsByCnombre(String nombre);
}