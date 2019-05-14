package com.example.tewotv0.models.hotelModels.hotelsCoordinate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelCoordinateModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private Results results;

    /**
     * No args constructor for use in serialization
     *
     */
    public HotelCoordinateModel() {
    }

    /**
     *
     * @param results
     * @param status
     */
    public HotelCoordinateModel(String status, Results results) {
        super();
        this.status = status;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
