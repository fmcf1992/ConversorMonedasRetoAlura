package RetoAlura.modelos;

import java.util.Scanner;

public class Casos {
    private Historial historial = new Historial();
    public void setCasoOpcion(String monedaIngresada, String monedaDestino){
        Menu menu = new Menu();
        double montoIngresado = menu.ingresarMonto();
        ConvertirMoneda convertir = new ConvertirMoneda(monedaIngresada, monedaDestino, montoIngresado);
        historial.guardarConsulta(convertir.toString());
        System.out.println(convertir);
    }

    public Historial getHistorial() {
        return historial;
    }

    public void mostrarHistorial() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea ver sus ultimos 3 movimientos: [Y]");
        String res = teclado.next();
        if (res.equalsIgnoreCase("Y")) {
            getHistorial().mostrarDetalleDeUltimasConsultas();
        }
        System.out.println("********************* FIN *********************");
    }
}
