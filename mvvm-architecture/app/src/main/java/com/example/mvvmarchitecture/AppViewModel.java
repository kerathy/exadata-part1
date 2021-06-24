package com.example.mvvmarchitecture;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AppViewModel extends BaseObservable {

    private Model model;

    // string variables for
    // toast messages

    @Bindable
    // string variable for
    // toast message
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    // getter and setter methods
    // for email varibale
    @Bindable
    public String getTextEmail() {
        return model.getEmail();
    }

    public void setTextEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.textEmail);
    }

    @Bindable
    public String getTextPassword() {
        return model.getPassword();
    }

    public void setTextPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.textPassword);
    }


    public AppViewModel() {

        // instantiating object of
        // model class
        model = new Model("","");
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onclick() {
        if (isValid()) setToastMessage("log in successfully");
        else setToastMessage("email or username is invalid");
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getTextEmail()) && Patterns.EMAIL_ADDRESS.matcher(getTextEmail()).matches()
                && getTextPassword().length() > 5;
    }



}
