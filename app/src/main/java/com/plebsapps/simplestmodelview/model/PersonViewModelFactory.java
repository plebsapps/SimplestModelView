package com.plebsapps.simplestmodelview.model;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

public class PersonViewModelFactory implements ViewModelProvider.Factory {

    private final PersonInterceptor loggingInterceptor;

    public PersonViewModelFactory(PersonInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(PersonCounterViewModel.class))
            return (T) new PersonCounterViewModel(loggingInterceptor);
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}