package com.example.midtermproject.Model;

import androidx.transition.Visibility;

public class ModelCoffeeOrder extends ModelCoffee {
    private int size;
    private boolean shot;
    private int ice;
    private int quantity;
    private boolean select;

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
