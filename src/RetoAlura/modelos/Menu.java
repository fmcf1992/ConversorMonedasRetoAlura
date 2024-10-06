package RetoAlura.modelos;

import java.util.Scanner;

public class Menu {
    Scanner teclado = new Scanner(System.in);
    public void mostrarMenu(){
        String menu = """
                      ***********************************************
                      Sea bienvenido/a al Conversor de Moneda
                      1) Dolar ==> Peso Argentino
                      2) Peso Argentino ==> Dolar
                      3) Dolar ==> Sol peruano
                      4) Sol peruano ==> Dolar
                      5) Dolares ==> Euros
                      6) Euros ==> Dolares
                      7) Salir
                      ***********************************************
                      """;
        System.out.println(menu);
    }

    public int ingresarOpcionMenu(){
        String expresion = "[0-9]+";
        String opmenu = "";

        while (true) {
            System.out.println("Ingrese una opción [1-7]: ");
            opmenu = teclado.next();

            if (!opmenu.matches(expresion)) {
                System.out.println(opmenu + " No es válida. Ingrese un número entre [1-7]");
            } else {
                int opcion = Integer.parseInt(opmenu);
                if (opcion >= 1 && opcion <= 7) {
                    return opcion;
                } else {
                    System.out.println(opcion + " está fuera del rango permitido [1-7]");
                }
            }
        }
    }

    public double ingresarMonto(){

        String expresion = "[0-9]+(\\.[0-9]+)?";
        String input = "";

        while (true) {
            System.out.println("Ingrese el monto: ");
            input = teclado.next();

            if (!input.matches(expresion)) {
                System.out.println(input + " no es un monto válido.");
            } else {
                double numero = Double.parseDouble(input);
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("El número debe ser mayor que cero.");
                }
            }
        }
    }
}
