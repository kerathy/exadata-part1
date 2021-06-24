package com.example.mvvmarchitecturepractice;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.regex.Pattern;

public class AppViewModel extends BaseObservable {
    private Model model;
    private String toastMessage = null;

    public AppViewModel() {
        model = new Model("", "");
    }

    @Bindable
    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
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
    public String getTextPassword() {
        return model.getPassword();
    }

    public void setTextPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.textPassword);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getTextEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getTextEmail()).matches()&&
                getTextPassword().length() > 5;

    }

    public void onClick() {
       if (isValid()) setToastMessage("Log in successfully");
       else setToastMessage("email or password is invalid");
    }

}
