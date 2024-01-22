/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanya.cifpaviles;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
public class Metodos {

    protected static LocalDate obtenerFechaValida(Scanner scanner) {
        LocalDate fecha;
        do {
            try {
                System.out.println("Ingrese la fecha en el formato YYYY-MM-DD:");
                String fechaStr = scanner.nextLine();
                fecha = LocalDate.parse(fechaStr);

                // Verificar que la fecha esté en el rango deseado
                if (fecha.getYear() < 2000 || fecha.getYear() > 2100) {
                    throw new DateTimeException("Año fuera del rango permitido");
                }

            } catch (DateTimeException e) {
                System.out.println("Fecha inválida. Inténtelo de nuevo.");
                fecha = null;
            }
        } while (fecha == null);

        return fecha;
    }
}


