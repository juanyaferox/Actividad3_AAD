package juanya.cifpaviles;

import juanya.cifpaviles.model.*;
import juanya.cifpaviles.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.w3c.dom.Document;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static juanya.cifpaviles.Metodos.*;

public class Main implements CommandLineRunner {

    @Autowired
    public TperfilServiceImpl tperfilService;

    @Autowired
    public TperegrinoServiceImpl tperegrinoService;

    @Autowired
    public TparadaServiceImpl tparadaService;

    @Autowired
    public TcarnetServiceImpl tcarnetService;

    @Autowired
    public TestanciaServiceImpl testanciaService;

    @Autowired
    public TperegrinoParadaServiceImpl tperegrinoParadaService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenido al programa gestor de base de datos");
        int n; //variable para menu
        String usuario = null;//inicialización variable del nombre de sesión
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
                            //no funciona correctamente el metodo de registro, da error en el save
                            //no consigo solucionar el error :)))))
                            //solucioné el error odio eterno al cascade
                            String nombre, nacionalidad = null;
                            boolean exists;
                            do {
                                System.out.println("Introduzca su nombre");
                                nombre = scanner.nextLine();
                                //metodo verificar nacionalidad correcta

                                boolean verificarNacionalidad = false;
                                do {
                                    try {
                                        System.out.println("Introduzca su nacionalidad");
                                        nacionalidad = scanner.nextLine();
                                        InputStream inputStream = cargarxml("paises.xml");
                                        Document documento = parsearXML(inputStream);
                                        verificarNacionalidad = buscarPaisPorNombre(documento, nacionalidad);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } while (!verificarNacionalidad);
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
                                System.out.println("Indique la región (1 letra) de la parada");
                                String regionS = scanner.nextLine();
                                Character regionC = regionS.charAt(0);
                                exists = tparadaService.existsTparada(parada_actual, regionC);
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
                                    //conseguir peregrino
                                    Tperegrino tperegrino = tperegrinoService.selectLastPeregrino();
                                    //me falta insertar los datos en la tabla tperegrino_parada para mostrar
                                    //el "paso" por la parada
                                    tperegrinoParadaService.insertarTperegrinoTparada(tperegrino, tparada);
                                    System.out.println("Introduzca su usuario a registrar");
                                    usuario = scanner.nextLine();
                                    System.out.println("Introduzca la contraseña a registrar");
                                    String contrasena = scanner.nextLine();

                                    //Se inserta en perfil con los datos introducidos+peregrino en caché

                                    tperfilService.insercionPerfil(usuario, contrasena, tperegrino, tparada);
                                }
                            } while (!exists);//false
                        }//fin del caso 1 (REGISTRO)
                        case 2 -> {
                            System.out.println("INICIAR SESIÓN");
                            System.out.println("Introduzca su usuario");
                            usuario = scanner.nextLine();
                            System.out.println("Introduzca su contrasenia");
                            String contrasenia = scanner.nextLine();
                            if (usuario.equals("admin") && contrasenia.equals("admin")) {
                                System.out.println("Bienvenido Administrador General");
                                perfil = TipoSesion.ADMIN_G;
                            } else {
                                int exists = tperfilService.verificarDatosTperfil(usuario, contrasenia);

                                if (exists == 1) {
                                    perfil = TipoSesion.ADMIN_P;//es adminparada
                                } else if (exists == 2) {
                                    perfil = TipoSesion.PEREGRINO;
                                } else {
                                    System.out.println("ERROR, NO EXISTE EL PERFIL EN LA BASE DE DATOS");
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("Saliendo del programa...");
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
                    switch (n) {
                        case 1 -> {
                            System.out.println("CREACIÓN DE PARADA");
                            boolean crearParada = true;
                            do {
                                System.out.println("Introduza el nombre de la parada");
                                String nombre = scanner.nextLine();
                                boolean verificar = false;
                                do {
                                    System.out.println("Introduza la región (una letra) de la parada");
                                    String regionS = scanner.nextLine();
                                    if (regionS.length() > 1) {
                                        System.out.println("La longitud es mayor a la permitida, vuelva a " +
                                                "introducirlo");
                                    } else {
                                        char regionC = regionS.charAt(0);
                                        verificar = tparadaService.existsTparada(nombre, regionC);
                                        if (!verificar) {
                                            System.out.println("No se encontraron coindencias en la base de datos");
                                            tparadaService.insercionParada(nombre, regionC);
                                            System.out.println("Se ha creado la parada con éxito");
                                            crearParada = false;
                                        } else {
                                            System.out.println("Se ha encontrado una coincidencia en la base de datos");
                                            System.out.println("¿Qué desea hacer?\n" +
                                                    " 1 - Volver a intentar\n 2 - Volver al menú");
                                            int opcion = Integer.parseInt(scanner.nextLine());
                                            if (opcion == 1) {
                                                //volver a intentar es decir continuar con el bucle
                                                continue;
                                            } else if (opcion == 2) {
                                                crearParada = false;
                                                //volver al menu es decir acabar con el bucle verificar y crearParada
                                            } else {
                                                System.out.println("No se ha introducido ninguna de las opciones, " +
                                                        "se va a realizar el cierre del programa");
                                                break bucle;
                                            }
                                        }
                                    }
                                } while (!verificar);
                            } while (crearParada);
                        }
                        case 2 -> perfil = TipoSesion.INVITADO;
                    }
                }
                case PEREGRINO -> {
                    //obtener el objeto perfil
                    Tperfil tperfil = tperfilService.findUser(usuario);
                    //buscar en la tabla perfil el nombre y verificar el id de columna peregrino
                    Tperegrino tperegrino = tperegrinoService.getPeregrino(tperfil);
                    String nombre = tperegrino.getCnombre();
                    String nacionalidad = tperegrino.getCnacionalidad();
                    System.out.println("SESIÓN: PEREGRINO - " + nombre + ", nacionalidad " + nacionalidad);
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Exportar carnet \n 2- Logout");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n) {
                        case 1 -> {
                            System.out.println();
                            System.out.println("EXPORTAR CARNET");
                            //hacer un faking xml se deja para despues
                        }
                        case 2 -> {
                            System.out.println("LOGOUT");
                            perfil = TipoSesion.INVITADO;
                        }
                        default -> {
                            System.out.println("No se trata de ninguna opción");
                        }
                    }
                }
                case ADMIN_P -> {

                    //obtener nombre de sesión la cual está en caché
                    //obtener el objeto perfil
                    Tperfil tperfil = tperfilService.findUser(usuario);
                    //buscar en la tabla perfil el nombre y verificar el id de columna parada
                    Tparada tparada = tparadaService.getParada(tperfil);
                    //buscar la fila con el id correspondiente y rescatar nombre y region
                    String nombreParada = tparada.getCnombre();
                    Character regionParada = tparada.getCregion();
                    System.out.println("SESIÓN: ADMINISTRADOR DE PARADA \"" + nombreParada +
                            "\" REGIÓN \"" + regionParada + "\"");
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Exportar datos parada" +
                            "\n 2- Sellar/Alojar \n 3- Logout");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n) {
                        case 1 -> {
                            System.out.println("EXPORTAR DATOS DE LA PARADADA");
                            //introducir el rango de fechas del que desea realizar la exportación
                            System.out.println("Introduzca el rango de fechas del cuál desea realizar la exportación");
                            //introducir fecha de inicio
                            System.out.println("Primero la fecha inicial");
                            LocalDate fechaInicial = obtenerFechaValida(scanner);
                            //introducir fecha de fin
                            System.out.println("Ahora la fecha final");
                            LocalDate fechaFinal = obtenerFechaValida(scanner);
                            //validar
                            if (fechaFinal.isBefore(fechaInicial)) {
                                System.out.println("La fecha inicial es anterior a la fecha final.");
                                //poner algo yo que sé
                            } else {
                                //mostrar parada y rango de fechas antes de confirmar
                                System.out.println("¿Está seguro que desea exportar los datos de la parada \"" +
                                        nombreParada + "\", región \"" + regionParada + "\" entre el " + fechaInicial +
                                        " y el " + fechaFinal + " ?");
                                System.out.println(" 1 - Confirmar\n otro - Volver atrás");
                                String opcion = scanner.nextLine();
                                if (opcion.equals("1")) {
                                    List<Object[]> estancias = testanciaService.encontrarEstanciaPorFechas
                                            (fechaInicial, fechaFinal, tparada);
                                    if (!estancias.isEmpty()) {//lo que funciona no se toca
                                        for (Object[] posicion : estancias) {
                                            //posible mejor: obtener el nombre del peregrino de la instancia
                                            Testancia testancia = (Testancia) posicion[0];
                                            System.out.println("Id de la estancia: " + testancia.getId() +
                                                    " Fecha: " + testancia.getFecha());
                                            System.out.println("---------------");
                                        }
                                    } else System.out.println("No se encontró nada");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("SELLAR | ALOJAR");
                            System.out.println("Introduzca el nombre y nacionalidad del peregrino a alojar");
                            System.out.println("Nombre:");
                            String nombre = scanner.nextLine();
                            System.out.println("Nacionalidad:");
                            String nacionalidad = scanner.nextLine();
                            System.out.println("Nombre: " + nombre + ", nacionalidad: " + nacionalidad + ".¿Son estos datos correctos?");
                            System.out.println(" 1 - Son correctos\n 2&- Volver atrás"); //preguntar si los datos son correctos
                            try {
                                int opcion = Integer.parseInt(scanner.nextLine());
                                if (opcion == 1) {
                                    boolean verificar = tperegrinoService.verificarTperegrino(nombre, nacionalidad);
                                    if (verificar) {
                                        System.out.println("Se va realizar el sellado");
                                        //metodo para conseguir el peregrino
                                        Tperegrino tperegrino = tperegrinoService.selectPeregrino(nombre, nacionalidad);
                                        //creamos objeto carnet del peregrino
                                        Tcarnet tcarnet = tcarnetService.selectCarnet(tperegrino);
                                        //añadimos distancia
                                        tcarnet.setDistancia(tcarnet.getDistancia()+5);//suponemos 5km entre parada y parada
                                        //metodo para hacer la insercion en la tabla tperegrino_parada
                                        tperegrinoParadaService.insertarTperegrinoTparada(tperegrino, tparada);
                                        System.out.println("Desea realizar realizar una estancia?");
                                        System.out.println(" 1 - Realizar estancia \n 2& - No realizar estancia");
                                        try {
                                            int opcionEstancia = Integer.parseInt(scanner.nextLine());
                                            if (opcionEstancia == 1) {
                                                System.out.println("Es vip o no?");
                                                System.out.println(" 1 - Sí, es vip \n 2& - No, no es vip");
                                                try {
                                                    int opcionVIP = Integer.parseInt(scanner.nextLine());
                                                    if (opcionVIP == 1) {
                                                        //metodo para insertar en estancia con vip true(1)
                                                        testanciaService.insertarEstanciaVip(tparada, tperegrino);
                                                        //metodo para añadir +1 al vip de tcarnet del peregrino
                                                        tcarnetService.updateTcarnetVIP(tcarnet);
                                                    } else {
                                                        //metodo para inserta en estancia con vip false(0)
                                                        testanciaService.insertarEstanciaNoVip(tparada, tperegrino);
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("No se trata de un número, " + e.getMessage());
                                                }
                                            } else {
                                                //no hacer nada
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("No se trata de un número, " + e.getMessage());
                                        }
                                    } else {
                                        System.out.println("No existe este peregrino en la base de datos");
                                    }
                                } else {
                                    //no hacer nada
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("No se trata de un número, " + e.getMessage());
                            }
                        }
                        case 3 -> {
                            System.out.println("Cerrando sesión...");
                            perfil = TipoSesion.INVITADO;
                        }
                    }
                }
            }
        }
    }
}
