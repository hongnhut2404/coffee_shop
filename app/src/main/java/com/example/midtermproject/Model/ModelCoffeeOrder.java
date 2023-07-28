package com.example.midtermproject.Model;

import androidx.transition.Visibility;

import org.checkerframework.checker.units.qual.A;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelCoffeeOrder extends ModelCoffee implements Serializable {
    private int size;
    private int shot;
    private int ice;
    private int quantity;
    private int select;



    public String toStringAttribute()
    {
        ArrayList<String> strSize = new ArrayList<>();
        strSize.add("small");
        strSize.add("medium");
        strSize.add("big");
        ArrayList<String> strIce = new ArrayList<>();
        strIce.add("one ice");
        strIce.add("two ice");
        strIce.add("three ice");
        ArrayList<String> strShot = new ArrayList<>();
        strShot.add("single");
        strShot.add("double");
        ArrayList<String> strSelect = new ArrayList<>();
        strSelect.add("stay");
        strSelect.add("away");


        String attribute = strSize.get(size) + "|" + strIce.get(ice) + "|" + strShot.get(shot) + "|" + strSelect.get(select);
        return attribute;
    }

    public ModelCoffeeOrder() {
    }

    public ModelCoffeeOrder(int size, int shot, int ice, int select, int quantity) {
        this.size = size;
        this.shot = shot;
        this.ice = ice;
        this.select = select;
        this.quantity = quantity;
    }


    public ModelCoffeeOrder(String coffeeID, String coffeeName, String imageURL, int price, int redeemPoint, int size, int shot, int ice, int quantity, int select) {
        super(coffeeID, coffeeName, imageURL, price, redeemPoint);
        this.size = size;
        this.shot = shot;
        this.ice = ice;
        this.quantity = quantity;
        this.select = select;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int isShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getIce() {
        return ice;
    }

    public void setIce(int ice) {
        this.ice = ice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int isSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public void setAttribute(ModelCoffee modelCoffee, int size, int shot, int quantity, int ice, int select)
    {
        this.coffeeName = modelCoffee.getCoffeeName();
        this.coffeeID = modelCoffee.getCoffeeID();
        this.price = modelCoffee.getPrice();
        this.imageURL = modelCoffee.getImageURL();
        this.redeemPoint = modelCoffee.getRedeemPoint();
        this.size = size;
        this.shot = shot;
        this.quantity = quantity;
        this.ice = ice;
        this.select = select;
    }
}
