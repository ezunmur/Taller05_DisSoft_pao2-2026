import factorymethod.*;
import java.util.HashMap;
import java.util.Map;
import singleton.dbcentral;

public class Main {

    private static final Map<String, ProductoCreator> creadores = new HashMap<>();

    static {
        creadores.put("FISICO", new FisicoCreator());
        creadores.put("DIGITAL", new DigitalCreator());
    }

    public static Producto crearYRegistrarProducto(String tipo, String id, String nombre, 
                                                   double precio, Map<String, Object> atributos) {
        
        ProductoCreator creador = creadores.get(tipo.toUpperCase());
        
        if (creador == null) {
            throw new IllegalArgumentException("Tipo de producto no soportado: " + tipo);
        }
        
        return creador.registrarProducto(id, nombre, precio, atributos);
    }

    public static void main(String[] args) {
        dbcentral db = dbcentral.getInstance();

        System.out.println("--- Creación Dinámica de Productos ---");

        Producto p1 = crearYRegistrarProducto("FISICO", "P001", "Monitor 24 pulgadas", 150.00,
                Map.of("peso", 3.5, "dimensiones", "54x32x5 cm"));

        Producto p2 = crearYRegistrarProducto("DIGITAL", "P002", "Licencia de Antivirus", 45.50,
                Map.of("tamano", 15.0, "formato", "EXE"));

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\n--- Verificación en la Base de Datos Central ---");
        System.out.println("Total de productos guardados: " + db.listar().size());
        System.out.println("Consultando P002: " + db.consultar("P002"));
    }
}