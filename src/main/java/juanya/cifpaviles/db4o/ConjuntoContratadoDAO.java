package juanya.cifpaviles.db4o;

import com.db4o.ObjectContainer;

import java.util.List;

public class ConjuntoContratadoDAO {
    public static void crearConjunto(ConjuntoContratado conjunto, ObjectContainer db) {
        db.store(conjunto);
    }
}
