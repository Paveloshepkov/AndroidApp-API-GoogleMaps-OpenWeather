package com.example.tewotv0.WeatherInfo.Presentor;

import android.util.Log;
import com.example.tewotv0.WeatherInfo.WeatherC;
import com.example.tewotv0.WeatherInfo.Retention.WeatherRepository;
import com.example.tewotv0.models.weatherModels.todayWeather.TodayWeatherModel;
import com.example.tewotv0.models.weatherModels.todayWeather.Weather;

public class WeatherPresenter implements WeatherC.Presenter {

    private static final String TAG = "WeatherPresenter";
    private WeatherC.Repository mRepository;
    private WeatherC.View mView;

    public WeatherPresenter(WeatherC.View mView) {
        this.mRepository = (WeatherC.Repository) new WeatherRepository();
        this.mView = mView;
    }
    @Override
    public void setWeatherOnView(String cityName) {
        TodayWeatherModel todayWeather = mRepository.loadWeather(cityName);
        mView.showWeather(todayWeather);
        String str = "";
        for (Weather weather : todayWeather.getWeather()) {
            str = weather.getIcon();
        }
        mView.showIcon(str);
    }
    @Override
    public void onDestroy() {
        mRepository.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
