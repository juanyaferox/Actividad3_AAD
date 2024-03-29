package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Tperfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TperfilRepository extends JpaRepository<Tperfil, String> {
    Tperfil findByPkidUsuario(String usuario);

    Tperfil findByPkidUsuarioAndCpassword(String usuario, String password);

    boolean existsByPkidUsuario(String usuario);
}