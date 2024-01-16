package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TperegrinoService extends JpaRepository<Tperegrino, Integer> {
    List<Tperegrino> verificacion(String nombre, String nacionalidad);
}