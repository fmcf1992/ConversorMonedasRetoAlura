package RetoAlura.modelos;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public MonedaAPI consultaAPI(String tipoMoneda){
        String API_KEY = "89277e6ccfd197b159a325e8";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+tipoMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), MonedaAPI.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda : "+e);
        }
    }
}
