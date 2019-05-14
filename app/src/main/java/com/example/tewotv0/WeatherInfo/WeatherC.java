package com.example.tewotv0.WeatherInfo;
import com.example.tewotv0.models.weatherModels.todayWeather.TodayWeatherModel;

public class WeatherC {
    public interface View {
        void showWeather(TodayWeatherModel todayWeather);

        void showIcon(String imageName);
    }

    public interface Presenter {
        void setWeatherOnView(String cityName);

        void onDestroy();
    }

    public interface Repository {
        TodayWeatherModel loadWeather(String cityName);

        void onDestroy();
    }
}
