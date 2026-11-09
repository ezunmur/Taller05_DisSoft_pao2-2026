package factorymethod;

import java.util.Map;
import singleton.dbcentral;

/**Creator del patrón Factory Method.
Declara el factory method (crearProducto) y las subclases deciden qué Producto concreto instanciar.
 */
public abstract class ProductoCreator {

    public abstract Producto crearProducto(String id, String nombre, double precio,
                                           Map<String, Object> atributos);

    public Producto registrarProducto(String id, String nombre, double precio,
                                      Map<String, Object> atributos) {
        Producto producto = crearProducto(id, nombre, precio, atributos);
        
        dbcentral.getInstance().guardar(producto.getId(), producto);
        
        return producto;
    }
}