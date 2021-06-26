package com.example.retrofit2withandroidjava;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherResponse {

    @SerializedName("coord")
    public Coord coord;

    @SerializedName("sys")
    public Sys sys;

    @SerializedName("weather")
    public ArrayList<Weather> weather;

    @SerializedName("main")
    public Main main;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("rain")
    public Rain rain;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("dt")
    public Float dt;

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("cod")
    public Float cod;

    public Coord getCoord() {
        return coord;
    }

    public Sys getSys() {
        return sys;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Float getDt() {
        return dt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getCod() {
        return cod;
    }
}

class Weather {
    @SerializedName("id")
    public int id;

    @SerializedName("main")
    public String main;

    @SerializedName("description")
    public String description;

    @SerializedName("icon")
    public String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}

class Clouds {
    @SerializedName("all")
    public Float all;

    public Float getAll() {
        return all;
    }
}

class Rain {
    @SerializedName("3h")
    public Float h3;

    public Float getH3() {
        return h3;
    }
}

class Wind {
    @SerializedName("speed")
    public Float speed;

    @SerializedName("deg")
    public Float deg;

    public Float getSpeed() {
        return speed;
    }

    public Float getDeg() {
        return deg;
    }
}



class Main {
    @SerializedName("temp")
    public Float temp;

    @SerializedName("humidity")
    public Float humidity;

    @SerializedName("pressure")
    public Float pressure;

    @SerializedName("temp_min")
    public Float temp_min;

    @SerializedName("temp_max")
    public Float temp_max;

    public Float getTemp() {
        return temp;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public Float getTemp_max() {
        return temp_max;
    }
}

class Sys {
    @SerializedName("country")
    public String country;

    @SerializedName("sunrise")
    public Long sunrise;

    @SerializedName("sunset")
    public Long sunset;

    public String getCountry() {
        return country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }
}

class Coord {
    @SerializedName("lon")
    public Float lon;

    @SerializedName("lat")
    public Float lat;

    public Float getLon() {
        return lon;
    }

    public Float getLat() {
        return lat;
    }
}