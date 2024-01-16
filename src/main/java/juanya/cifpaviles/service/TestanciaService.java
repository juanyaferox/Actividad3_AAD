package juanya.cifpaviles.service;


import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.repository.TestanciaRepository;
import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestanciaService  extends JpaRepository<Testancia, > {
}
