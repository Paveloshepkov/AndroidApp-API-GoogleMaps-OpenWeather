package com.example.tewotv0.models.hotelModels.hotelPrice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;

    /**
     * No args constructor for use in serialization
     */
    public Geo() {
    }

    /**
     * @param lon
     * @param lat
     */
    public Geo(Double lat, Double lon) {
        super();
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
