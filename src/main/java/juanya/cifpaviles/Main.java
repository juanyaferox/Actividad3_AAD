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
                    System.out.println("¿QUE DESEA REALIZAR? \n 1- Registrarse \n 2- Iniciar sesión \n 3- Salir");
                    n = Integer.parseInt(scanner.nextLine());
                    switch (n){
                        case 1 -> {
                            System.out.println("REGISTRARSE");
                            System.out.println("Introduzca su nombre");
                            String nombre = scanner.nextLine();
                            System.out.println("Introduzca su nacionalidad");
                            String nacionalidad = scanner.nextLine();

                            boolean b = tperegrinoService.verificarTperegrino(nombre, nacionalidad);


                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                    }
                }
                case ADMIN_G -> {

                }
                case PEREGRINO -> {

                }
                case ADMIN_P -> {

                }
            }
        }
    }
}
