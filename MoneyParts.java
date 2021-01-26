package moneyparts;

import java.util.ArrayList;
import java.util.Scanner;

public class MoneyParts {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un numero:");
        double num = teclado.nextDouble();
        System.out.println("Las posibles combinaciones para sumar el numero : "+num + " Son:");
        System.out.println("");
        ArrayList<Double> numeros = new ArrayList<>();
        build(num, numeros, 0.00);

    }

    public static void build(double numero, ArrayList<Double> numeros, double suma) {

        if (suma == numero) {
        

            System.out.println(numeros);
        } else {

            double[] inc = {0.05, 0.1, 0.2, 0.5, 1, 2, 10, 20, 50, 100, 200}; 
            
            for (double i : inc) {

                suma += i;
                if (suma <= numero) {
                    numeros.add(i);
                    
                    build(numero, numeros, suma);
                    numeros.remove(numeros.indexOf(i));
                }
                suma -= i;
            }
        }
    }
}