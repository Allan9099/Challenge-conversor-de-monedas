package com.aluralatam.conversordemonedas.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Solicitud {

    private String menu = """
                        **********************************************************
                         1 - Conversion de monedas (Pares predeterminados)
                         2 - Conversion de monedas (Manual)
                         3 - Indice de monedas
                         0 - Salir
                        **********************************************************""";

        public Monedas solMoneda(String monedaUno, String monedaDos, double cantidad) {

            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/aaff40a181c6e7858f6b678b/pair/" + monedaUno + "/" + monedaDos + "/" + cantidad);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {
                HttpResponse<String> response = null;
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Monedas.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public List<List<String>> getListaCodigos() {


            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/aaff40a181c6e7858f6b678b/codes");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

                return gson.fromJson(jsonObject.get("supported_codes"), List.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    public String getMenu() {
        return menu;
    }
}

