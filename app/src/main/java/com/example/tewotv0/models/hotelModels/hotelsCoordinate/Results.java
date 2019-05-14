package com.example.tewotv0.models.hotelModels.hotelsCoordinate;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("locations")
    @Expose
    private List<Location> locations = null;
    @SerializedName("hotels")
    @Expose
    private List<Hotel> hotels = null;
    @SerializedName("status")
    @Expose
    private String status;
    /**
     * No args constructor for use in serialization
     *
     */
    public Results() {
    }

    /**
     *
     * @param locations
     * @param hotels
     */
    public Results(List<Location> locations, List<Hotel> hotels) {
        super();
        this.locations = locations;
        this.hotels = hotels;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

}
