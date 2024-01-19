package juanya.cifpaviles;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.model.Tperfil;
import juanya.cifpaviles.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.Scanner;

public class Main implements CommandLineRunner {

    @Autowired
    public TperfilServiceImpl tperfilService;

    @Autowired
    public TperegrinoServiceImpl tperegrinoService;

    @Autowired
    public TparadaServiceImpl tparadaService;

    @Autowired
    public TcarnetServiceImpl tcarnetService;

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
                case INVITADO -> {//aregral el bucle while que se me jodio un poco
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
                                    do {
                                        System.out.println("Indique la parada en la cuál usted está alojado");
                                        String parada_actual = scanner.nextLine();
                                        exists = tparadaService.existsCnombreTparada(parada_actual);
                                        if (!exists) {
                                            System.out.println("La parada no existe");
                                            System.out.println("Qué desea realizar?");
                                            System.out.println(" 1 - Volver atrás \n 2 - Volver a intentar");
                                            int opcionP = Integer.parseInt(scanner.nextLine());
                                            if (opcionP == 1) {
                                                break outer;
                                            }
                                        }
                                        //se obtiene el objeto parada con el nombre especificado
                                        Tparada tparada = tparadaService.objectTparada(parada_actual);
                                        //se hace la insercion del carnet
                                        tcarnetService.insertCarnet(tparada);
                                        //obtengo el ultimo carnet insertado que se encuentra en la cache
                                        Tcarnet lastcarnet = tcarnetService.selectLastCarnet();
                                        //insertamos el tperegrino con los datos introducidos y el carnet anterior
                                        tperegrinoService.insercionTperegrino(lastcarnet, nombre, nacionalidad);
                                    } while (exists);
                                }
                            } while (exists);
                            System.out.println("Introduzca su usuario a registrar");
                            String usuario = scanner.nextLine();
                            System.out.println("Introduzca la contraseña a registrar");
                            String contrasena = scanner.nextLine();
                            Tperfil tperfil = new Tperfil();
                            tperfil.setPkidUsuario(usuario);
                            tperfil.setCpassword(contrasena);
                            //nombre, pais, parada_inicial, usuario, contraseña,
                            //usar constructor para crear objeto tperfil e introducirlo
                            //usar constructor para crear objeto
                            perfil = TipoSesion.PEREGRINO;
                        }
                        case 2 -> {

                        }
                        case 3 -> {
                            break bucle;
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
