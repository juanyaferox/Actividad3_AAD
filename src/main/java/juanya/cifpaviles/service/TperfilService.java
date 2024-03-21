package juanya.cifpaviles.service;


import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.Tperfil;
import juanya.cifpaviles.repository.TparadaRepository;
import juanya.cifpaviles.repository.TperfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TperfilService {
    void insercionPerfil(String user, String password, Tperegrino tperegrino);

    void insertarAdminPerfil(String user, String password, Tparada tparada);

    int verificarDatosTperfil(String usuario, String password);

    Tperfil findUser(String usuario);

    boolean existsUser(String usuario);
}
