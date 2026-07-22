package paquetes.Estructurales;

public class Adapter implements Target {

    private ClaseNoModificable clase;

    public Adapter(ClaseNoModificable clase){
        this.clase = clase;
    }

    @Override
    public void Ejecutar() {
        clase.Execute();
    }

}

//Interface esperada por el cliente
interface Target{
    void Ejecutar();
}

//Clase existente que no se puede modificar, y posee nombre distinto al esperado en la interface
class ClaseNoModificable{

    public void Execute(){
        System.out.println("Este return no se puede modificar");
    }
}

//Clase principal que llama a las demás
class Principal{

    public static void main(String[] args) {
        Target objetivo = new Adapter(new ClaseNoModificable());
        objetivo.Ejecutar();
    }
}
