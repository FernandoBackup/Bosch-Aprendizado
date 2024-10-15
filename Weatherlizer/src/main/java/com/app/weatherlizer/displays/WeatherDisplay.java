package com.app.weatherlizer.displays;

public class WeatherDisplay {
    private String time;       // Hora
    private double temperature; // Temperatura

    // Construtor
    public WeatherDisplay(String time, double temperature) {
        this.time = time;
        this.temperature = temperature;
    }

    // Getters
    public String getTime() {
        return time;
    }

    public double getTemperature() {
        return temperature;
    }
}
