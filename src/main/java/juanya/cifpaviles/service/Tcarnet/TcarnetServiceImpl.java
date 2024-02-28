package juanya.cifpaviles.service.Tcarnet;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TcarnetRepository;
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

    @Override
    public Tcarnet selectCarnet(Tperegrino tperegrino) {
        return tcarnetRepository.findById(tperegrino.getId())
                .orElseThrow(() -> new RuntimeException("No se encontró el Tcarnet con el ID proporcionado"));
    }
    @Override
    public void updateTcarnetVIP(Tcarnet tcarnet) {
        tcarnet.setNvips(tcarnet.getNvips()+1);
        tcarnetRepository.save(tcarnet);
    }

    @Override
    public void updateCarnet(Tcarnet tcarnet) {
        tcarnetRepository.save(tcarnet);
    }
}
