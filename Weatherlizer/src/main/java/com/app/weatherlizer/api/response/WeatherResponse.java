package com.app.weatherlizer.api.response;

import com.google.gson.Gson;
import java.util.List;

public class WeatherResponse {
    public Hourly hourly;

    public static class Hourly {
        public List<String> time;
        public List<Double> temperature;
    }

    public static WeatherResponse fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, WeatherResponse.class);
    }
}
