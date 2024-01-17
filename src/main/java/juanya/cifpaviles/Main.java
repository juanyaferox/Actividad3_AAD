package juanya.cifpaviles;

import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.service.TperegrinoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class Main implements CommandLineRunner {

    @Autowired
    public TperegrinoServiceImpl tperegrinoService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenido al programa gestor de base de datos");
        TipoSesion perfil = null;//inicializacion variable sesion
        int n; //variable para menu
        Scanner scanner = new Scanner(System.in);
        perfil = TipoSesion.INVITADO;
        bucle:
        while(true){
            switch (perfil){
                case INVITADO -> {
                    System.out.println("SESIÓN: INVITADO");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Registrarse \n 2- Iniciar sesión \n 3- Salir");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n){
                        case 1 -> {
                            System.out.println("REGISTRARSE");
                            boolean exists=true;
                            do{
                                System.out.println("Introduzca su nombre (el cuál actuará como usuario)");
                                String nombre = scanner.nextLine();
                                System.out.println("Introduzca su nacionalidad");
                                String nacionalidad = scanner.nextLine();
                                exists = tperegrinoService.verificarTperegrino(nombre, nacionalidad);
                                if (exists){
                                    System.out.println("El usuario ya existe en la base de datos, introduzca otro");
                                }
                            }while(exists);
                            System.out.println("Introduzca la contraseña");
                            String contrasena = scanner.nextLine();
                            System.out.println("Indique la parada en la cuál usted está alojado");
                            String parada_actual = scanner.nextLine();
                            //crear objeto con los datos e introducirlo en la tabla perfil y despues peregrino
                            perfil = TipoSesion.PEREGRINO;
                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                    }
                }
                case ADMIN_G -> {
                    System.out.println("SESIÓN: ADMINISTRADOR GENERAL");

                }
                case PEREGRINO -> {
                    System.out.println("SESIÓN: PEREGRINO");

                }
                case ADMIN_P -> {
                    System.out.println("SESIÓN: ADMINISTRADOR DE PARADA");

                }
            }
        }
    }
}
