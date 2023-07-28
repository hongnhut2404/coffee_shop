package com.example.midtermproject;

import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.Model.ModelCoffeeOrder;
import com.example.midtermproject.Model.ModelRewardHistory;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class AppController {
    public static ArrayList<ModelCoffee> listModelCoffee = new ArrayList<>();
    public static ArrayList<ModelRewardHistory> listModelRewardHistory = new ArrayList<>();
    public static ArrayList<ModelCoffeeOrder> listModelCoffeeOrder = new ArrayList<>();

    public int getCartPrice(ArrayList<ModelCoffeeOrder> listModelCoffeeOrder)
    {
        int totalPrice = 0;
        for (int i = 0; i < listModelCoffeeOrder.size(); i++)
        {
            totalPrice += listModelCoffeeOrder.get(i).getTotalPrice();
        }
        return totalPrice;
    }



}
