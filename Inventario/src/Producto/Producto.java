package Producto;

public class Producto {

    //Variables de entrada

    private String idProducto;
    private String nombreProducto;
    private String categoria;
    private int precio;
    private int cantidadDisponible;

    //Constructor

    public Producto(String idProducto, String nombreProducto, String categoria, int precio, int cantidadDisponible) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    //Getter

    public String getidProducto() {
        return idProducto;
    }

    public String getnombreProducto() {
        return nombreProducto;
    }

    public String getcategoria() {
        return categoria;
    }

    public int getprecio() {
        return precio;
    }

    public int getcantidadDisponible() {
        return cantidadDisponible;
    }

    //Setter

    public void setidProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setnombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setcategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setcantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
