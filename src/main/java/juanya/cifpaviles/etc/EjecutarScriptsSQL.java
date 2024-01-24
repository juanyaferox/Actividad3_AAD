package juanya.cifpaviles.etc;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class EjecutarScriptsSQL {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bdperegrinos_JuanIagoMartinezCorreia";
        String usuario = "root";
        String contrasena = "";

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena)) {
                // Crear un objeto ScriptRunner
                ScriptRunner scriptRunner = new ScriptRunner(conexion);

                // Configurar ScriptRunner (opcional)
                scriptRunner.setStopOnError(true);
                scriptRunner.setLogWriter(null);

                // Leer el contenido del archivo SQL
                String archivoSQL = "src/main/resources/bdperegrinos_juaniagomartinezcorreia.sql";
                Reader reader = new BufferedReader(new FileReader(archivoSQL));

                // Ejecutar el script SQL usando ScriptRunner
                scriptRunner.runScript(reader);

                System.out.println("Script SQL ejecutado con éxito.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

