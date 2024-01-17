package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tperegrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
 @Repository
public interface TperegrinoRepository extends JpaRepository<Tperegrino, Integer> {
    @Query("SELECT t FROM Tperegrino t WHERE t.cnombre LIKE ?1 AND t.cnacionalidad LIKE ?2")
    List<Tperegrino> Verificacion(String nombre, String nacionalidad);

}