package juanya.cifpaviles.service.Tperfil;

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
    public void insercionPerfil(String user, String password, Tperegrino tperegrino) {
        Tperfil tperfil = new Tperfil(user, password, tperegrino, null);
        tperfilRepository.save(tperfil);
    }

    @Override
    public int verificarDatosTperfil(String usuario, String password) {
        Tperfil tperfil = tperfilRepository.findByPkidUsuarioAndCpassword(usuario,password);
        if (tperfil == null) {
            return -1;
        }
        return (tperfil.getFkidPeregrino() == null) ? 1 : (tperfil.getFkidParada() == null) ? 2 : -1;
    }

    @Override
    public Tperfil findUser(String usuario) {
        Tperfil tperfil = tperfilRepository.findByPkidUsuario(usuario);
        return tperfil;
    }

    @Override
    public boolean existsUser(String usuario) {
        return tperfilRepository.existsByPkidUsuario(usuario);
    }
}
