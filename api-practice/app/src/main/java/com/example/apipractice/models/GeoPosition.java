package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class GeoPosition {

    @SerializedName("Latitude")
    public float latitude;
    @SerializedName("Longitude")
    public float longitude;
    @SerializedName("Elevation")
    public Elevation elevation;


    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Elevation getElevation() {
        return elevation;
    }
}
