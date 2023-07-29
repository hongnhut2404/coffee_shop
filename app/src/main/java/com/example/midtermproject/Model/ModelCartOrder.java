package com.example.midtermproject.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ModelCartOrder {
    private ArrayList<ModelCoffeeOrder> listModelCoffeeOrder;
    private LocalDateTime time;
    private String address;

    public ModelCartOrder() {
    }

    public ArrayList<ModelCoffeeOrder> getListModelCoffeeOrder() {
        return listModelCoffeeOrder;
    }

    public void setListModelCoffeeOrder(ArrayList<ModelCoffeeOrder> listModelCoffeeOrder) {
        this.listModelCoffeeOrder = listModelCoffeeOrder;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int calculateCartPrice()
    {
        int cartPrice = 0;
        for (int i = 0; i<listModelCoffeeOrder.size(); i++)
        {
            cartPrice += listModelCoffeeOrder.get(i).getTotalPrice();
        }
        return cartPrice;
    }


    public String toStringName()
    {
        String name = "";
        for (int i = 0; i < listModelCoffeeOrder.size(); i++)
        {
            name = listModelCoffeeOrder.get(i).coffeeName + " | ";
        }
        return name;
    }
}
