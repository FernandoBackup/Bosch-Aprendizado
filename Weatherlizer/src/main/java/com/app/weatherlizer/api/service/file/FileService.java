package com.app.weatherlizer.api.service.file;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileService {

    private final Gson gson;
    private final String filePath = "data.json";

    public FileService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveDataToFile(String weatherDataJson, double latitude, double longitude) {
        try {
            JsonArray dataArray;
            if (Files.exists(Paths.get(filePath))) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    dataArray = gson.fromJson(reader, JsonArray.class);
                }
            } else {
                dataArray = new JsonArray();
            }

            // Cria um novo objeto com os dados da consulta
            JsonObject newData = new JsonObject();
            int newId = dataArray.size() + 1;
            newData.addProperty("id", newId);
            newData.addProperty("consultaData", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            newData.addProperty("lat", latitude);
            newData.addProperty("lon", longitude);

            // Processar os dados do weatherData
            JsonObject weatherData = gson.fromJson(weatherDataJson, JsonObject.class);
            JsonElement hourlyElement = weatherData.get("hourly");

            JsonArray formattedHourly = new JsonArray();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

            // Verifica se hourly é um objeto e não um array
            if (hourlyElement.isJsonObject()) {
                JsonObject hourlyData = hourlyElement.getAsJsonObject();

                // Extrair os dados de tempo e temperatura
                JsonArray timeArray = hourlyData.getAsJsonArray("time");
                JsonArray temperatureArray = hourlyData.getAsJsonArray("temperature");

                for (int i = 0; i < timeArray.size(); i++) {
                    String time = timeArray.get(i).getAsString();
                    double temperature = temperatureArray.get(i).getAsDouble();
                    String formattedTime = LocalDateTime.parse(time).format(timeFormatter);
                    String temperatureWithUnit = String.format("%.1f °C", temperature);

                    JsonObject formattedEntry = new JsonObject();
                    formattedEntry.addProperty("time", formattedTime);
                    formattedEntry.addProperty("temperature", temperatureWithUnit);

                    formattedHourly.add(formattedEntry);
                }
            } else {
                System.out.println("O campo 'hourly' não é um objeto.");
            }

            newData.add("weatherData", formattedHourly); // Adiciona os dados formatados

            // Adicionar o novo objeto ao array
            dataArray.add(newData);

            // Escrever de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(gson.toJson(dataArray));
            }

            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
