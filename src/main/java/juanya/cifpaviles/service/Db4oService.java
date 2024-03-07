package juanya.cifpaviles.service;

import juanya.cifpaviles.model.ConjuntoContratado;
import juanya.cifpaviles.model.NMConjuntoServicio;
import juanya.cifpaviles.model.Servicio;

import java.util.List;

public interface Db4oService {
    void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio);
    Servicio obtenerServicioPorId(String pkid);
    List<Servicio> obtenerServicioEnvio();
    void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas);
    Servicio obtenerServicioPorNombre(String nombre);
    boolean verificarNombre(String nombreServicio);
    boolean verificarId(String id);
    boolean verificarPrecio(double precioServicio);
    List<Servicio> recorrerServicios();
    void guardarConjunto(ConjuntoContratado conjunto);
    void guardarConjuntoServicios(NMConjuntoServicio conjuntoServicios);
}