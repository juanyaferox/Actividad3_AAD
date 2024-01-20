package juanya.cifpaviles;

import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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
        int n; //variable para menu

        Scanner scanner = new Scanner(System.in);
        TipoSesion perfil = TipoSesion.INVITADO;//inicializacion de variable
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
                                    } else if (opcion == 2) continue;
                                    else {
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
                                int exists = tperfilService.verificarDatosTperfil(usuario,contrasenia);

                                if (exists == 1){
                                    perfil = TipoSesion.ADMIN_P;//es adminparada
                                }else if (exists ==2){
                                    perfil = TipoSesion.PEREGRINO;
                                }else{
                                    System.out.println("ERROR, NO EXISTE EL PERFIL EN LA BASE DE DATOS");
                                }
                            }
                        }
                        case 3 -> {
                            break bucle;
                        }
                        default -> {
                            System.out.println("No se trata de ninguna opción");
                        }
                    }
                }
                case ADMIN_G -> {
                    System.out.println("SESIÓN: ADMINISTRADOR GENERAL");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Crear parada \n 2- Logout");
                    n = Integer.parseInt(scanner.nextLine());
                    switch(n){
                        case 1 -> {
                            System.out.println("CREACIÓN DE PARADA");

                                System.out.println("Introduza el nombre de la parada");
                                String nombre = scanner.nextLine();
                                boolean parada = true;
                                do{
                                System.out.println("Introduza la región (una letra) de la parada");
                                String region = scanner.nextLine();
                                        if (region.length()>1) {
                                            System.out.println("La longitud es mayor a la permitida, vuelva a " +
                                                    "introducirlo");}
                                            else {
                                            System.out.println("ok");
                                        }
                                        } while (parada);

                        }
                        case 2-> perfil =TipoSesion.INVITADO;
                    }

                }
                case PEREGRINO -> {
                    System.out.println("SESIÓN: PEREGRINO");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Exportar carnet \n 2- Logout");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n){
                        case 1 -> {
                            System.out.println();
                            System.out.println("EXPORTAR CARNET");
                        }
                        case 2 -> {
                            System.out.println("LOGOUT");
                                perfil = TipoSesion.INVITADO;
                        }
                    }

                }
                case ADMIN_P -> {
                    System.out.println("SESIÓN: ADMINISTRADOR DE PARADA");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Exportar datos parada" +
                            "\n 2- Sellar/Alojar \n 3- Logout");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n){
                        case 1 ->{
                            System.out.println("EXPORTAR DATOS DE LA PARADADA");
                        }
                        case 2 ->{
                            System.out.println("SELLAR | ALOJAR");
                        }
                        case 3 -> {
                            System.out.println("Cerrando sesión...");
                            perfil =TipoSesion.INVITADO;
                        }
                    }
                }
            }
        }
    }
}
