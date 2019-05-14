package com.example.tewotv0.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tewotv0.models.weatherModels.todayWeather.Weather;
import com.example.tewotv0.models.weatherModels.todayWeather.TodayWeatherModel;
import com.example.tewotv0.R;
import com.squareup.picasso.Picasso;
import java.text.DateFormat;
import java.util.Date;

public class Wactivity extends AppCompatActivity {


    private TextView cityField, updateField,
            currentTemperatureField, detailsField, humidityField,
            pressureField;
    private ImageView weatherIcon;

    private static TodayWeatherModel weatherInCity;
    private static String bitmapImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.weathermain_activity);

        cityField = findViewById(R.id.city_field);
        updateField = findViewById(R.id.updated_field);
        weatherIcon = findViewById(R.id.weather_icon);
        currentTemperatureField = findViewById(R.id.current_temperature_field);
        detailsField = findViewById(R.id.details_field);
        humidityField = findViewById(R.id.humidity_field);
        pressureField = findViewById(R.id.pressure_field);
        init();
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void init() {
        initImage();
        initWeatherInfo();
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void initWeatherInfo() {
        try {
            cityField.setText(weatherInCity.getName() + ", " + weatherInCity.getSys().getCountry());
            DateFormat df = DateFormat.getDateTimeInstance();
            updateField.setText(df.format(new Date(weatherInCity.getDt() * 1000)));
            currentTemperatureField.setText(String.format("%.2f", weatherInCity.getMain().getTemp()));
            humidityField.setText("Humidity: " + weatherInCity.getMain().getHumidity() + "%");
            pressureField.setText("Pressure: " + weatherInCity.getMain().getPressure() + " hPa");
            for (Weather weather : weatherInCity.getWeather()) {
                detailsField.setText(weather.getDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initImage() {
        try {
            Picasso.with(this).load("https://openweathermap.org/img/w/" + bitmapImg + ".png").into(weatherIcon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void forecastButton(View view) {
        Intent intent = new Intent(this, ForecastActivity.class);
        this.startActivity(intent);
    }
    public static void setWeatherIcons(String imageName) {
        bitmapImg = imageName;
    }
    public static void setWeatherObject(TodayWeatherModel todayWeatherModel) {
        weatherInCity = todayWeatherModel;
    }

}

