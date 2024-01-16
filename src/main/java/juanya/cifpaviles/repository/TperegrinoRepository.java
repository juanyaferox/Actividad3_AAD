package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tperegrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TperegrinoRepository extends JpaRepository<Tperegrino, Integer> {
    @Query("SELECT * FROM tperegrino WHERE cnombre LIKE ?1 AND cnacionalidad LIKE ?2")
    List<Tperegrino> Verificacion(String nombre, String nacionalidad);

}