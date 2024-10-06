package RetoAlura.principal;

import RetoAlura.modelos.Casos;
import RetoAlura.modelos.Menu;

import java.util.ArrayList;
import java.util.Arrays;
//principal que permite a un tipo de monera convertirla a diferentes monedas listados en el array
public class Principal2 {
    public static void main(String[] args) {
        Casos casos = new Casos();
        Menu menu = new Menu();
        ArrayList<String> lista = new ArrayList<>(Arrays.asList("","USD","ARS","CLP","PEN","BRL","EUR"));
        while (true) {
            menu.mostrarMenuMonedas();
            int opcionMenu = menu.ingresarOpcionMenu();
            if(opcionMenu == 7){
                System.out.println("Esta saliendo del Menú");
                break;
            }
            menu.mostrarMenuAconvertir();
            int opcionMenuConvertir = menu.ingresarOpcionMenu();
            if(opcionMenuConvertir == 7){
                System.out.println("Esta saliendo del Menú");
                break;
            }
            casos.setCasoOpcion(lista.get(opcionMenu), lista.get(opcionMenuConvertir));
        }
        casos.mostrarHistorial();
    }
}
