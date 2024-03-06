package juanya.cifpaviles;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.spi.PersistenceProvider;
import juanya.cifpaviles.etc.ProgressBar;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class Aplicacion{
    public static void main(String[] args) {
        try {
            System.out.println("\n\u001B[38;5;102mCARGANDO APLICACIÓN, POR FAVOR ESPERE\u001B[38;5;22m");
            SpringApplication.run(Aplicacion.class, args);
        } catch (BeanCreationException dbException) {
            // Manejar excepción específica para problemas de conexión a la base de datos
            System.err.println("ERROR DE CREACIÓN DEL BEAN: \n" +dbException.getMessage());
        } catch (Exception e) {
            // Manejar excepción genérica para otros errores durante la inicialización
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
}