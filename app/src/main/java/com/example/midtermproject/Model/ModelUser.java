package com.example.midtermproject.Model;

import javax.inject.Singleton;

public class  ModelUser {

    private static ModelUser modelUserInstance = null;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    public ModelUser() {
    }

    public static ModelUser getInstance(String fullName, String phoneNumber, String email, String address){
        if (modelUserInstance == null)
            modelUserInstance = new ModelUser(fullName, phoneNumber, email, address);
        return modelUserInstance;

    }

    private ModelUser(String fullName, String phoneNumber, String email, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
