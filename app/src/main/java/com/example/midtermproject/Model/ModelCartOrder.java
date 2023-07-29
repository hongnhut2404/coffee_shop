package com.example.midtermproject.Model;

import java.util.ArrayList;

public class ModelCartOrder {
    private ArrayList<ModelCoffeeOrder> listModelCoffeeOrder;
    private Date time;
    private String address;

    public ModelCartOrder() {
    }

    public ModelCartOrder(ArrayList<ModelCoffeeOrder> listModelCoffeeOrder, Date time, String address) {
        this.listModelCoffeeOrder = listModelCoffeeOrder;
        this.time = time;
        this.address = address;
    }

    public ArrayList<ModelCoffeeOrder> getListModelCoffeeOrder() {
        return listModelCoffeeOrder;
    }

    public void setListModelCoffeeOrder(ArrayList<ModelCoffeeOrder> listModelCoffeeOrder) {
        this.listModelCoffeeOrder = listModelCoffeeOrder;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
