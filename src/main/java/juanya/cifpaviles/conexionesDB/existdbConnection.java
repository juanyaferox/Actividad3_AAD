package juanya.cifpaviles.conexionesDB;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.exist.xmldb.EXistResource;

public class existdbConnection {

    private static final String file_path = "src/main/resources/application.properties";
    private static Collection col = null;
    private static XMLResource res = null;

    public existdbConnection() {
            inicializateDB();
    }

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(file_path)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getExistURI() {
        Properties props = loadProperties();
        return props.getProperty("exist.uri");
    }

    public static String getExistUser() {
        Properties props = loadProperties();
        return props.getProperty("exist.user");
    }

    public static String getExistPassword() {
        Properties props = loadProperties();
        return props.getProperty("exist.password");
    }

    public static String getExistDriver() {
        Properties props = loadProperties();
        return props.getProperty("exist.driver");
    }
    public static Collection getCollection() {
        return col;
    }

    public static XMLResource getXMLResource() {
        return res;
    }

    public static void inicializateDB() {
            try{
                Class cl = Class.forName(getExistDriver());
                Database database = (Database) cl.newInstance();
                database.setProperty("create-database", "true");
                DatabaseManager.registerDatabase(database);
                col = DatabaseManager.getCollection(getExistURI(), getExistUser(), getExistPassword());
            } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

    }

    public static void closeConnection() {
        if (res != null) {
            try {
                ((EXistResource) res).freeResources();
            } catch (XMLDBException xe) {
                xe.printStackTrace();
            }
        }
        if (col != null) {
            try {
                col.close();
            } catch (XMLDBException xe) {
                xe.printStackTrace();
            }
        }
        System.out.println("Conexión con existdb cerrada");
    }
}

