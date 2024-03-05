package juanya.cifpaviles.conexionesDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class objectdbConnection {

    private static final String DEFAULT_DB_URL = "objectdb:$objectdb/db/points.odb";
    private static final String CONFIG_FILE_PATH = "src/main/resources/application.properties";
    private static final String DB_URL_PROPERTY = "objectdb.url";

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
        String dbUrl = obtenerDBUrlDesdeProperties();
        entityManagerFactory = Persistence.createEntityManagerFactory(dbUrl);
    }

    private static String obtenerDBUrlDesdeProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(fis);
            return properties.getProperty(DB_URL_PROPERTY, DEFAULT_DB_URL);
        } catch (IOException e) {
            e.printStackTrace();
            return DEFAULT_DB_URL;
        }
    }
}
