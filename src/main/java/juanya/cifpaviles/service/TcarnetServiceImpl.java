package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.repository.TcarnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TcarnetServiceImpl implements TcarnetService{

    private final TcarnetRepository tcarnetRepository;
    private Tcarnet lastcarnet;

    public TcarnetServiceImpl(TcarnetRepository tcarnetRepository) {
        this.tcarnetRepository = tcarnetRepository;
    }

    @Override
    public void insertCarnet(Tparada tparada) {
        Tcarnet tcarnet = new Tcarnet(tparada, LocalDate.now() );
        tcarnetRepository.save(tcarnet);
        lastcarnet = tcarnet;
    }

    @Override
    public Tcarnet selectLastCarnet() {
        return lastcarnet;
    }
}
