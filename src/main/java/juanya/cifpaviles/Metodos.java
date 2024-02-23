/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanya.cifpaviles;

import jakarta.persistence.Persistence;
import juanya.cifpaviles.model.*;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    protected static InputStream cargarxml() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream("paises.xml");
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
    protected static void generarXMLPeregrino
            (Tperegrino tperegrino, Tcarnet tcarnet, List<Tparada> listaTparada,
             List<Testancia> listaTestancia) {
        Document document = convertirDocumentAXmlString
                (tperegrino, tcarnet, listaTparada, listaTestancia);
        imprimirXmlEnConsola(document);
        System.out.println("Desea exportar el archivo xml?");
        System.out.println(" SÍ - Deseo exportar\n NO& - No deseo exportar");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("si")||opcion.equalsIgnoreCase("sí")){

            exportarDocumentoXml(document,
                    normalize(tperegrino.getCnombre()+tperegrino.getCnacionalidad()+
                            "Id"+tperegrino.getId()));
        }
    }

    private static Document convertirDocumentAXmlString
            (Tperegrino tperegrino, Tcarnet tcarnet, List<Tparada> tparadaList,
             List<Testancia> testanciaList) {
        try {
            // Crear el DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Crear el documento
            Document document = dBuilder.newDocument();

            // Crear el elemento raíz <carnet>
            Element carnetElement = document.createElement("carnet");
            document.appendChild(carnetElement);


            //Crear el elemento <id>
            Element idElement = document.createElement("id");
            carnetElement.appendChild(idElement);
            Text textNode = document.createTextNode(String.valueOf(tperegrino.getId()));
            idElement.appendChild(textNode);


            // Agregar elemento <fechaexp>
            Element fechaexpElement = document.createElement("fechaexp");
            carnetElement.appendChild(fechaexpElement);
            textNode = document.createTextNode(String.valueOf(tcarnet.getFechaexp()));
            fechaexpElement.appendChild(textNode);

            // Agregar elemento <expedido_en>
            Element expedidoEnElement = document.createElement("expedido_en");
            carnetElement.appendChild(expedidoEnElement);
            textNode = document.createTextNode(tparadaList.get(0).getCnombre());
            expedidoEnElement.appendChild(textNode);

            // Agregar elemento <peregrino>
            Element peregrinoElement = document.createElement("peregrino");
            carnetElement.appendChild(peregrinoElement);

            // Agregar elementos dentro de <peregrino>
            Element nombreElement = document.createElement("nombre");
            peregrinoElement.appendChild(nombreElement);
            textNode = document.createTextNode(tperegrino.getCnombre());
            nombreElement.appendChild(textNode);

            Element nacionalidadElement = document.createElement("nacionalidad");
            peregrinoElement.appendChild(nacionalidadElement);
            textNode = document.createTextNode(tperegrino.getCnacionalidad());
            nacionalidadElement.appendChild(textNode);

            // Agregar elemento <hoy>
            Element hoyElement = document.createElement("hoy");
            carnetElement.appendChild(hoyElement);
            textNode = document.createTextNode(String.valueOf(LocalDate.now()));
            hoyElement.appendChild(textNode);

            // Agregar elementos
            Element distanciaTotalElement = document.createElement("distancia_total");
            carnetElement.appendChild(distanciaTotalElement);
            textNode = document.createTextNode(String.valueOf(tcarnet.getDistancia()));
            distanciaTotalElement.appendChild(textNode);

            // Agregar elemento <paradas>
            Element paradasElement = document.createElement("paradas");
            carnetElement.appendChild(paradasElement);


            // Agregar elementos dentro de <paradas>
            for (int i = 0; i < tparadaList.size(); i++) {
                Element paradaElement = document.createElement("parada");

                Element ordenElement = document.createElement("orden");
                paradaElement.appendChild(ordenElement);
                textNode = document.createTextNode(String.valueOf(i+1));
                ordenElement.appendChild(textNode);

                Element nombreParadaElement = document.createElement("nombre");
                paradaElement.appendChild(nombreParadaElement);
                textNode = document.createTextNode(tparadaList.get(i).getCnombre());
                nombreParadaElement.appendChild(textNode);

                Element regionElement = document.createElement("region");
                paradaElement.appendChild(regionElement);
                textNode = document.createTextNode(String.valueOf(tparadaList.get(i).getCregion()));
                regionElement.appendChild(textNode);

                paradasElement.appendChild(paradaElement);
            }

            // Agregar elemento <estancias>
            Element estanciasElement = document.createElement("estancias");
            carnetElement.appendChild(estanciasElement);

            // Agregar elementos dentro de <estancias>
            for (int i = 0; i < testanciaList.size(); i++) {
                Element estanciaElement = document.createElement("estancia");

                Element idEstanciaElement = document.createElement("id");
                estanciaElement.appendChild(idEstanciaElement);
                textNode = document.createTextNode(String.valueOf(testanciaList.get(i).getId()));
                idEstanciaElement.appendChild(textNode);

                Element fechaEstanciaElement = document.createElement("fecha");
                estanciaElement.appendChild(fechaEstanciaElement);
                textNode = document.createTextNode(String.valueOf(testanciaList.get(i).getFecha()));
                fechaEstanciaElement.appendChild(textNode);

                Element paradaEstanciaElement = document.createElement("parada");
                estanciaElement.appendChild(paradaEstanciaElement);
                Tparada tparada = testanciaList.get(i).getFkidParada();
                for (int a = 0; a < tparadaList.size(); a++) { //hacer un findby en tparada
                    Tparada tparadaGetNombre = tparadaList.get(a);
                    if (tparadaGetNombre.getId() == tparada.getId()){
                        textNode = document.createTextNode(tparadaGetNombre.getCnombre());
                        paradaEstanciaElement.appendChild(textNode);
                        break;
                    }
                }
                Element vipElement = document.createElement("vip");
                estanciaElement.appendChild(vipElement);
                textNode = document.createTextNode(String.valueOf(testanciaList.get(i).getVip()));
                vipElement.appendChild(textNode);

                estanciasElement.appendChild(estanciaElement);
            }

            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void imprimirXmlEnConsola(Document document) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Crear fuente DOM
            DOMSource source = new DOMSource(document);

            // Crear resultado de consola
            StreamResult consoleResult = new StreamResult(System.out);

            // Transformar y imprimir el XML en la consola
            transformer.transform(source, consoleResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void exportarDocumentoXml(Document document, String nombreArchivo) {
        try {
            //Declaramos la ruta
            String ruta = Paths.get(System.getProperty("user.dir"), "xml").toString();
            File carpeta = new File(ruta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
            ruta = Paths.get(ruta, nombreArchivo).toString();

            // Configurar el transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Crear fuente DOM
            DOMSource source = new DOMSource(document);

            // Crear resultado de archivo
            StreamResult result = new StreamResult(new File(ruta+".xml"));

            // Transformar y exportar el XML al archivo
            transformer.transform(source, result);

            System.out.println("Documento XML exportado correctamente a: " + ruta);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static String normalize(String cadena) {
        // Reemplazar acentos y caracteres especiales
        String cadenaNormalizada = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        Pattern patron = Pattern.compile("[^\\p{ASCII}]");
        return patron.matcher(cadenaNormalizada).replaceAll("").replaceAll("\\s", "");
    }

    public static void verificarYCrearCarpeta(Path ruta) {
        // Verificar si la carpeta existe
        if (!Files.exists(ruta)) {
            try {
                // Intentar crear la carpeta
                Files.createDirectories(ruta);
                System.out.println("La carpeta se ha creado correctamente en la ruta: " + ruta);
            } catch (IOException e) {
                System.out.println("No se pudo crear la carpeta en la ruta: " + ruta);
                e.printStackTrace();
            }
        }
    }
    public static String obtenerCarpetaPath() {
        // Especifica la ruta de la carpeta manualmente
        String carpetaPath = "./objectDB/";

        // Verificar si la carpeta existe
        File carpeta = new File(carpetaPath);
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Intenta crear la carpeta si no existe
        }

        // Devuelve la ruta de la carpeta
        return carpetaPath;
    }

    public static Map<String, String> createProperties() {
        return Map.of(
                "javax.persistence.jdbc.url", "objectdb:/objectDB/db.odb",
                "javax.persistence.provider", "com.objectdb.jpa.Provider"
        );
    }



}


