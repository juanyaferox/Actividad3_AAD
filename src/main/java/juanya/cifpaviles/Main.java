package juanya.cifpaviles;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.TipoSesion;
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
                case INVITADO -> {//aregral el bucle while que se me jodió un poco
                    System.out.println("SESIÓN: INVITADO");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Registrarse \n 2- Iniciar sesión \n 3- Salir");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n) {
                        case 1 -> {
                            System.out.println("REGISTRARSE");
                            String nombre, nacionalidad;
                            boolean exists;
                            do {
                                System.out.println("Introduzca su nombre");
                                nombre = scanner.nextLine();
                                System.out.println("Introduzca su nacionalidad");
                                nacionalidad = scanner.nextLine();
                                exists = tperegrinoService.verificarTperegrino(nombre, nacionalidad);
                                if (exists) {
                                    System.out.println("El usuario ya existe en la base de datos");
                                    System.out.println("¿Qué desea realizar?");
                                    System.out.println(" 1 - Volver al menú\n 2 - Volver a intentar");
                                    int opcion = Integer.parseInt(scanner.nextLine());
                                    if (opcion == 1) {
                                        break outer;
                                    } else if (opcion == 2) {
                                        continue;
                                    } else {
                                        System.out.println("No se trata de ninguna opción, se realizara el cierre" +
                                                " del programa");
                                        break bucle;
                                    }
                                }
                            } while (exists);
                            do {
                                System.out.println("Indique la parada en la cuál usted está alojado");
                                String parada_actual = scanner.nextLine();
                                exists = tparadaService.existsCnombreTparada(parada_actual);
                                if (!exists) {
                                    System.out.println("La parada no existe");
                                    System.out.println("¿Qué desea realizar?");
                                    System.out.println(" 1 - Volver al menú\n 2 - Volver a intentar");
                                    int opcion = Integer.parseInt(scanner.nextLine());
                                    if (opcion == 1) {
                                        break outer;
                                    } else if (opcion == 2) {
                                        continue;
                                    } else {
                                        System.out.println("No se trata de ninguna opción, se realizara el ci" +
                                                "erre del programa");
                                        break bucle;
                                    }
                                } else if (exists) {
                                    // Se obtiene el objeto parada con el nombre especificado
                                    Tparada tparada = tparadaService.objectTparada(parada_actual);

                                    // Se hace la inserción del carnet
                                    tcarnetService.insertCarnet(tparada);

                                    // Se obtiene el último carnet insertado que se encuentra en la cache
                                    Tcarnet lastcarnet = tcarnetService.selectLastCarnet();

                                    // Insertamos el tperegrino con los datos introducidos y el carnet anterior
                                    tperegrinoService.insercionTperegrino(lastcarnet, nombre, nacionalidad);

                                    System.out.println("Introduzca su usuario a registrar");
                                    String usuario = scanner.nextLine();
                                    System.out.println("Introduzca la contraseña a registrar");
                                    String contrasena = scanner.nextLine();

                                    //Se inserta en perfil con los datos introducidos+peregrino en caché
                                    Tperegrino tperegrino = tperegrinoService.selectLastPeregrino();
                                    tperfilService.insercionPerfil(usuario, contrasena, tperegrino, tparada);
                                }
                            } while (!exists);//false
                        }//fin del caso 1 (REGISTRO)
                        case 2 -> {
                            System.out.println("INICIAR SESIÓN");
                            System.out.println("Introduzca su usuario");
                            String usuario = scanner.nextLine();
                            System.out.println("Introduzca su contrasenia");
                            String contrasenia = scanner.nextLine();
                            if (usuario.equals("admin") && contrasenia.equals("admin")) {
                                System.out.println("Bienvenido Administrador General");
                                perfil = TipoSesion.ADMIN_G;
                            } else {
                                //hacer metodo es peregrino verificar que columna fkidparada es null
                                //hacer metodo es adminP verificar que columna fkidperegrino es null
                            }
                        }
                        case 3, default -> {
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
