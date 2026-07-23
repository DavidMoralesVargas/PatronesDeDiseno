package paquetes.Creacionales;

//Esta será la clase cliente, la que pedirá todo y posee el método main
public class FactoryMethod {

    public static void main(String[] args) {
        System.out.println("Esta es la primera implementación: ");
        ICreator fabrica1 = new Fabrica1();
        System.out.println(fabrica1.crearProducto());

        System.out.println("Esta es la segunda implementación: ");
        ICreator fabrica2 = new Fabrica2();
        System.out.println(fabrica2.crearProducto());
    }
}

//Interfaces y clases de los productos y sus implementaciones
interface IProducto{
    String crearProducto();
}

class ProductoConcreto1 implements IProducto{

    @Override
    public String crearProducto() {
        return "Aquí se creó el producto con implementación concreta 1";
    }
}

class ProductoConcreto2 implements IProducto{

    @Override
    public String crearProducto() {
        return "Aquí se creó el producto con implementación concreta 2";
    }
}


//Interfaces y clases de las fabricas
interface ICreator{
    IProducto crearProducto();
}

class Fabrica1 implements ICreator{

    @Override
    public IProducto crearProducto() {
        return new ProductoConcreto1();
    }
}

class Fabrica2 implements  ICreator{

    @Override
    public IProducto crearProducto() {
        return new ProductoConcreto2();
    }
}




