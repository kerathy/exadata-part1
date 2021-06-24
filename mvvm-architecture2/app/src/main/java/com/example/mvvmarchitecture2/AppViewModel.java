package com.example.mvvmarchitecture2;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

public class AppViewModel extends BaseObservable {

    private Model model;

    @Bindable
    private String toastMessage;

    @Bindable
    public String getTextPassword() {
        return model.getPassword();
    }

    public void setTextPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.textPassword);
    }

    @Bindable
    public String getTextEmail() {
        return model.getEmail();
    }

    public void setTextEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.textEmail);
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public AppViewModel() {
        model = new Model("", "");
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getTextEmail()) && Patterns.EMAIL_ADDRESS.matcher(getTextEmail()).matches()
                &&getTextPassword().length() > 5;
    }



    public void onClick() {
        if (isValid()) setToastMessage("log in successfully");
        else setToastMessage("invalid username or password");
    }

}
