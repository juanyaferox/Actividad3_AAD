package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tperfil;
import juanya.cifpaviles.repository.TperfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TperfilServiceImpl implements TperfilService{

    @Autowired
    private TperfilRepository tperfilRepository;

    @Override
    public Tperfil guardar(Tperfil tperfil) {
        return tperfilRepository.save(tperfil);
    }
}
