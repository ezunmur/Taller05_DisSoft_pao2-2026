package singleton;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

//Comentarios explicativos al final de cada metodo, EAZM
public class dbcentral{
    private final Map<String, Object> tabla = new LinkedHashMap<>();
    private boolean conectado;
//Orden de insercion, con referencias protegidas
    private dbcentral() {
        System.out.println("[dbcentral] Instancia creada.");
    }
//Constructor privado, Singleton
    private static final class Holder {
        private static final dbcentral INSTANCE = new dbcentral();
    }
    public static dbcentral getInstance() {
        return Holder.INSTANCE;
    }
//Instancia estatica, creada una sola vez y generamos acceso global 
    public synchronized void conectar() {
        if (!conectado) {
            conectado = true;
            System.out.println("[dbcentral] Conexión establecida.");
        }
    }
 //Verifica la conexion   
    public synchronized void guardar(String id, Object entidad) {
        conectar();
        tabla.put(id, entidad);
    }
    
    public synchronized Object consultar(String id) {
        conectar();
        return tabla.get(id);
    }
//Llamamos al metodo conectar() para asegurar conexion y se guardan datos de id y entidad.
//Getter y setter respectivo
    public synchronized Collection<Object> listar() {
        conectar();
        return tabla.values();
    }
//Listado de objetos almacenados en la tabla.
}