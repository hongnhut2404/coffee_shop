package com.example.midtermproject.Model;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;

public class ModelCoffee implements Serializable{
    @DocumentId
    String coffeeID;
    String coffeeName, imageURL;

    float price;

    public ModelCoffee() {
    }

    public ModelCoffee(String coffeeID, String coffeeName, String imageURL, int price) {
        this.coffeeID = coffeeID;
        this.coffeeName = coffeeName;
        this.imageURL = imageURL;
        this.price = price;
    }

    public String getCoffeeID() {
        return coffeeID;
    }

    public void setCoffeeID(String coffeeID) {
        this.coffeeID = coffeeID;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}