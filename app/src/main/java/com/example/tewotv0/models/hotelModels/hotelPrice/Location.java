package com.example.tewotv0.models.hotelModels.hotelPrice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("geo")
    @Expose
    private Geo geo;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param geo
     * @param name
     * @param state
     * @param country
     */
    public Location(String country, Object state, String name, Geo geo) {
        super();
        this.country = country;
        this.state = state;
        this.name = name;
        this.geo = geo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

}
