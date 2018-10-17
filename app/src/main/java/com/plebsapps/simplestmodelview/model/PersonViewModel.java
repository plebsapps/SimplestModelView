package com.plebsapps.simplestmodelview.model;

import android.arch.lifecycle.ViewModel;

public class PersonViewModel extends ViewModel {
    private String vorname;
    private String name;

    public void setPerson(String vorname, String name){
        this.vorname = vorname;
        this.name = name;
    }

    public String sayHello(){
        if (vorname == null && name == null) {
            return "";
        } else if (vorname.isEmpty()) {
            return "Sir/Madam " + name;
        } else if (name.isEmpty()) {
            return "Hi " + vorname;
        } else {
            return "Hello " + vorname + " " + name;
        }
    }
}