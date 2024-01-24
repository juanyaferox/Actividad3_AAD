package juanya.cifpaviles.etc;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearAccesoDirectoURL {

    public static void main(String[] args) {
        String url = "https://github.com/juanyaferox/Actividad3_AAD";
        String nombreArchivo = "github";

        crearAccesoDirectoURL(url, nombreArchivo);
    }

    public static void crearAccesoDirectoURL(String url, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo + ".url"))) {
            writer.println("[InternetShortcut]");
            writer.println("URL=" + url);
            System.out.println("El acceso directo " + nombreArchivo + ".url ha sido creado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
