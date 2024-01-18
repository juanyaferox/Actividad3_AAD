package juanya.cifpaviles;

import juanya.cifpaviles.service.TparadaService;
import juanya.cifpaviles.service.TparadaServiceImpl;
import juanya.cifpaviles.service.TperegrinoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class Main implements CommandLineRunner {

    @Autowired
    public TperegrinoServiceImpl tperegrinoService;

    @Autowired
    public TparadaServiceImpl tparadaService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenido al programa gestor de base de datos");
        TipoSesion perfil = null;//inicializacion variable sesion
        int n; //variable para menu
        Scanner scanner = new Scanner(System.in);
        perfil = TipoSesion.INVITADO;
        bucle:
        while (true) {
            outer:
            switch (perfil) {
                case INVITADO -> {
                    System.out.println("SESIÓN: INVITADO");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Registrarse \n 2- Iniciar sesión \n 3- Salir");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n) {
                        case 1 -> {
                            System.out.println("REGISTRARSE");
                            boolean exists = true;
                            do {
                                System.out.println("Introduzca su nombre");
                                String nombre = scanner.nextLine();
                                System.out.println("Introduzca su nacionalidad");
                                String nacionalidad = scanner.nextLine();
                                exists = tperegrinoService.verificarTperegrino(nombre, nacionalidad);
                                if (exists) {
                                    System.out.println("El usuario ya existe en la base de datos");
                                    System.out.println("Qué desea realizar?");
                                    System.out.println(" 1 - Volver atrás \n 2 - Volver a intentar");
                                    int opcion = Integer.parseInt(scanner.nextLine());
                                    if (opcion == 1) {
                                        break outer;
                                    }
                                }
                            } while (exists);
                            System.out.println("Introduzca su usuario");
                            String usuario = scanner.nextLine();
                            System.out.println("Introduzca la contraseña");
                            String contrasena = scanner.nextLine();
                            do {
                                System.out.println("Indique la parada en la cuál usted está alojado");
                                String parada_actual = scanner.nextLine();
                                exists = tparadaService.existsCnombreTparada(parada_actual);
                                if (!exists) {
                                    System.out.println("Error parada incorrecta");
                                    System.out.println("Qué desea realizar?");
                                    System.out.println(" 1 - Volver atrás \n 2 - Volver a intentar");
                                    int opcion = Integer.parseInt(scanner.nextLine());
                                    if (opcion == 1) {
                                        break outer;
                                    }
                                }
                            } while (exists);
                            //nombre, pais, parada_inicial, usuario, contraseña,
                            //usar constructor para crear objeto tperfil e introducirlo con los fk nulos
                            //usar constructor para crear objeto
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
                    break bucle;
                }
                case PEREGRINO -> {
                    System.out.println("SESIÓN: PEREGRINO");
                    break bucle;

                }
                case ADMIN_P -> {
                    System.out.println("SESIÓN: ADMINISTRADOR DE PARADA");
                    break bucle;
                }
            }
        }
    }
}
