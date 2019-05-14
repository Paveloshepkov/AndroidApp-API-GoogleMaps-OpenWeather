package com.example.tewotv0.WeatherInfo.Retention;
import android.annotation.SuppressLint;
import android.view.View;
import com.example.tewotv0.WeatherInfo.WeatherC;
import com.example.tewotv0.models.weatherModels.todayWeather.TodayWeatherModel;
import com.example.tewotv0.Templates.Interfaces.WeatherService;
import com.example.tewotv0.Templates.utilit.ServiceFactory;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class WeatherRepository implements WeatherC.Repository {

    private View view;
    private String WEATHER_URL;
    private String API_KEY_FROM_WEATHER;
    private String DEFAULT_METRICS;


    public WeatherRepository(View view, String weather_url, String api_key_from_weather, String default_metrics) {
        this.view = view;
        this.WEATHER_URL = weather_url;
        this.API_KEY_FROM_WEATHER = api_key_from_weather;
        this.DEFAULT_METRICS = default_metrics;
    }

    public WeatherRepository() {

    }

    @SuppressLint("CheckResult")
    @Override
    public TodayWeatherModel loadWeather(String cityName) {
        final TodayWeatherModel[] dayWeather = {new TodayWeatherModel()};

        WeatherService service = (WeatherService) ServiceFactory.getServiceObject(
                WEATHER_URL,
                view.getContext()
        );
        Single<TodayWeatherModel> call = service.getCurrentWeatherDataByNameRx(
                cityName,
                API_KEY_FROM_WEATHER,
                DEFAULT_METRICS
        );
        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TodayWeatherModel>() {
                    @Override
                    public void onSuccess(TodayWeatherModel todayWeatherModel) {
                        dayWeather[0] = todayWeatherModel;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
        return dayWeather[0];
    }

    @Override
    public void onDestroy() {
    }
}