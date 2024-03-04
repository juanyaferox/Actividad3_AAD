package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Servicio;
import juanya.cifpaviles.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {
    private ServicioRepository servicioRepository;
    @Autowired
    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public void crearServicio(String nombre, double precio, List<Integer> arrayIdParadas, boolean esEnvio) {
        servicioRepository.crearServicio(nombre, precio, arrayIdParadas, esEnvio);
    }

    @Override
    public Servicio obtenerServicioPorId(String pkid) {
        return servicioRepository.obtenerServicioPorId(pkid);
    }

    @Override
    public List<Servicio> obtenerServicioEnvio() {
        return servicioRepository.obtenerServicioEnvio();
    }

    @Override
    public void modificarServicioPorId(String pkid, String nuevoNombre, double nuevoPrecio, List<Integer> nuevoArrayIdParadas) {
        servicioRepository.modificarServicioPorId(pkid, nuevoNombre, nuevoPrecio, nuevoArrayIdParadas);
    }

    @Override
    public Servicio obtenerServicioPorNombre(String nombre) {
        return servicioRepository.obtenerServicioPorNombre(nombre);
    }

    @Override
    public boolean verificarNombre(String nombreServicio) {
        return servicioRepository.verificarNombre(nombreServicio);
    }

    @Override
    public boolean verificarId(String id) {
        return servicioRepository.verificarId(id);
    }

    @Override
    public boolean verificarPrecio(double precioServicio) {
        return servicioRepository.verificarPrecio(precioServicio);
    }

    @Override
    public List<Servicio> recorrerServicios() {
        return servicioRepository.recorrerServicios();
    }
}
