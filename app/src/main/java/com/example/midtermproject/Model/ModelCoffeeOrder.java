package com.example.midtermproject.Model;

import androidx.transition.Visibility;

public class ModelCoffeeOrder extends ModelCoffee {
    public enum Size {small, medium, big};
    public enum Shot {singleS, doubleS};
    public enum Ice {one, two, three};
    public enum Temperature {hot, cold};

    private Size size;
    private Shot shot;
    private Ice ice;
    private Temperature temp;

    public ModelCoffeeOrder() {
    }

    public ModelCoffeeOrder(Size size, Shot shot, Ice ice, Temperature temp) {
        this.size = size;
        this.shot = shot;
        this.ice = ice;
        this.temp = temp;
    }

    public ModelCoffeeOrder(String coffeeID, String coffeeName, String imageURL, int price, int redeemPoint, Size size, Shot shot, Ice ice, Temperature temp) {
        super(coffeeID, coffeeName, imageURL, price, redeemPoint);
        this.size = size;
        this.shot = shot;
        this.ice = ice;
        this.temp = temp;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public Ice getIce() {
        return ice;
    }

    public void setIce(Ice ice) {
        this.ice = ice;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }
}
