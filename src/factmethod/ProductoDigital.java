package factorymethod;

public class ProductoDigital extends Producto {

    private final double tamanoMb;
    private final String formato;

    public ProductoDigital(String id, String nombre, double precio,
                           double tamanoMb, String formato) {
        super(id, nombre, precio);
        this.tamanoMb = tamanoMb;
        this.formato = formato;
    }

    public double getTamanoMb() { return tamanoMb; }
    public String getFormato()  { return formato; }

    @Override
    public String getTipo() { return "DIGITAL"; }

    @Override
    public String toString() {
        return super.toString() + " tamaño=" + tamanoMb + "MB, formato=" + formato;
    }
}