package juanya.cifpaviles.service;

import juanya.cifpaviles.repository.TcarnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TcarnetServiceImpl {

    @Autowired
    public TcarnetService(TcarnetRepository tcarnetRepository) {
        this.tcarnetRepository = tcarnetRepository;
    }
}
