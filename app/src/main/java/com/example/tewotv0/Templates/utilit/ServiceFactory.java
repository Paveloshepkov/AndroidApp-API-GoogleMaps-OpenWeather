package com.example.tewotv0.Templates.utilit;

import android.content.Context;
import com.example.tewotv0.R;
import com.example.tewotv0.Templates.Builders.HotelsRetrofitBuilder;
import com.example.tewotv0.Templates.Builders.WeatherRetrofitBuilder;

public class ServiceFactory {

    public static Object getServiceObject(String url, Context context) {
        Object object= null;
        if (!url.equals("")) {
            if (url.equals(context.getResources().getString(R.string.urlAviasales))) {
                object=  new HotelsRetrofitBuilder().createService(url);
            }
            if (url.equals(context.getResources().getString(R.string.urlFromWeather))) {
                object = new WeatherRetrofitBuilder().createService(url);
            }
        }
        return object;
    }
}