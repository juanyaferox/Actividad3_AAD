package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.TperegrinoParada;
import juanya.cifpaviles.model.TperegrinoParadaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TperegrinoParadaRepository extends JpaRepository<TperegrinoParada, TperegrinoParadaId> {
}