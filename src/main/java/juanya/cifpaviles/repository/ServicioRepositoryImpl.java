package juanya.cifpaviles.repository;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import juanya.cifpaviles.model.Servicio;

import java.util.List;
import java.util.stream.Collectors;

public class ServicioRepositoryImpl implements ServicioRepository {
    private ObjectContainer db;

    public ServicioRepositoryImpl(ObjectContainer db) {
        this.db = db;
    }
    @Override
    public void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio) {
        Servicio servicio = new Servicio(nombre, precio, arrayIdParadas, esEnvio);
        db.store(servicio);
        System.out.println("Servicio creado con éxito");
    }

    @Override
    public Servicio obtenerServicioPorId(String pkid) {
        Servicio servicio = new Servicio();
        servicio.setPkid(pkid);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext() ? resultados.next() : null;
    }

    @Override
    public List<Servicio> obtenerServicioEnvio() {
        Servicio servicio = new Servicio();
        servicio.setEsEnvio(true);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);

        return resultados.stream().collect(Collectors.toList());
    }

    @Override
    public void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas) {
        Servicio servicio = obtenerServicioPorId(pkid);
        if (servicio != null) {
            servicio.setNombre(nuevoNombre);
            servicio.setPrecio(nuevoPrecio);
            servicio.setArrayIdParadas(nuevoArrayIdParadas);
            db.store(servicio);
        } else {
            System.out.println("El servicio no existe, nose ka pasao");
        }
    }

    @Override
    public Servicio obtenerServicioPorNombre(String nombre) {
        Servicio servicio = new Servicio();
        servicio.setNombre(nombre);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext() ? resultados.next() : null;
    }

    @Override
    public boolean verificarNombre(String nombreServicio) {
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

    @Override
    public boolean verificarId(String id) {
        Servicio servicio = new Servicio();
        servicio.setPkid(id);

        ObjectSet<Servicio> resultados = db.queryByExample(servicio);
        return resultados.hasNext();
    }

    @Override
    public boolean verificarPrecio(double precioServicio) {
        return precioServicio > 0;
    }

    @Override
    public List<Servicio> recorrerServicios() {
        List<Servicio> listaServicios = db.queryByExample(new Servicio());
        return listaServicios;
    }
}
