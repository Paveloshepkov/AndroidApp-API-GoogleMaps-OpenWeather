package com.example.tewotv0.models.hotelModels.hotelsCoordinate;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hotel {

    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("_score")
    @Expose
    private Double score;
    @SerializedName("locationName")
    @Expose
    private String locationName;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("locationId")
    @Expose
    private Integer locationId;
    @SerializedName("location")
    @Expose
    private Location location;

    /**
     * No args constructor for use in serialization
     *
     */
    public Hotel() {
    }

    /**
     *
     * @param id
     * @param location
     * @param locationId
     * @param score
     * @param label
     * @param locationName
     * @param fullName
     */
    public Hotel(String fullName, Double score, String locationName, String label, String id, Integer locationId, Location location) {
        super();
        this.fullName = fullName;
        this.score = score;
        this.locationName = locationName;
        this.label = label;
        this.id = id;
        this.locationId = locationId;
        this.location = location;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
