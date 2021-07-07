package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class Region {

    @SerializedName("ID")
    public String id;
    @SerializedName("LocalizedName")
    public String localizedName;
    @SerializedName("EnglishName")
    public String englishName;

    public String getId() {
        return id;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getEnglishName() {
        return englishName;
    }
}
