package juanya.cifpaviles.service;


import juanya.cifpaviles.model.Testancia;
import juanya.cifpaviles.model.Tparada;
import juanya.cifpaviles.model.Tperegrino;

import java.time.LocalDate;
import java.util.List;

public interface TestanciaService{
    List<Object[]> encontrarEstanciaPorFechas(LocalDate fecha1, LocalDate fecha2, Tparada tparada);

    int insertarEstanciaVip(Tparada tparada, Tperegrino tperegrino);

    int insertarEstanciaNoVip(Tparada tparada, Tperegrino tperegrino);

    List<Testancia> obtenerParadas(Tperegrino tperegrino);
}
