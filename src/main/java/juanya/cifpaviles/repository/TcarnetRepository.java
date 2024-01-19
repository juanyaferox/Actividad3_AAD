package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TcarnetRepository extends JpaRepository<Tcarnet, Integer> {
}