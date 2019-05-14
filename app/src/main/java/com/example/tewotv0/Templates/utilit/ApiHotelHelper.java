package com.example.tewotv0.Templates.utilit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import com.example.tewotv0.models.hotelModels.hotelPrice.HotelPriceModel;
import com.example.tewotv0.models.hotelModels.hotelsCoordinate.Hotel;
import com.example.tewotv0.models.hotelModels.hotelsCoordinate.HotelCoordinateModel;
import com.example.tewotv0.Templates.Interfaces.HotelsService;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import com.google.android.gms.maps.model.LatLng;

public class ApiHotelHelper {
    private static final String TAG = "ApiHotelHelper";
    private String AVIASALES_URL;
    private String AVIASALES_API_KEY;

    private HotelsService hotelsService;

    private List<HotelPriceModel> hotelPriceModelList;

    public ApiHotelHelper(String AVIASALES_URL, Activity activity, String AVIASALES_API_KEY) {
        this.AVIASALES_API_KEY = AVIASALES_API_KEY;
        this.AVIASALES_URL = AVIASALES_URL;
        hotelsService = (HotelsService) ServiceFactory.getServiceObject(AVIASALES_URL, activity.getApplicationContext());
    }

    @SuppressLint("CheckResult")
    public void getHotelsNameAndPrice(String cityName, String firstDate, String secondDate, int adults, int limited) {

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
                    if (posts != null) {
                        hotelPriceModelList= posts;
                        Log.d(TAG, "getHotelPriceModelList: успешно");
                    } else {
                        Log.d(TAG, "getHotelPriceModelList: безуспешно");
                    }
                }, Throwable::printStackTrace);
    }

    public List<LatLng> getHotelsCoordinate(List<HotelPriceModel> hotelPriceModelList) {

        List<LatLng> coordinateHotelsList = new ArrayList<>();

        for (HotelPriceModel hotelPriceModel : hotelPriceModelList) {
            for (Hotel hotel : getOneHotelObject(hotelPriceModel.getHotelName()).getResults().getHotels()) {
                if (hotel.getLabel() != null && hotel.getLocation().getLon() != null && hotel.getLocation().getLat() != null) {
                    coordinateHotelsList.add(new LatLng(
                            hotel.getLocation().getLat(),
                            hotel.getLocation().getLon()));
                    Log.d(TAG, "getHotelsCoordinate: успешно");
                }
            }
        }
        return coordinateHotelsList;
    }

    @SuppressLint("CheckResult")
    private HotelCoordinateModel getOneHotelObject(String cityName) {

        final HotelCoordinateModel[] hotModel = new HotelCoordinateModel[1];

        Single<HotelCoordinateModel> hotelCoordinateModelSingle = hotelsService.getHotelsCoordinate(
                cityName,
                "hotel",
                1,
                AVIASALES_API_KEY
        );
        hotelCoordinateModelSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<HotelCoordinateModel>() {
                    @Override
                    public void onSuccess(HotelCoordinateModel hotelCoordinateModel) {
                        hotModel[0] = hotelCoordinateModel;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        return hotModel[0];
    }

    public List<HotelPriceModel> getHotelPriceModelList() {
        return hotelPriceModelList;
    }
}
