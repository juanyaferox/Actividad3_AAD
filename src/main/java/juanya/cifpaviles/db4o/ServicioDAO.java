package juanya.cifpaviles.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.List;
import java.util.Objects;

public class ServicioDAO {

    //Método para crear un servicio
    public static void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, ObjectContainer db) {
        Servicio servicio = new Servicio(nombre, precio, arrayIdParadas);
        db.store(servicio);
    }

    // Método para obtener un servicio por su ID
    public static Servicio obtenerServicioPorId(String pkid, ObjectContainer db) {
        ObjectSet<Servicio> resultados = db.queryByExample(new Servicio(null, 0, null));
        return resultados.hasNext() ? resultados.next() : null;
    }

    // Método para modificar un servicio por su ID
    public static void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas, ObjectContainer db) {
        Servicio servicio = obtenerServicioPorId(pkid,db);
            servicio.setNombre(nuevoNombre);
            servicio.setPrecio(nuevoPrecio);
            servicio.setArrayIdParadas(nuevoArrayIdParadas);
            db.store(servicio);
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

        Servicio servicio = new Servicio();
        servicio.setNombre(nombreServicio);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext(); // Devuelve true si hay al menos un resultado (coincidencia encontrada)
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
}
