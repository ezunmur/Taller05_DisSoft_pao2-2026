package factorymethod;

import java.util.Map;

public class DigitalCreator extends ProductoCreator {

    @Override
    public Producto crearProducto(String id, String nombre, double precio,
                                  Map<String, Object> atributos) {
        double tamano = ((Number) atributos.get("tamano")).doubleValue();
        String formato = (String) atributos.get("formato");
        
        return new ProductoDigital(id, nombre, precio, tamano, formato);
    }
}