package com.example.tewotv0.Templates.Interfaces;

import com.example.tewotv0.models.hotelModels.hotelPrice.HotelPriceModel;
import com.example.tewotv0.models.hotelModels.hotelsCoordinate.HotelCoordinateModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Интерфейс Сервисов для работы с отелями
 *
 * @author Denis
 * @version 2.1
 */
public interface HotelsService {
    /**
     * Метод запроса получения цены отелей по названию города
     *
     * @param cityName    -  Название города
     * @param checkInDate -  Дата заезда
     * @param checkOut    - Дата выезда
     * @param adults      - Кол-во гостей
     * @param limited     -  Кол-во отелей
     * @return - Возвращает список цен на отели
     */
    @GET("api/v2/cache.json")
    Observable<List<HotelPriceModel>> getHotelsInCity(
            @Query("location") String cityName,
            @Query("checkIn") String checkInDate,
            @Query("checkOut") String checkOut,
            @Query("adults") int adults,
            @Query("limit") int limited,
            @Query("token") String token
    );
    @GET
    Single<HotelCoordinateModel> getHotelsCoordinate(
            @Query("query") String hotelName,
            @Query("lookFor") String lookFor,
            @Query("limit") int limit,
            @Query("token") String token
    );
    /**
     * Метод запроса получения координат отеля по названию отеля
     *
     * @param hotelName - Название отеля
     * @param limit     - Кол-во возвращаемых значений
     * @return - Возвращает координаты отеля с сервера
     */
    @GET("api/v2/lookup.json")
    Call<HotelCoordinateModel> getHotelCoordinate(
            @Query("query") String hotelName,
            @Query("lookFor") String lookFor,
            @Query("limit") int limit,
            @Query("token") String token
    );

}
