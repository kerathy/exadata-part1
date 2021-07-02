package com.example.srsproject;

import android.graphics.drawable.Drawable;

public class HotelModel {

    private int availableRooms;
    private int price;
    private int resid;

    public HotelModel(int availableRooms, int price, int resid) {
        this.availableRooms = availableRooms;
        this.price = price;
        this.resid = resid;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }
}
