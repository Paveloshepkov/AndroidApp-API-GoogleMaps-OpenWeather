package com.example.tewotv0.models.hotelModels.hotelsCoordinate;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param lon
     * @param lat
     */
    public Location(Double lon, Double lat) {
        super();
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}