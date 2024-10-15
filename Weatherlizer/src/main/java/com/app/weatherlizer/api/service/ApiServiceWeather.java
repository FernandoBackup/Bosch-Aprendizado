package com.app.weatherlizer.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Service
public class ApiServiceWeather {

    public String getWeather(double latitude, double longitude) {
        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature", latitude, longitude);

        // Configurando o proxy
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.br.bosch.com", 8080));
        factory.setProxy(proxy);

        // Criando RestTemplate com proxy
        RestTemplate restTemplate = new RestTemplate(factory);

        String response = null;
        int attempts = 0;

        while (attempts < 3) {
            try {
                response = restTemplate.getForObject(url, String.class);
                return response; // Retorna a resposta se a requisição for bem-sucedida
            } catch (RestClientException e) {
                attempts++;
                System.out.println("Erro ao consumir API (tentativa " + attempts + "): " + e.getMessage());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        return "offline"; // Mensagem após 3 tentativas falhas
    }
}
