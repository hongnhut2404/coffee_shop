package com.example.midtermproject.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ModelCartOrder {
    private ArrayList<ModelCoffeeOrder> listModelCoffeeOrder = new ArrayList<>();
    private LocalDateTime time;
    private String address;

    public ModelCartOrder(ModelCartOrder modelCartOrder)
    {
        this.listModelCoffeeOrder = new ArrayList<>(modelCartOrder.listModelCoffeeOrder);
        this.time = modelCartOrder.time;
        this.address = modelCartOrder.address;
    }

    public ModelCartOrder(ArrayList<ModelCoffeeOrder> listModelCoffeeOrder, LocalDateTime time, String address) {
        this.listModelCoffeeOrder = new ArrayList<>(listModelCoffeeOrder);
        this.time = time;
        this.address = address;
    }

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

    public void setTime() {
        this.time = LocalDateTime.now();
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
            name += listModelCoffeeOrder.get(i).coffeeName + " | ";
        }
        return name;
    }

    public String toStringDate()
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = time.format(dateTimeFormatter);
        return formattedDateTime;
    }
}
