/*package juanya.cifpaviles.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import juanya.cifpaviles.model.Servicio;

import java.util.List;
import java.util.stream.Collectors;

public class ServicioDAO {

    //Método para crear un servicio
    public static void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio, ObjectContainer db) {
        Servicio servicio = new Servicio(nombre, precio, arrayIdParadas, esEnvio);
        db.store(servicio);
        System.out.println("Servicio creado con éxito");
    }

    // Método para obtener un servicio por su ID
    public static Servicio obtenerServicioPorId(String pkid, ObjectContainer db) {
        Servicio servicio = new Servicio();
        servicio.setPkid(pkid);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext() ? resultados.next() : null;
    }

    public static List<Servicio> obtenerServicioEnvio(ObjectContainer db) {

        Servicio servicio = new Servicio();
        servicio.setEsEnvio(true);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);

        return resultados.stream().collect(Collectors.toList());
    }

    // Método para modificar un servicio por su ID
    public static void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas, ObjectContainer db) {
        Servicio servicio = obtenerServicioPorId(pkid,db);
        if (servicio != null) {
            servicio.setNombre(nuevoNombre);
            servicio.setPrecio(nuevoPrecio);
            servicio.setArrayIdParadas(nuevoArrayIdParadas);
            db.store(servicio);
        } else{
            System.out.println("El servicio no existe, nose ka pasao");
        }
    }

    // Método para obtener un servicio por su Nombre
    public static Servicio obtenerServicioPorNombre(String nombre, ObjectContainer db) {
        Servicio servicio = new Servicio();
        servicio.setNombre(nombre);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext() ? resultados.next() : null;
    }

    // Método para verificar si un servicio ya existe por Nombre
    public static boolean verificarNombre(String nombreServicio, ObjectContainer db) {
        // Realizar la consulta en la base de datos
        ObjectSet<Servicio> resultados = db.query(new Predicate<Servicio>() {
            @Override
            public boolean match(Servicio servicio) {
                // Realizar la comparación ignorando las diferencias entre mayúsculas y minúsculas
                return servicio.getNombre().equalsIgnoreCase(nombreServicio);
            }
        });

        // Devolver true si hay al menos un resultado (coincidencia encontrada)
        return resultados.hasNext();
    }

    // Método para verificar si un servicio ya existe por Id
    public static boolean verificarId(String id, ObjectContainer db) {

        Servicio servicio = new Servicio();
        servicio.setPkid(id);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext(); // Devuelve true si hay al menos un resultado (coincidencia encontrada)
    }

    // Método para verificar si el precio es correcto por Precio
    public static boolean verificarPrecio(double precioServicio) {
        return precioServicio > 0;
    }

    //Método para recorrer todos los servicios
    public static List<Servicio> recorrerServicios(ObjectContainer db) {
        List<Servicio> listaServicios = db.queryByExample(new Servicio());
        return listaServicios;
    }
}
*/