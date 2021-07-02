package com.example.mvvmretrofitrecyclerviewpracticejavaversion;

public class Movie {

    private String name;
    private String imageUrl;
    private String category;
    private String desc;

    public Movie(String name, String imageUrl, String category, String desc) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
