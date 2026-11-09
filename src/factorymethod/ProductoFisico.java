package factorymethod;

public class ProductoFisico extends Producto {

    private final double pesoKg;
    private final String dimensiones;

    public ProductoFisico(String id, String nombre, double precio,
                          double pesoKg, String dimensiones) {
        super(id, nombre, precio);
        this.pesoKg = pesoKg;
        this.dimensiones = dimensiones;
    }

    public double getPesoKg()      { return pesoKg; }
    public String getDimensiones() { return dimensiones; }

    @Override
    public String getTipo() { return "FISICO"; }

    @Override
    public String toString() {
        return super.toString() + " peso=" + pesoKg + "kg, dimensiones=" + dimensiones;
    }
}