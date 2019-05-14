package com.example.tewotv0.models.weatherModels.forecastModels;


import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

public class WeatherDay {

    public class Temp {
        @SerializedName("day")
        Double day;
        @SerializedName("min")
        Double temp_min;
        @SerializedName("max")
        Double temp_max;
        @SerializedName("night")
        Double temp_night;
        public Temp( Double day,Double temp_min,Double temp_max,Double temp_night){
            this.day=day;
            this.temp_max=temp_max;
            this.temp_min=temp_min;
            this.temp_night=temp_night;
        }
    }

    public class WeatherDescription {
        String icon;
    }

    @SerializedName("temp")
    private Temp temp;

    @SerializedName("weather")
    private List<WeatherDescription> desctiption;

    @SerializedName("name")
    private String city;

    @SerializedName("dt")
    private long timestamp;

    public WeatherDay(Temp temp, List<WeatherDescription> desctiption) {
        this.temp = temp;
        this.desctiption = desctiption;
    }

    public Calendar getDate() {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(timestamp * 1000);
        return date;
    }

    public String getNightTemp() {
        return String.valueOf(temp.temp_night);
    }

    public String getTemp() {
        return String.valueOf(temp.day);
    }

    public String getTempMin() {
        return String.valueOf(temp.temp_min);
    }

    public String getTempMax() {
        return String.valueOf(temp.temp_max);
    }

    public String getTempInteger() {
        return String.valueOf(temp.day.intValue());
    }

    public String getTempWithDegree() {
        return String.valueOf(temp.day.intValue()) + "\u00B0";
    }

    public String getCity() {
        return city;
    }

    public String getIcon() {
        return desctiption.get(0).icon;
    }

    public String getIconUrl() {
        return "http://openweathermap.org/img/w/" + desctiption.get(0).icon + ".png";
    }
}