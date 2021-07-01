package com.example.srsproject.ui.guestinfo;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.srsproject.BR;

public class GuestViewModel extends BaseObservable {

    private Model model;

    public GuestViewModel() {
        model = new Model("", "");
    }

    @Bindable
    public String getTextEmail() {
        return model.getEmail();
    }

    public void setTextEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.textEmail);
    }

    @Bindable
    public String getTextTitle() {
        return model.getTitle();
    }

    public void setTextTitle(String title) {
        model.setTitle(title);
        notifyPropertyChanged(BR.textTitle);
    }


    public void onSubmitButtonClick(View view) {
        System.out.println("getEmail: " + getTextEmail());
        System.out.println("getTitle: " + getTextTitle());
    }

}
