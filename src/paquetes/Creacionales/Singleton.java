package paquetes.Creacionales;

public class Singleton {
    private static Singleton _instancia;

    private Singleton(){}

    public static Singleton ObtenerInstancia(){
        if(_instancia == null){
            _instancia = new Singleton();
        }
        return _instancia;
    }
}

class Cliente{
    public static void main(String[] args) {
        System.out.println("Esta es la primera instancia: " + Singleton.ObtenerInstancia());
        System.out.println("Esta es la segunda instancia instancia: " + Singleton.ObtenerInstancia());
        System.out.println("Comparando instancias: " + (Singleton.ObtenerInstancia() == Singleton.ObtenerInstancia()));
    }
}