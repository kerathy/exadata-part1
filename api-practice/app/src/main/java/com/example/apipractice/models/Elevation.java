package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class Elevation {

    @SerializedName("Metric")
    public Metric metric;
    @SerializedName("Imperial")
    public Imperial imperial;

    public Metric getMetric() {
        return metric;
    }

    public Imperial getImperial() {
        return imperial;
    }
}
