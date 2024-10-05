package com.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public MonedaAPI consultaAPI(String tipoMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/89277e6ccfd197b159a325e8/latest/"+tipoMoneda);

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
