package juanya.cifpaviles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessResourceFailureException;

@SpringBootApplication
public class Aplicacion {

    @Bean
    public Main applicationStartupRunner() {
        return new Main();
    }
    public static void main(String[] args) {
        try {
            SpringApplication.run(Aplicacion.class, args);
        } catch (DataAccessResourceFailureException dbException) {
            // Manejar excepción específica para problemas de conexión a la base de datos
            System.err.println("Error de conexión a la base de datos: " + dbException.getMessage());
        } catch (Exception e) {
            // Manejar excepción genérica para otros errores durante la inicialización
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
}