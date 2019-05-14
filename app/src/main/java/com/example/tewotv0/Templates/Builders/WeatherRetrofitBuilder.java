package com.example.tewotv0.Templates.Builders;

import com.example.tewotv0.Templates.Interfaces.IServiceBuilder;
import com.example.tewotv0.Templates.Interfaces.WeatherService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRetrofitBuilder implements IServiceBuilder<WeatherService> {

    @Override
    public WeatherService createService(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(WeatherService.class);
    }
}