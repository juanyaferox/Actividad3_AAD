package juanya.cifpaviles.repository;

import juanya.cifpaviles.model.Servicio;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ServicioRepository {
    void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio);
    Servicio obtenerServicioPorId(String pkid);
    List<Servicio> obtenerServicioEnvio();
    void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas);
    Servicio obtenerServicioPorNombre(String nombre);
    boolean verificarNombre(String nombreServicio);
    boolean verificarId(String id);
    boolean verificarPrecio(double precioServicio);
    List<Servicio> recorrerServicios();
}
