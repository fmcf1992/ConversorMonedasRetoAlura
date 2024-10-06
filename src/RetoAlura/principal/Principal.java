package RetoAlura.principal;

import RetoAlura.modelos.Casos;
import RetoAlura.modelos.Menu;
// principal con estructura basica
public class Principal {
    public static void main(String[] args) {
        Casos casos = new Casos();
        Menu menu = new Menu();
        boolean ingresarAMenu = true;

        while (ingresarAMenu) {
            menu.mostrarMenu();
            int opcionMenu = menu.ingresarOpcionMenu();
            switch (opcionMenu) {
                    case 1:
                        casos.setCasoOpcion("USD", "ARS");
                        break;
                    case 2:
                        casos.setCasoOpcion("ARS", "USD");
                        break;
                    case 3:
                        casos.setCasoOpcion("USD", "PEN");
                        break;
                    case 4:
                        casos.setCasoOpcion("PEN", "USD");
                        break;
                    case 5:
                        casos.setCasoOpcion("USD", "EUR");
                        break;
                    case 6:
                        casos.setCasoOpcion("EUR", "USD");
                        break;
                    case 7:
                        System.out.println("Saliendo del menu");
                        ingresarAMenu = false;
                        break;
                    default:
                        System.out.println("la opcion elejida no es valida");
            }
        }
        casos.mostrarHistorial();
    }
}
