/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanya.cifpaviles;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
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

    protected static InputStream cargarxml(String nombreRecurso) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(nombreRecurso);
    }

    protected static Document parsearXML(InputStream inputStream) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(inputStream);
    }

    protected static boolean buscarPaisPorNombre(Document documento, String nombrePaisBuscado) throws Exception {
        try {
            // Normalizar el documento
            documento.getDocumentElement().normalize();

            // Obtener la lista de nodos "pais"
            NodeList listaPaises = documento.getElementsByTagName("pais");

            // Iterar sobre la lista de nodos "pais"
            for (int i = 0; i < listaPaises.getLength(); i++) {
                Node nodoPais = listaPaises.item(i);

                if (nodoPais.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPais = (Element) nodoPais;

                    // Obtener el contenido del nodo "nombre"
                    String nombrePais = elementoPais.getElementsByTagName("nombre").item(0).getTextContent();

                    // Verificar si coincide con el nombre buscado
                    if (nombrePais.equalsIgnoreCase(nombrePaisBuscado)) {
                        System.out.println("Se encontró el país con nombre: " + nombrePais);
                        // Puedes realizar otras operaciones con la información del país encontrado
                        return true; // Terminar la búsqueda una vez encontrado el país
                    }
                }
            }
            // Mensaje si no se encuentra el país
            System.out.println("No se encontró ningún país con el nombre: " + nombrePaisBuscado);
            return false;

        } catch (Exception e) {
            throw new Exception("Error al buscar el país por nombre", e);
        }
        }
    }


