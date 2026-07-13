package paquetes.Creacionales;

import org.w3c.dom.ls.LSOutput;

public class Builder {

    public static void main(String[] args) {
        Director director = new Director(new ImplementacionA());
        Producto producto1 = director.ConstruirProductoSimple();
        Producto producto2 = director.ConstruirProductoCompleto();

        System.out.println(producto1.toString());
        System.out.println(producto2.toString());
    }
}

class Producto {

    //Atributos
    private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private float precio;


    //Constructores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}

interface IBuilder{
    void asignarId(int id);
    void asignarNombre(String nombre);
    void asignarDescripcion(String descripcion);
    void asignarStock(int stock);
    void asignarPrecio(float precio);
    Producto construirProducto();
}

class ImplementacionA implements IBuilder{

    private Producto producto;

    public ImplementacionA(){
        producto = new Producto();
    }

    @Override
    public void asignarId(int id) {
        this.producto.setId(id);
    }

    @Override
    public void asignarNombre(String nombre) {
        this.producto.setNombre(nombre);
    }

    @Override
    public void asignarDescripcion(String descripcion) {
        this.producto.setDescripcion(descripcion);
    }

    @Override
    public void asignarStock(int stock) {
        this.producto.setStock(stock);
    }

    @Override
    public void asignarPrecio(float precio) {
        this.producto.setPrecio(precio);
    }

    public Producto construirProducto(){
        Producto producto = this.producto;

        this.Resetear();

        return producto;
    }

    public void Resetear(){
        this.producto = new Producto();
    }
}

class Director{
    public IBuilder builder;

    public Director(IBuilder builder){
        this.builder = builder;
    }

    public Producto ConstruirProductoSimple(){
        this.builder.asignarId(1);
        this.builder.asignarNombre("Si");
        this.builder.asignarDescripcion("Ajá");

        return this.builder.construirProducto();
    }

    public Producto ConstruirProductoCompleto(){
        this.builder.asignarId(2);
        this.builder.asignarNombre("No");
        this.builder.asignarDescripcion("Nah ah");
        this.builder.asignarStock(2333);
        this.builder.asignarPrecio(281237f);

        return this.builder.construirProducto();
    }
}
