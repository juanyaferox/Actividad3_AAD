package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.model.TperegrinoParadaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TperegrinoParadaRepository extends JpaRepository<TperegrinoParada, TperegrinoParadaId> {
    List<TperegrinoParada> findByPkfkidPeregrino(Tperegrino tperegrino);
}