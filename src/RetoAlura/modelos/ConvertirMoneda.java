package RetoAlura.modelos;
import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertirMoneda {
    private final String monedaIngresada;
    private final String monedaAConvertir;
    private final double montoAconvertir;
    private JsonObject jsonResultado;
    private String fechaYHora;

    public ConvertirMoneda(String monedaIngresada, String monedaAConvertir, double montoAconvertir) {
        this.monedaIngresada = monedaIngresada;
        this.monedaAConvertir = monedaAConvertir;
        this.montoAconvertir = montoAconvertir;
    }

    public double getMontoAconvertir() {
        return montoAconvertir;
    }

    public String getMonedaIngresada() {
        return monedaIngresada;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public JsonObject getJsonResultado() {
        return jsonResultado;
    }

    private void setJsonResultado(JsonObject jsonResultado) {
        this.jsonResultado = jsonResultado;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public double optenerResultadoJson(){
        ConsultaAPI consulta = new ConsultaAPI();
        MonedaAPI moneda =  consulta.consultaAPI(getMonedaIngresada());
        setJsonResultado(moneda.conversion_rates());
        if(getJsonResultado().has(getMonedaAConvertir())){
            return getJsonResultado().get(getMonedaAConvertir()).getAsDouble();
        }else{
            System.out.println("Tipo de moneda a convertir no Válida");
            return 0.0;
        }
    }

    public double optenerMontoConvertido(){
        getFechayHoraConsultaFormateada();
        return optenerResultadoJson() * getMontoAconvertir();
    }

    public void getFechayHoraConsultaFormateada(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formato);
        setFechaYHora(fechaHoraFormateada);
    }

    @Override
    public String toString() {
        return String.format("""
                Monto ingresado     : %.2f
                Moneda ingresada    : %s
                Moneda a convertir  : %s
                Monto resultado     : %.2f
                Fecha de la consula : %s
                """ , getMontoAconvertir()
                    , getMonedaIngresada()
                    , getMonedaAConvertir()
                    , optenerMontoConvertido()
                    , getFechaYHora());
    }
}
