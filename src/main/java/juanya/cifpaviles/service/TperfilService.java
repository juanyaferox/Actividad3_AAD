package juanya.cifpaviles.service;


import juanya.cifpaviles.repository.TparadaRepository;
import juanya.cifpaviles.repository.TperfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TperfilService {
    private final TperfilRepository tperfilRepository;

    @Autowired
    public TperfilService(TperfilRepository tperfilRepository) {
        this.tperfilRepository = tperfilRepository;
    }
}
