package com.example.apipractice.models;

import com.google.gson.annotations.SerializedName;

public class TopCitiesResponse {

    @SerializedName("Version")
    public int version;

    @SerializedName("Key")
    public String key;

    @SerializedName("Type")
    public String type;
    @SerializedName("Rank")
    public int rank;
    @SerializedName("LocalizedName")
    public String localizedName;
    @SerializedName("EnglishName")
    public String englishName;
    @SerializedName("PrimaryPostalCode")
    public String primaryPostalCode;

    @SerializedName("Region")
    public Region region;

    @SerializedName("Country")
    public Country country;

    @SerializedName("AdministrativeArea")
    public AdministrativeArea administrativeArea;

    @SerializedName("TimeZone")
    public TimeZone timeZone;

    @SerializedName("GeoPosition")
    public GeoPosition geoPosition;

    public int getVersion() {
        return version;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public int getRank() {
        return rank;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPrimaryPostalCode() {
        return primaryPostalCode;
    }

    public Region getRegion() {
        return region;
    }

    public Country getCountry() {
        return country;
    }

    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }
}















