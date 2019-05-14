package com.example.tewotv0.Templates.Interfaces;


import com.example.tewotv0.models.weatherModels.forecastModels.ForecastWeatherModel;
import com.example.tewotv0.models.weatherModels.todayWeather.TodayWeatherModel;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Интерфейс Сервисов для работы с отелями
 *
 * @author Denis
 * @version 1.0
 */
public interface WeatherService {

    /**
     * Запрос получения погоды по названию города
     * на сегодня
     *
     * @param cityName - Название города
     * @param appId    - Api ключ погоды
     * @param units    - Единицы измерения
     * @return - Возвращает объект погоды с сервера
     */
    @GET("weather")
    Single<TodayWeatherModel> getCurrentWeatherDataByNameRx(
            @Query("q") String cityName,
            @Query("appid") String appId,
            @Query("units") String units
    );

    /**
     * Запрос получения погоды по названию города
     * на 5 дней
     *
     * @param cityName - Название города
     * @param appId    - Api ключ погоды
     * @param units    - Единицы измерения
     * @return Возврашает список погоды
     */
    @GET("forecast/daily")
    Observable<ForecastWeatherModel> getForecastWeatherByName(
            @Query("q") String cityName,
            @Query("appid") String appId,
            @Query("units") String units,
            @Query("cnt") int cnd
    );
}