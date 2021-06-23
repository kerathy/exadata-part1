package com.example.mvvmarchitecture;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AppViewModel extends BaseObservable {

    private Model model;

    // string variables for
    // toast messages
    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";

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
    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword() {
        return model.getPassword();
    }

    public void setUserPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }


    public AppViewModel() {

        // instantiating object of
        // model class
        model = new Model("","");
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onButtonClicked() {
        if (isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }



}
