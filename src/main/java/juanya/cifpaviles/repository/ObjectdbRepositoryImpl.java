package juanya.cifpaviles.repository;

import com.db4o.ObjectContainer;
import juanya.cifpaviles.conexionesDB.db4oConnection;
import juanya.cifpaviles.conexionesDB.objectdbConnection;
import juanya.cifpaviles.model.Direccion;
import juanya.cifpaviles.model.EnvioACasa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ObjectdbRepositoryImpl implements ObjectdbRepository {
    private EntityManager entityManager;
    public ObjectdbRepositoryImpl() {
        try{
            this.entityManager = objectdbConnection.getConnection();
            System.out.println("Conexión a objectdb realizada con éxito");
            this.entityManager.getTransaction().begin();
        } catch (Exception e){
            System.out.println("Conexión fallida: "+e.getMessage());
        }
    }

    @Override
    public void persistDireccion(Direccion direccion) {
        entityManager.persist(direccion);//objectdb
        entityManager.getTransaction().commit();//objectdb
    }

    @Override
    public void persistEnvioACasa(EnvioACasa envioACasa) {
        entityManager.persist(envioACasa);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<EnvioACasa> obtenerListaEnvioACasa() {
        TypedQuery<EnvioACasa> query = entityManager.createQuery("SELECT e FROM EnvioACasa e", EnvioACasa.class);
        List<EnvioACasa> listaEnvioACasa = query.getResultList();
        return listaEnvioACasa;
    }
}
