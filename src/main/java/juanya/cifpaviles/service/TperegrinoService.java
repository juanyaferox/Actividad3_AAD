package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TperegrinoService{

    boolean verificarTperegrino(String nombre, String nacionalidad);
}