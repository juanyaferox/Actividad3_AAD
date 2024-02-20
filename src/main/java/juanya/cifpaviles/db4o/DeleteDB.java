package juanya.cifpaviles.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class DeleteDB {


        public static void deleteDatabase(String dbFilePath) {

            // Obtener la ruta de la carpeta que contiene la base de datos
            Path folderPath = Paths.get(dbFilePath).getParent();

            // Cerrar la base de datos si está abierta
            ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbFilePath);
            if (db != null) {
                db.close();
            }

            // Borrar los archivos de la base de datos
            try {
                Files.delete(Paths.get(dbFilePath));
            } catch (IOException e) {
                System.err.println("Error al borrar el archivo de base de datos: " + dbFilePath);
                e.printStackTrace();
            }

            // Borrar la carpeta de la base de datos (si está vacía)
            try {
                Files.deleteIfExists(folderPath);
            } catch (IOException e) {
                System.err.println("Error al borrar la carpeta de la base de datos: " + folderPath);
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            // Ejemplo de uso:
            String dbFilePath = Paths.get(System.getProperty("user.dir"), "db4oDB", "database.db").toString();
            deleteDatabase(dbFilePath);
            System.out.println("Base de datos borrada con éxito.");
        }
    }
