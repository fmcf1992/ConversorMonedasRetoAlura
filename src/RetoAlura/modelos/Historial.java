package RetoAlura.modelos;
import java.util.Collections;
import java.util.Stack;

public class Historial {
    private Stack<String> historialDeConsultas = new Stack<>();
    private int maximoDeConsultasGuardadas = 3;

    public void guardarConsulta(String consulta){
        controlarTamanioBuffer();
        this.historialDeConsultas.push(consulta);
    }

    public int getMaximoDeConsultasGuardadas() {
        return maximoDeConsultasGuardadas;
    }

    public Stack<String> getHistorialDeConsultas() {
        return historialDeConsultas;
    }

    public void controlarTamanioBuffer(){
        if (getHistorialDeConsultas().size() == getMaximoDeConsultasGuardadas()){
            this.historialDeConsultas.removeElementAt(0);
        }
    }

    public void mostrarDetalleDeUltimasConsultas(){
        Stack<String> listaInversa;
        listaInversa = getHistorialDeConsultas();
        Collections.reverse(listaInversa);
        listaInversa.forEach(System.out::println);
    }
}
