package Personal.Calculadora;

import java.util.Scanner;

public class PrimeraCalculadora {
        public static void main(String[] args) {

        //Scanner
        Scanner sc = new Scanner(System.in);

        //Variables
        int num1, num2;
        String selecion;

        System.out.println("Calculadora");

        //Obtencion primero numero
        System.out.print("Dame un numero: ");
        num1 = sc.nextInt();

        //Obtencion segundo numero
        System.out.print("Dame otro numero: ");
        num2 = sc.nextInt();

        //Selecion actividad
        System.out.println("Que desea hacer? (sumar, restar, multiplicar, dividir) ");
        selecion = sc.next().toLowerCase();

        switch (selecion) {
            case "sumar":
                System.out.println("Suma: " + Math.addExact(num1,num2));
                break;
            case "restar":
                System.out.println("Resta: " + Math.subtractExact(num1, num2));
                break;
            case "multiplicar":
                System.out.println("Multiplicacion: " + Math.multiplyExact(num1, num2));
                break;
            case "dividir":
                System.out.println("Division: " + Math.divideExact(num1, num2));
                break;
        }// Fin switch

        sc.close();

    }//Fin main
    
}
