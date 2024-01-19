package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.Tperfil;
import juanya.cifpaviles.repository.TperfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TperfilServiceImpl implements TperfilService {

    @Autowired
    private TperfilRepository tperfilRepository;

    @Override
    public void insercionPerfil(String user, String password, Tperegrino tperegrino, Tparada tparada) {
        Tperfil tperfil = new Tperfil(user, password, tperegrino, tparada);
        tperfilRepository.save(tperfil);
    }

    @Override
    public int verificarDatosTperfil(String usuario, String password) {
        Tperfil tperfil = tperfilRepository.findById(usuario).orElse(null);
        if (tperfil == null) {
            return -1;
        }
        return (tperfil.getFkidPeregrino() == null) ? 1 : (tperfil.getFkidParada() == null) ? 2 : -1;
    }
}
