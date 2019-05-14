package com.example.tewotv0.models.hotelModels.hotelPrice;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PricePercentile {

    @SerializedName("3")
    @Expose
    private Double _3;
    @SerializedName("10")
    @Expose
    private Double _10;
    @SerializedName("35")
    @Expose
    private Double _35;
    @SerializedName("50")
    @Expose
    private Double _50;
    @SerializedName("75")
    @Expose
    private Double _75;
    @SerializedName("99")
    @Expose
    private Double _99;

    /**
     * No args constructor for use in serialization
     *
     */
    public PricePercentile() {
    }

    /**
     *
     * @param _35
     * @param _99
     * @param _10
     * @param _50
     * @param _3
     * @param _75
     */
    public PricePercentile(Double _3, Double _10, Double _35, Double _50, Double _75, Double _99) {
        super();
        this._3 = _3;
        this._10 = _10;
        this._35 = _35;
        this._50 = _50;
        this._75 = _75;
        this._99 = _99;
    }

    public Double get3() {
        return _3;
    }

    public void set3(Double _3) {
        this._3 = _3;
    }

    public Double get10() {
        return _10;
    }

    public void set10(Double _10) {
        this._10 = _10;
    }

    public Double get35() {
        return _35;
    }

    public void set35(Double _35) {
        this._35 = _35;
    }

    public Double get50() {
        return _50;
    }

    public void set50(Double _50) {
        this._50 = _50;
    }

    public Double get75() {
        return _75;
    }

    public void set75(Double _75) {
        this._75 = _75;
    }

    public Double get99() {
        return _99;
    }

    public void set99(Double _99) {
        this._99 = _99;
    }

}