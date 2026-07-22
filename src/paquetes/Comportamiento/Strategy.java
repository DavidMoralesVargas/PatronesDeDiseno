package paquetes.Comportamiento;

import java.util.Scanner;

class Principal{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Strategy strategy = new Strategy();

        while(true){
            System.out.println("""
                SELECCIONE UNA OPCIÓN PARA CONTINUAR:
                
                1- Suma
                2- Resta
                3- Multiplicación
                4- División
                5- Salir
                """);
            int opc = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese número 1: ");
            int num1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese número 2: ");
            int num2 = Integer.parseInt(scanner.nextLine());

            strategy.Ejecutar(opc, num1, num2);
        }
    }
}

public class Strategy {

    private IStrategy strategy;

    public void Ejecutar(int estrategia, int num1, int num2){
        switch (estrategia){
            case 1 -> strategy = new Suma();
            case 2 -> strategy = new Resta();
            case 3 -> strategy = new Multiplicacion();
            case 4 -> strategy = new Division();
            default -> throw new RuntimeException();
        }

        strategy.calcular(num1, num2);
    }
}

interface IStrategy{
    void calcular(int num1, int num2);
}

class Suma implements IStrategy{

    @Override
    public void calcular(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}

class Resta implements IStrategy{

    @Override
    public void calcular(int num1, int num2) {
        System.out.println(num1 - num2);
    }
}

class Multiplicacion implements IStrategy{

    @Override
    public void calcular(int num1, int num2) {
        System.out.println(num1 * num2);
    }
}

class Division implements IStrategy{

    @Override
    public void calcular(int num1, int num2) {
        System.out.println(num1 / num2);
    }
}