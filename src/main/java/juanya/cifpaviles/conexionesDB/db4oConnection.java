package juanya.cifpaviles.conexionesDB;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import java.nio.file.Paths;

public class db4oConnection {
    private static final String DB4O_DATABASE_FILENAME = "db4o.db";
    private static final String DB4O_FOLDER_PATH = Paths.get(System.getProperty("user.dir"), "db").toString();
    private static ObjectContainer db;

    public static ObjectContainer getConnection() {
        if (db == null || db.ext().isClosed()) {
            abrirConexion();
        }
        return db;
    }

    public static void cerrarConexion() {
        if (db != null && !db.ext().isClosed()) {
            db.close();
            System.out.println("Conexión con db4o cerrada");
        }
    }

    private static void abrirConexion() {
        String dbFilePath = Paths.get(DB4O_FOLDER_PATH, DB4O_DATABASE_FILENAME).toString();
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        // Puedes agregar configuraciones adicionales según sea necesario, como configuración de índices, activación de actualización en cascada, etc.
        db = Db4oEmbedded.openFile(config, dbFilePath);
    }
}
