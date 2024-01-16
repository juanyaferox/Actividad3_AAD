package juanya.cifpaviles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public Aplicacion applicationStartupRunner() {
        return new Aplicacion();
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}