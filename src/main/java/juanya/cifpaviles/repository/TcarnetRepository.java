package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tcarnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TcarnetRepository extends JpaRepository<Tcarnet, Integer> {

}