package com.conversor.service;

import com.conversor.model.ConversionRespuesta;
import com.conversor.model.GuardarConversion;
import com.conversor.model.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class TasaReal {
    private static final String apiBase = "https://v6.exchangerate-api.com/v6/";
    private static final String apiKey = "01f1387499a3482ef7bbc961";
    private final List<GuardarConversion> conversiones;

    public TasaReal() {
        this.conversiones = new ArrayList<>();
    }


    // Metodo
    public String tasaDeApi (Moneda monedaOrigen, Moneda monedaDestino, double cantidad) throws IOException, InterruptedException {

        // Url con monedas a convertir
        String url = apiBase + apiKey + "/pair/" + monedaOrigen.getCodigo() + "/" + monedaDestino.getCodigo();
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

            // GSON
            Gson gson = new Gson();
            ConversionRespuesta conversionRespuesta = gson.fromJson(response.body(), ConversionRespuesta.class);

            // Obtener la tasa de conversion
            double tasa = conversionRespuesta.getConversionRate();

            // Realizar la converion
            double cantidadConvertida = cantidad * tasa;

            GuardarConversion conversion = new GuardarConversion(monedaOrigen, monedaDestino, cantidad, cantidadConvertida, tasa);
            conversiones.add(conversion);

            return String.format("Tasa de conversión: %.2f\nResultado de la conversión: %.2f %s", tasa, cantidadConvertida, monedaDestino.getSimbolo());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener la tasa de cambio.");
        }


    }
    public List<GuardarConversion> getConversiones() {
        return new ArrayList<>(conversiones);
    }

}
