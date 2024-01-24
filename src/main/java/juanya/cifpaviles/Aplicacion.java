package juanya.cifpaviles;

import juanya.cifpaviles.etc.ProgressBar;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aplicacion implements ApplicationRunner {

    @Bean
    public Main applicationStartupRunner() {
        return new Main();
    }
    public static void main(String[] args) {
        try {
            System.out.println("\n\u001B[38;5;102mCARGANDO APLICACIÓN, POR FAVOR ESPERE\u001B[38;5;22m");
            SpringApplication app = new SpringApplication(Aplicacion.class);
            app.run(args);
        } catch (BeanCreationException dbException) {
            // Manejar excepción específica para problemas de conexión a la base de datos
            System.err.println("ERROR DE CONEXIÓN A LA BASE DE DATOS\n\n"+dbException.getMessage());
        } catch (Exception e) {
            // Manejar excepción genérica para otros errores durante la inicialización
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
    @Override
    public void run(ApplicationArguments args){
        // Imprime la barra de carga
        System.out.print("\u001B[32m");
        ProgressBar progressBar = new ProgressBar(200);
        progressBar.simulateProcessing();
        System.out.print("\u001B[0m\n");
    }
}