package com.example.srsproject.ui.guestinfo;

public class Model {

    private String email;
    private String title;

    public Model(String email, String title) {
        this.email = email;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
