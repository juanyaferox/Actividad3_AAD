package juanya.cifpaviles.service;

import juanya.cifpaviles.model.ConjuntoContratado;
import juanya.cifpaviles.model.NMConjuntoServicio;
import juanya.cifpaviles.model.Servicio;
import juanya.cifpaviles.repository.Db4oRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Db4oServiceImpl implements Db4oService {
    private Db4oRepository db4oRepository;
    @Autowired
    public Db4oServiceImpl(Db4oRepository db4oRepository) {
        this.db4oRepository = db4oRepository;
    }

    @Override
    public void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio) {
        db4oRepository.crearServicio(nombre, precio, arrayIdParadas, esEnvio);
    }

    @Override
    public Servicio obtenerServicioPorId(String pkid) {
        return db4oRepository.obtenerServicioPorId(pkid);
    }

    @Override
    public List<Servicio> obtenerServicioEnvio() {
        return db4oRepository.obtenerServicioEnvio();
    }

    @Override
    public void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas) {
        db4oRepository.modificarServicioPorId(pkid, nuevoNombre, nuevoPrecio, nuevoArrayIdParadas);
    }

    @Override
    public Servicio obtenerServicioPorNombre(String nombre) {
        return db4oRepository.obtenerServicioPorNombre(nombre);
    }

    @Override
    public boolean verificarNombre(String nombreServicio) {
        return db4oRepository.verificarNombre(nombreServicio);
    }

    @Override
    public boolean verificarId(String id) {
        return db4oRepository.verificarId(id);
    }

    @Override
    public boolean verificarPrecio(double precioServicio) {
        return db4oRepository.verificarPrecio(precioServicio);
    }

    @Override
    public List<Servicio> recorrerServicios() {
        return db4oRepository.recorrerServicios();
    }

    @Override
    public void guardarConjunto(ConjuntoContratado conjunto) {
        db4oRepository.guardarConjunto(conjunto);
    }

    @Override
    public void guardarConjuntoServicios(NMConjuntoServicio conjuntoServicios) {
        db4oRepository.guardarConjuntoServicio(conjuntoServicios);
    }
}
