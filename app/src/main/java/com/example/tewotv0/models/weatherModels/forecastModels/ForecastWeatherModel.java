package com.example.tewotv0.models.weatherModels.forecastModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastWeatherModel {
    @SerializedName("list")
    private List<WeatherDay> items;
    public ForecastWeatherModel(){}
    public ForecastWeatherModel(List<WeatherDay> items) {
        this.items = items;
    }

    public List<WeatherDay> getItems() {
        return items;
    }
}
