package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class TimeZone {

    @SerializedName("Code")
    public String code;
    @SerializedName("Name")
    public String name;
    @SerializedName("GmtOffset")
    public float gmtOffset;
    @SerializedName("IsDaylightSaving")
    public boolean isDaylightSaving;
    @SerializedName("NextOffsetChange")
    public String nextOffsetChange;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getGmtOffset() {
        return gmtOffset;
    }

    public boolean isDaylightSaving() {
        return isDaylightSaving;
    }

    public String getNextOffsetChange() {
        return nextOffsetChange;
    }
}
