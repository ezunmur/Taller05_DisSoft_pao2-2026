package factorymethod;

//Producto abstracto del patrón Factory Method. 
public abstract class Producto {

    private final String id;
    private final String nombre;
    private final double precio;

    protected Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId()     { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] %s (id=%s, $%.2f)", getTipo(), nombre, id, precio);
    }
}