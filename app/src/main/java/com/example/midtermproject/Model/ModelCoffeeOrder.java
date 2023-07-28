package com.example.midtermproject.Model;

import androidx.transition.Visibility;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ModelCoffeeOrder extends ModelCoffee {
    private int size;
    private boolean shot;
    private int ice;
    private int quantity;
    private boolean select;



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
        strShot.add("stay");
        strShot.add("away");

        int shotIndex;
        int selectIndex;

        if (shot) shotIndex = 0; else shotIndex = 1;
        if (select) selectIndex = 0; else selectIndex = 1;

        String attribute = strSize.get(size) + "|" + strIce.get(ice) + "|" + strShot.get(shotIndex) + "|" + strSelect.get(selectIndex);
        return attribute;
    }

    public ModelCoffeeOrder() {
    }

    public ModelCoffeeOrder(int size, boolean shot, int ice, boolean select, int quantity) {
        this.size = size;
        this.shot = shot;
        this.ice = ice;
        this.select = select;
        this.quantity = quantity;
    }


    public ModelCoffeeOrder(String coffeeID, String coffeeName, String imageURL, int price, int redeemPoint, int size, boolean shot, int ice, int quantity, boolean select) {
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

    public boolean isShot() {
        return shot;
    }

    public void setShot(boolean shot) {
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

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
