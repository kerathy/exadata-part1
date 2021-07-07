package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class AdministrativeArea {

    @SerializedName("ID")
    public String id;
    @SerializedName("LocalizedName")
    public String localizedName;
    @SerializedName("EnglishName")
    public String englishName;
    @SerializedName("Level")
    public int level;
    @SerializedName("LocalizedType")
    public String localizedType;
    @SerializedName("EnglishType")
    public String englishType;
    @SerializedName("CountryID")
    public String countryID;


    public String getId() {
        return id;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public int getLevel() {
        return level;
    }

    public String getLocalizedType() {
        return localizedType;
    }

    public String getEnglishType() {
        return englishType;
    }

    public String getCountryID() {
        return countryID;
    }
}
