package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class Imperial {
    @SerializedName("Value")
    public int value;
    @SerializedName("Unit")
    public String unit;
    @SerializedName("UnitType")
    public int unitType;

    public int getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public int getUnitType() {
        return unitType;
    }
}
