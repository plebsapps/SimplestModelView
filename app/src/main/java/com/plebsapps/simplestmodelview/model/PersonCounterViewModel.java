package com.plebsapps.simplestmodelview.model;


public class PersonCounterViewModel extends PersonViewModel{
    private final PersonInterceptor loggingInterceptor;

    public PersonCounterViewModel(PersonInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public void setPerson(String vorname, String name) {
        super.setPerson(vorname, name);
        loggingInterceptor.intercept(vorname + name);
    }
}
