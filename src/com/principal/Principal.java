package com.principal;

import com.modelos.ConvertirMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String menu = """
                      ***********************************************
                      Sea bienvenido/a al Conversor de Moneda
                      1) Dolar ==> Peso Argentino
                      2) Peso Argentino ==> Dolar
                      3) Dolar ==> Sol peruano
                      4) Sol peruano ==> Dolar
                      7) Salir
                      Elija una opcion válida
                      ***********************************************
                      """;

//        System.out.println(nuevaMoneda);
        System.out.println(menu);
        int opcionMenu = teclado.nextInt();

        while (opcionMenu != 7){
            ConvertirMoneda convertir = null;
            System.out.println("Ingrese el monto a convertir:");
            double montoIngresado = teclado.nextDouble();
            switch (opcionMenu){
                case 1:
                    convertir = new ConvertirMoneda("USD","ARS", montoIngresado);
                    System.out.println(convertir);
                    break;
                case 2:
                    convertir = new ConvertirMoneda("ARS","USD", montoIngresado);
                    System.out.println(convertir);
                    break;
                case 3:
                    convertir = new ConvertirMoneda("USD","PEN", montoIngresado);
                    System.out.println(convertir);
                    break;
                case 4:
                    convertir = new ConvertirMoneda("PEN","USD", montoIngresado);
                    System.out.println(convertir);
                    break;
                case 5:
                    convertir = new ConvertirMoneda("USD","EUR", montoIngresado);
                    System.out.println(convertir);
                    break;
                case 6:
                    convertir = new ConvertirMoneda("EUR","USD", montoIngresado);
                    System.out.println(convertir);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("opcion no valida");
                    throw new IllegalStateException("Unexpected value: " + opcionMenu);
            }

            System.out.println(menu);
            opcionMenu = teclado.nextInt();
        }

    }
}
