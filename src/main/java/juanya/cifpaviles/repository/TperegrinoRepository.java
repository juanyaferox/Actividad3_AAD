package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tperegrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
 @Repository
public interface TperegrinoRepository extends JpaRepository<Tperegrino, Integer> {
     boolean existsByCnombreAndCnacionalidad(String nombre, String nacionalidad);

     Tperegrino findByCnombreAndCnacionalidad(String nombre, String nacionalidad);
}