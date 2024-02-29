package juanya.cifpaviles.conexionesDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class objectdbConnection {
    private static final String DB_URL = "objectdb:$objectdb/db/points.odb";
    //private static final String DB_URL = "objectdb://localhost:6136/mydatabase.odb";
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getConnection() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            abrirConexion();
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void cerrarConexion() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    private static void abrirConexion() {
        entityManagerFactory = Persistence.createEntityManagerFactory(DB_URL);
    }
}
