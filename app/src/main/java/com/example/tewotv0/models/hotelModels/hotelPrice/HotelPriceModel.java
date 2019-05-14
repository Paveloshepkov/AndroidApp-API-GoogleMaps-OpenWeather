package com.example.tewotv0.models.hotelModels.hotelPrice;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelPriceModel {
    @SerializedName("priceFrom")
    @Expose
    private double priceFrom;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("locationId")
    @Expose
    private double locationId;
    @SerializedName("priceAvg")
    @Expose
    private double priceAvg;
    @SerializedName("hotelName")
    @Expose
    private String hotelName;
    @SerializedName("stars")
    @Expose
    private Integer stars;
    @SerializedName("pricePercentile")
    @Expose
    private PricePercentile pricePercentile;
    @SerializedName("hotelId")
    @Expose
    private Integer hotelId;

    /**
     * No args constructor for use in serialization
     *
     */
    public HotelPriceModel() {
    }

    /**
     *
     * @param priceFrom
     * @param hotelName
     * @param location
     * @param stars
     * @param locationId
     * @param priceAvg
     * @param hotelId
     * @param pricePercentile
     */
    public HotelPriceModel(Integer priceFrom, Location location, Integer locationId, Integer priceAvg, String hotelName, Integer stars, PricePercentile pricePercentile, Integer hotelId) {
        super();
        this.priceFrom = priceFrom;
        this.location = location;
        this.locationId = locationId;
        this.priceAvg = priceAvg;
        this.hotelName = hotelName;
        this.stars = stars;
        this.pricePercentile = pricePercentile;
        this.hotelId = hotelId;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Integer priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public double getPriceAvg() {
        return priceAvg;
    }

    public void setPriceAvg(Integer priceAvg) {
        this.priceAvg = priceAvg;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public PricePercentile getPricePercentile() {
        return pricePercentile;
    }

    public void setPricePercentile(PricePercentile pricePercentile) {
        this.pricePercentile = pricePercentile;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

}
