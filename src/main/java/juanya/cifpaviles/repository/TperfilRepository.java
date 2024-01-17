package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tperfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TperfilRepository extends JpaRepository<Tperfil, String> {

    default void insertarTperfil(String pkidUsuario, String cpassword, String fkIdPeregrino) {
            Tperfil nuevoTperfil = new Tperfil();
            nuevoTperfil.setPkidUsuario(pkidUsuario);
            nuevoTperfil.setCpassword(cpassword);
            nuevoTperfil.setFkidPeregrino(fkIdPeregrino);
            save(nuevoTperfil);
    }
}