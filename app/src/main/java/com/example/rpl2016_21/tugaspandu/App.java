package com.example.rpl2016_21.tugaspandu;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(this);
    }
}
