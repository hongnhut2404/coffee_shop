package com.example.midtermproject;

import com.example.midtermproject.Adapter.AdapterCartOrderOnGoing;
import com.example.midtermproject.Model.ModelCartOrder;
import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.Model.ModelCoffeeOrder;
import com.example.midtermproject.Model.ModelRewardHistory;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class AppController {
    public static ArrayList<ModelCoffee> listModelCoffee = new ArrayList<>();
    public static ArrayList<ModelRewardHistory> listModelRewardHistory = new ArrayList<>();
    public static ArrayList<ModelCoffeeOrder> listModelCoffeeOrder = new ArrayList<>();
    public static ArrayList<ModelCartOrder> listModelCartOrder = new ArrayList<>();

    public static ArrayList<ModelCartOrder> listModelCartOrderHistory = new ArrayList<>();

    public static int getTotalRedeemPoints()
    {
        int totalRedeemPoints = 0;
        for (int i = 0; i < listModelRewardHistory.size(); i++)
        {
            totalRedeemPoints+= listModelRewardHistory.get(i).getPoints();
        }
        return totalRedeemPoints;
    }



}
