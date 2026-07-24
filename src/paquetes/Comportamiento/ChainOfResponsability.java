package paquetes.Comportamiento;

//Clase cliente que construye la cadena de manejadores
public class ChainOfResponsability {
    public static void main(String[] args) {
        //Se crean todos los manejadores
        var lider = new Lider();
        var gerente = new Gerente();
        var director = new Director();

        //Se prepara toda la cadena de manejadores
        lider.setSiguiente(gerente);
        lider.setSiguiente(director);

        //Lista de compras para realizar prueba
        double[] compras = { 100, 1000, 10000, 100000};

        //Foreach para realizar una prueba de cada caso
        for(var compra : compras){
            lider.ProcesarSolicitud(compra);
        }
    }
}


abstract class Manejador{

    protected Manejador siguiete;

    public Manejador setSiguiente(Manejador siguiente){
        this.siguiete = siguiente;
        return siguiente;
    }

    public abstract void ProcesarSolicitud(double monto);
}


class Lider extends Manejador{

    @Override
    public void ProcesarSolicitud(double monto) {
        if(monto <= 100){
            System.out.println("Compra aprobada por el Lider");
        }else if(siguiete != null){
            siguiete.ProcesarSolicitud(monto);
        }
    }
}

class Gerente extends Manejador{

    @Override
    public void ProcesarSolicitud(double monto) {
        if(monto <= 1000){
            System.out.println("Compra aprobada por el Gerente");
        }else if(siguiete != null){
            siguiete.ProcesarSolicitud(monto);
        }
    }
}

class Director extends Manejador{

    @Override
    public void ProcesarSolicitud(double monto) {
        if(monto <= 10000){
            System.out.println("Compra aprobada por el Director");
        }else{
            System.out.println("La compra no se puede aprobar");
        }
    }
}
