package juanya.cifpaviles.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.List;

public class ServicioDAO {
    private static ObjectContainer db;

    public ServicioDAO(ObjectContainer Objetodb) {
        db = Objetodb;
    }

    //Método para crear un servicio
    public static void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas) {
        Servicio servicio = new Servicio(nombre, precio, arrayIdParadas);
        db.store(servicio);
    }

    // Método para obtener un servicio por su ID
    public Servicio obtenerServicioPorId(int pkid) {
        ObjectSet<Servicio> resultados = db.queryByExample(new Servicio(null, 0, null));
        return resultados.hasNext() ? resultados.next() : null;
    }

    // Método para modificar un servicio por su ID
    public void modificarServicioPorId(int pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas) {
        Servicio servicio = obtenerServicioPorId(pkid);
        if (servicio != null) {
            servicio.setNombre(nuevoNombre);
            servicio.setPrecio(nuevoPrecio);
            servicio.setArrayIdParadas(nuevoArrayIdParadas);
            db.store(servicio);
        }
    }

    // Método para verificar si un servicio ya existe
    public static boolean verificarNombre(String nombreServicio) {

        Servicio servicio = new Servicio();
        servicio.setNombre(nombreServicio);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext(); // Devuelve true si hay al menos un resultado (coincidencia encontrada)
    }

    // Método para verificar si el precio es correcto
    public static boolean verificarPrecio(double precioServicio) {
        return precioServicio >= 0;
    }
}
