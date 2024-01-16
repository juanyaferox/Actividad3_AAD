package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.repository.TcarnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TcarnetService {
    private final TcarnetRepository tcarnetRepository;

    @Autowired
    public TcarnetService(TcarnetRepository tcarnetRepository) {
        this.tcarnetRepository = tcarnetRepository;
    }
}

