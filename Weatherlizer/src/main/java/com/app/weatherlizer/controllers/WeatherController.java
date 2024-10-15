package com.app.weatherlizer.controllers;

import com.app.weatherlizer.displays.WeatherDisplay;
import com.app.weatherlizer.api.response.WeatherResponse;
import com.app.weatherlizer.api.service.ApiServiceWeather;
import com.app.weatherlizer.api.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherController {

    @Autowired
    private ApiServiceWeather apiServiceWeather;

    @Autowired
    private FileService fileService;

    @GetMapping("home/weather/")
    public String showWeatherForm() {
        return "weatherPage"; // Retorna o formulário
    }

    @PostMapping("home/weather/")
    public String getWeather(@RequestParam String latitude, @RequestParam String longitude, Model model) {
        try {
            double lat = Double.parseDouble(latitude);
            double lon = Double.parseDouble(longitude);

            // Validações de faixa
            if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
                model.addAttribute("errorMessage", "A latitude deve estar na faixa de -90 a 90° e a longitude entre -180 a 180°");
                return "weatherPage";
            }

            String weatherDataJson = apiServiceWeather.getWeather(lat, lon);

            if (weatherDataJson.equals("offline")) {
                model.addAttribute("errorMessage", "Serviços fora do ar, tente novamente mais tarde.");
                return "weatherPage";
            }

            WeatherResponse weatherResponse = WeatherResponse.fromJson(weatherDataJson);

            if (weatherResponse == null || weatherResponse.hourly == null) {
                model.addAttribute("errorMessage", "Erro ao obter dados climáticos.");
                return "weatherPage";
            }

            List<WeatherDisplay> weatherDisplayList = new ArrayList<>();
            for (int i = 0; i < weatherResponse.hourly.time.size(); i++) {
                WeatherDisplay display = new WeatherDisplay(
                        weatherResponse.hourly.time.get(i),
                        weatherResponse.hourly.temperature.get(i)
                );
                weatherDisplayList.add(display);
            }

            // Salvar dados em arquivo
            fileService.saveDataToFile(weatherDataJson ,lat, lon); // Salva a temperatura da primeira hora

            model.addAttribute("weatherData", weatherDisplayList);
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Por favor, insira valores numéricos válidos para latitude e longitude.");
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            model.addAttribute("errorMessage", "Erro ao processar a solicitação.");
        }

        return "weatherPage";
    }
}
