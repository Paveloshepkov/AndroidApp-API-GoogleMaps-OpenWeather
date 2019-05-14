package com.example.tewotv0.Templates.Builders;

import com.example.tewotv0.Templates.Interfaces.IServiceBuilder;
import com.example.tewotv0.Templates.Interfaces.HotelsService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelsRetrofitBuilder implements IServiceBuilder<HotelsService> {
    @Override
    public HotelsService createService(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(HotelsService.class);
    }
}
