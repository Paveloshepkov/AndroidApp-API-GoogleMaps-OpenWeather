package com.example.tewotv0.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.example.tewotv0.models.hotelModels.hotelsCoordinate.Hotel;
import com.example.tewotv0.models.hotelModels.hotelsCoordinate.HotelCoordinateModel;
import com.example.tewotv0.models.hotelModels.hotelPrice.HotelPriceModel;
import com.example.tewotv0.models.weatherModels.forecastModels.ForecastWeatherModel;
import com.example.tewotv0.models.weatherModels.forecastModels.WeatherDay;
import com.example.tewotv0.models.weatherModels.todayWeather.Weather;
import com.example.tewotv0.models.weatherModels.todayWeather.TodayWeatherModel;
import com.example.tewotv0.R;
import com.example.tewotv0.Templates.utilit.ApiHotelHelper;
import com.example.tewotv0.Templates.utilit.ServiceFactory;
import com.google.android.gms.maps.model.LatLng;
import com.example.tewotv0.Templates.Interfaces.HotelsService;
import com.example.tewotv0.Templates.Interfaces.WeatherService;
import com.google.android.gms.tasks.Task;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditTextBox;
    private static String API_KEY_FROM_WEATHER;
    private static String DEFAULT_METRICS;
    private static String WEATHER_URL;
    private static String AVIASALES_URL;
    private static String AVIASALES_API_KEY;
    private TodayWeatherModel weatherResponse;
    private List<HotelPriceModel> hotelPriceModelList;
    private List<LatLng> coordinateHotelsList;
    private ForecastWeatherModel forecastWeatherModel;
    private String cityName;
    private ApiHotelHelper apiHotelHelper;
    public static final String TAG = "Successfull";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        API_KEY_FROM_WEATHER = this.getResources().getString(R.string.apiKeyFromWeather);
        WEATHER_URL = this.getResources().getString(R.string.urlFromWeather);
        DEFAULT_METRICS = this.getResources().getString(R.string.defaultMetrics);
        AVIASALES_URL = this.getResources().getString(R.string.urlAviasales);
        AVIASALES_API_KEY = this.getResources().getString(R.string.apiKeyFromAviasales);

        searchEditTextBox = findViewById(R.id.cityNameTextBox);

        init();
    }
    @Override
    public void onBackPressed() {
        openQuitDialog();
    }
    private void init() {
        forecastWeatherModel= new ForecastWeatherModel();
        coordinateHotelsList = new ArrayList<>();

        apiHotelHelper = new ApiHotelHelper(AVIASALES_URL, this, AVIASALES_API_KEY);

        searchEditTextBox.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH
                    || actionId == EditorInfo.IME_ACTION_DONE
                    || event.getAction() == KeyEvent.ACTION_DOWN
                    || event.getAction() == KeyEvent.KEYCODE_ENTER) {

                hideKeyboard();

                cityName = searchEditTextBox.getText().toString();
                if (!cityName.equals("") && cityName.length() > 3) {
                    getWeatherInCity();
                    getHotelPriceModelList(cityName, "2019-03-01", "2019-05-10", 1, 100);
                }
            }
            return false;
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(searchEditTextBox.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                this);
        quitDialog.setTitle("Exit?");

        quitDialog.setPositiveButton("Yes.", (dialog, which) -> {
            // TODO Auto-generated method stub
            android.os.Process.killProcess(android.os.Process.myPid());
        });

        quitDialog.setNegativeButton("No.", (dialog, which) -> {
        });
        quitDialog.show();
    }
    public void googleMapsButtonClick(View view) {
        try {
            GoogleMapsActivity.setHotelsInCity(hotelPriceModelList);
            GoogleMapsActivity.setHotelsCoordinateList(coordinateHotelsList);
            Intent intent = new Intent(this, GoogleMapsActivity.class);
            this.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void weatherButtonClick(View view) {
        try {
            String str = "";
            for (Weather weather : weatherResponse.getWeather()) {
                str = weather.getIcon();
            }
            Wactivity.setWeatherObject(weatherResponse);
            Wactivity.setWeatherIcons(str);
            ForecastActivity.setForecastWeatherModel(forecastWeatherModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, Wactivity.class);
        this.startActivity(intent);
    }

    @SuppressLint("CheckResult")
    private void getWeatherInCity() {
        WeatherService service = (WeatherService) ServiceFactory.getServiceObject(
                WEATHER_URL,
                getApplicationContext()
        );
        Single<TodayWeatherModel> call = service.getCurrentWeatherDataByNameRx(
                cityName,
                API_KEY_FROM_WEATHER,
                DEFAULT_METRICS
        );
        initOfWeatherInOneDay(call);
        Observable<ForecastWeatherModel> forecastCall
                = service.getForecastWeatherByName(cityName, API_KEY_FROM_WEATHER, DEFAULT_METRICS, 5);
        initOfForecastWeather(forecastCall);
    }

    @SuppressLint("CheckResult")
    private void initOfForecastWeather(Observable<ForecastWeatherModel> forecastObservable) {
        forecastWeatherModel = new ForecastWeatherModel();

        forecastObservable.subscribeOn(Schedulers.io())
                .subscribe(forecast -> {
                    this.forecastWeatherModel = forecast;
                    for(WeatherDay weatherDay : forecastWeatherModel.getItems()){
                        Log.d(TAG, weatherDay.getDate().getTime().toString()+":"+ weatherDay.getIconUrl());
                    }
                }, Throwable::printStackTrace);
    }

    @SuppressLint("CheckResult")
    private void initOfWeatherInOneDay(Single<TodayWeatherModel> weatherObservable) {
        weatherResponse = new TodayWeatherModel();

        weatherObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TodayWeatherModel>() {
                    @Override
                    public void onSuccess(TodayWeatherModel todayWeatherModel) {
                        weatherResponse = todayWeatherModel;
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
    @SuppressLint("CheckResult")
    private void getHotelPriceModelList(String cityName, String firstDate, String secondDate, int adults, int limited) {
        HotelsService hotelsService = (HotelsService) ServiceFactory.getServiceObject(AVIASALES_URL, getApplicationContext());
        Observable<List<HotelPriceModel>> call = hotelsService.getHotelsInCity(
                cityName,
                firstDate,
                secondDate,
                adults,
                limited,
                AVIASALES_API_KEY
        );
        call.subscribeOn(Schedulers.io())
                .subscribe(posts -> {
                    hotelPriceModelList = posts;
                    Log.d(TAG, "getHotelPriceModelList: успешно");
                    getHotelCoordinate();
                    Log.d(TAG, "getHotelCoordinate: успешно");
                }, Throwable::printStackTrace);
    }

    //Мусор на переделку
    private void getHotelCoordinate() {
        coordinateHotelsList = new ArrayList<>();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AVIASALES_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            HotelsService hotelsService = retrofit.create(HotelsService.class);
            for (HotelPriceModel hotelPriceModel : hotelPriceModelList) {
                Call<HotelCoordinateModel> call = hotelsService.getHotelCoordinate(
                        hotelPriceModel.getHotelId().toString(),
                        "hotel",
                        1,
                        AVIASALES_API_KEY
                );
                call.enqueue(new Callback<HotelCoordinateModel>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(@NonNull Call<HotelCoordinateModel> call, @NonNull Response<HotelCoordinateModel> response) {
                        HotelCoordinateModel hotelCoordinateModel = response.body();
                        assert hotelCoordinateModel != null;

                        for (Hotel hotel : hotelCoordinateModel.getResults().getHotels()) {
                            if (hotel.getLabel() != null && hotel.getLocation().getLon() != null && hotel.getLocation().getLat() != null) {
                                coordinateHotelsList.add(new LatLng(
                                        hotel.getLocation().getLat(),
                                        hotel.getLocation().getLon()));
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<HotelCoordinateModel> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}

