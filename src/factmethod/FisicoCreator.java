package factorymethod;

import java.util.Map;

/** Creator concreto de productos físicos. */
public class FisicoCreator extends ProductoCreator {

    @Override
    public Producto crearProducto(String id, String nombre, double precio,
                                  Map<String, Object> atributos) {
        double peso = ((Number) atributos.get("peso")).doubleValue();
        String dimensiones = (String) atributos.get("dimensiones");
        
        return new ProductoFisico(id, nombre, precio, peso, dimensiones);
    }
}