/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanya.cifpaviles.proyecto_anterior;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author juanya

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al programa gestor de base de datos");

        System.out.println("\nSe va a realizar un intento de conexión con la base de datos");
        Connection conexion = GestorBaseDatos.Conexion();

        Perfil perfil = null;//inicializacion variable perfil
        Scanner scanner = new Scanner(System.in);
        String nombre, nacionalidad, usuario = null, contrasenia, region, switchalojar, switchalojar3;
        LocalDate fecha1, fecha2;
        boolean existe, existeuser, esPeregrino, esAdminP, existeparada;
        int n = 0;
        int switch_peregrino, switch_adming, switch_adminp, switch_exportparada, switch_exportparada2, idperegrino, switchalojar2, nvipcarne;
        perfil = Perfil.INVITADO;
        bucle:
        while (true) {
            switch (perfil) {
                case INVITADO -> {
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Registrarse \n 2- Iniciar sesión \n 3- Salir");
                    n = Integer.parseInt(scanner.nextLine());

                    switch (n) {
                        case 1 -> {
                            //LÓGICA DE REGISTRO DE PEREGRINO
                            System.out.println("REGISTRARSE");

                            System.out.println("Introduzca su nombre");
                            nombre = scanner.nextLine();

                            System.out.println("Introduzca su nacionalidad");
                            nacionalidad = scanner.nextLine();
                            existe = true;
                            do {
                                try {
                                    existe = Sistema.Verificacion(conexion, nombre, nacionalidad);
                                } catch (SQLException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }

                                if (existe == true) {
                                    System.out.println("El usuario ya existe en la base de datos, introduzca otro");
                                }
                            } while (existe == true);

                            System.out.println("Se ha comprobado que no existe el usuario en la base de datos");
                            System.out.println("Introduza su nuevo usuario y contraseña, el usuario debe ser único e irrepetible");
                            System.out.println("Introduzca el usuario");
                            usuario = scanner.nextLine();
                            existeuser = true;
                            do {//verifica si el usuario que ha introducir ya existe
                                try {
                                    existeuser = Sistema.VerificarUsuario(conexion, usuario);
                                    if (existeuser == true) {
                                        System.out.println("El usuario ya existe, introduzca uno diferente");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } while (existeuser == true);
                            System.out.println("Introduzca la contraseña");
                            contrasenia = scanner.nextLine();
                            try {
                                Sistema.Registro(conexion, usuario, contrasenia, nombre, nacionalidad);
                            } catch (SQLException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        case 2 -> {
                            System.out.println("INICIAR SESIÓN");
                            System.out.println("Introduzca su usuario");
                            usuario = scanner.nextLine();
                            System.out.println("Introduzca su contrasenia");
                            contrasenia = scanner.nextLine();
                            if (usuario.equals("admin") && contrasenia.equals("admin")) {
                                System.out.println("Bienvenido Administrador General");
                                perfil = Perfil.ADMIN_G;
                            } else {
                                try {
                                    esPeregrino = Sistema.VerificarPerfil(conexion, usuario, contrasenia, "fkid_parada");//if idparada is null entonces es peregrino
                                    esAdminP = Sistema.VerificarPerfil(conexion, usuario, contrasenia, "fkid_peregrino");//if idperegrino is null entonces es adminP
                                    if (esPeregrino == true) {
                                        System.out.println("Bienvenido Peregrino");
                                        perfil = Perfil.PEREGRINO;
                                    } else if (esAdminP == true) {
                                        System.out.println("Bienvenido Administrador de Parada");
                                        perfil = Perfil.ADMIN_P;
                                    } else {
                                        System.out.println("ERROR: El usuario no tiene ningún tipo de perfil asociado, entre en contacto con un administrador");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("FIN DEL PROGRAMA");
                            GestorBaseDatos.CerrarConexion(conexion);//se termina la conexion con la base de datos
                            break bucle;
                        }
                        default ->
                            System.out.println("INTRODUZA UNA OPCIÓN VÁLIDA");
                    }

                    //introducir los datos y verificar la existencia de ese nuevo peregrino
                }
                case ADMIN_G -> {
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Crear parada \n 2- Logout");
                    switch_adming = Integer.parseInt(scanner.nextLine());
                    switch (switch_adming) {
                        case 1 -> {
                            System.out.println("CREAR PARADA");
                            existeparada = true;

                            do {
                                System.out.println("Introduzca el nombre de la parada");
                                nombre = scanner.nextLine();
                                System.out.println("Introduza la región(2 letras)");
                                region = scanner.nextLine();
                                try {
                                    existeparada = Sistema.VerificarParada(conexion, nombre, region);

                                    if (existeparada == true) {
                                        System.out.println("Inotroduzca otra combinación de parada");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } while (existeparada == true);
                            System.out.println("Introduzca un usuario para el administrador de parada");
                            usuario = scanner.nextLine();
                            System.out.println("Introduza una contraseña para el mismo");
                            contrasenia = scanner.nextLine();
                            try {
                                Sistema.RegistrarParada(conexion, nombre, region, usuario, contrasenia);
                            } catch (SQLException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        case 2 -> {
                            System.out.println("LOGOUT");
                            perfil = Perfil.INVITADO;
                        }
                        default ->
                            System.out.println("OPCION INCORRECTA");
                    }
                }
                case PEREGRINO -> {
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Exportar carnet \n 2- Logout");
                    switch_peregrino = Integer.parseInt(scanner.nextLine());
                    switch (switch_peregrino) {
                        case 1 -> {
                            System.out.println("EXPORTAR CARNET");
                            //realizar metodos para la exportacion del carnet
                            /*Ir a tabla carnet, get pkid, get fechaexp
                            * Ir a tabla peregrino where pkfkid=pkid
                            * get nombre, get nacionalidad, get localdate.now, get distancia total from tcarnet
                            * me canse y 
                            *
                            *
                        }
                        case 2 -> {
                            System.out.println("LOGOUT");
                            perfil = Perfil.INVITADO;
                        }
                        default ->
                            System.out.println("OPCION INCORRECTA");
                    }
                }
                case ADMIN_P -> {
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Exportar datos parada \n 2- Sellar/Alojar \n 3- Logout");
                    switch_adminp = Integer.parseInt(scanner.nextLine());
                    switch (switch_adminp) {
                        case 1 -> {
                            System.out.println("EXPORTAR DATOS PARADA");
                            switch_exportparada = 0;
                            switch_exportparada2 = 0;
                            do {
                                do {

                                    System.out.println("\nEsta es la parada que usted administra:");
                                    //el administrador, tras iniciar sesión el valor de la variable `usuario` continua almacenada
                                    System.out.println("");
                                    Sistema.SelectParada(conexion, Sistema.GetIdParada(conexion, usuario));//muestra los datos de la parada
                                    System.out.println("\nIntroduzca el rango de fechas del que desea realizar la exportación:");
                                    System.out.println("Recuerde que el formato es YYYY-MM-DD");
                                    System.out.println("Fecha de inicio");
                                    fecha1 = LocalDate.parse(scanner.nextLine());
                                    System.out.println("Fecha de fin");
                                    fecha2 = LocalDate.parse(scanner.nextLine());
                                    if (Sistema.ValidarRangoFechas(fecha1, fecha2)) {
                                        System.out.println("Realizar acciones con el rango de fechas válido.");
                                    } else {
                                        // Manejar el caso de rango de fechas no válido
                                        System.out.println("Manejar acciones para rango de fechas no válido.");
                                    }
                                    System.out.println("--------------------------------------------");
                                    System.out.print("La parada deseada a exportar es -");
                                    Sistema.SelectParada(conexion, Sistema.GetIdParada(conexion, usuario));
                                    System.out.println("- en el periodo entre" + fecha1 + " y " + fecha2 + " ?");
                                    System.out.println("Digite 1 para confirmar, digite cualquier otro si desea volver");
                                    switch_exportparada = Integer.parseInt(scanner.nextLine());
                                } while (switch_exportparada != 1);
                                try {
                                    Sistema.GetEstancias(conexion, fecha1, fecha2, Sistema.GetIdParada(conexion, usuario));
                                } catch (SQLException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                                System.out.println("Desea volver a realizar el proceso?");
                                System.out.println("Digite 1 para salir, digite cualquier otro si desea repetir");
                                switch_exportparada2 = Integer.parseInt(scanner.nextLine());
                            } while (switch_exportparada2 != 1);
                        }
                        case 2 -> {
                            System.out.println("SELLAR/ALOJAR");
                            System.out.println("RECIBIR PEREGRINO EN PARADA");
                            System.out.println("INFORMACIÓN ");
                            Sistema.SelectParada(conexion, Sistema.GetIdParada(conexion, usuario));
                            System.out.println("");
                            System.out.println("\nIntroduza el ID del Peregrino");
                            idperegrino = Integer.parseInt(scanner.nextLine());
                            Sistema.SelectPeregrino(conexion, idperegrino);
                            System.out.println("Son los datos correctos?, digite 1 para continuar, cualquier otro para volver atras");
                            switchalojar2 = Integer.parseInt(scanner.nextLine());
                            if (switchalojar2 == 1) {
                                Sistema.RegistroParadaPeregrino(conexion, Sistema.GetIdParada(conexion, usuario), idperegrino);
                                Sistema.UpdateTablaCarnet(conexion, idperegrino);
                                System.out.println("Desea realizar una estancia? SI/NO");
                                switchalojar = scanner.nextLine();
                                switch (switchalojar) {
                                    case "SI" -> {
                                        System.out.println("Es VIP o no? SI/NO");
                                        switchalojar3 = scanner.nextLine();
                                        switch (switchalojar3) {
                                            case "SI" -> {
                                                nvipcarne = 1;
                                                Sistema.CreateEstancia(conexion, Sistema.GetIdParada(conexion, usuario), idperegrino, nvipcarne);
                                                Sistema.InsertCarnet(conexion, idperegrino, nvipcarne);
                                            }
                                            case "NO" -> {
                                                nvipcarne = 0;
                                                Sistema.CreateEstancia(conexion, Sistema.GetIdParada(conexion, usuario), idperegrino, nvipcarne);
                                                Sistema.InsertCarnet(conexion, idperegrino, nvipcarne);
                                            }
                                            default ->
                                                System.out.println("OPCION INCORRECTA");
                                        }
                                    }
                                    case "NO" -> {
                                        System.out.println("Volviendo al menu");
                                    }
                                    default ->
                                        System.out.println("OPCION INCORRECTA");
                                }
                            } else {
                                System.out.println("Volviendo al menu");
                            }
                        }
                        case 3 -> {
                            System.out.println("LOGOUT");
                            perfil = Perfil.INVITADO;
                        }
                        default ->
                            System.out.println("OPCION INCORRECTA");
                    }
                }
            }
        }
    }
}
*/