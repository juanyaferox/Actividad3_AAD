package juanya.cifpaviles.service;


import juanya.cifpaviles.repository.TestanciaRepository;
import juanya.cifpaviles.repository.TparadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestanciaService {
    private final TestanciaRepository testanciaRepository;

    @Autowired
    public TestanciaService(TestanciaRepository testanciaRepository) {
        this.testanciaRepository = testanciaRepository;
    }
}
