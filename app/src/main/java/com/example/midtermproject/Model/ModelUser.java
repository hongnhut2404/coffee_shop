package com.example.midtermproject.Model;

import javax.inject.Singleton;

public class  ModelUser {

    private static ModelUser modelUserInstance = null;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    private String password;

    private ModelUser() {
    }

    public static ModelUser getInstance(){
        if (modelUserInstance == null)
            modelUserInstance = new ModelUser();
        return modelUserInstance;

    }

    public ModelUser(String fullName, String phoneNumber, String email, String address, String password) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
