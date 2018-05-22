package com.fynov.equaleyes.appestimator.data.models;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;

public class CalculatorReturn {
    @SerializedName("total_cost")
    private Double total_cost;
    @SerializedName("android_cost")
    private Double android_cost;
    @SerializedName("ios_cost")
    private Double iOS_cost;
    @SerializedName("backend_cost")
    private Double backend_cost;
    @SerializedName("hourly_rate_day")
    private Double day_rate;

    public CalculatorReturn(Double total_cost, Double android_cost, Double iOS_cost, Double backend_cost, Double day_rate) {
        this.total_cost = total_cost;
        this.android_cost = android_cost;
        this.iOS_cost = iOS_cost;
        this.backend_cost = backend_cost;
        this.day_rate = day_rate;
    }

    public String day_rate(){
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(day_rate);
    }
    public String total(){
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(total_cost);
    }
}
