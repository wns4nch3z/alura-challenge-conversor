package com.conversor.model;

import com.google.gson.annotations.SerializedName;

public class ConversionRespuesta {
    @SerializedName("conversion_rate")
    private double conversionRate;


    // Getters y Setters
    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "ConversionResponse: " + conversionRate;

    }
}
