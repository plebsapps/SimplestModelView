package com.plebsapps.simplestmodelview.model;

import android.util.Log;

public class PersonInterceptor {

    private String TAG = PersonInterceptor.class.getSimpleName();

    public void intercept(String fullName){
        //do something
        Log.i(TAG, fullName);
    }
}
