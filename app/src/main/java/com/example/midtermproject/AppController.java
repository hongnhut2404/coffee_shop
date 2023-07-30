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

    public static ArrayList<ModelCoffee> listModelCoffeeReddeem = new ArrayList<>();

    public static AdapterCartOrderOnGoing adapterCartOrderOnGoing;
    public static AdapterCartOrderOnGoing adapterCartOrderHistory;

    public static int getTotalRedeemPoints()
    {
        int totalRedeemPoints = 0;
        for (int i = 0; i < listModelRewardHistory.size(); i++)
        {
            totalRedeemPoints+= listModelRewardHistory.get(i).getPoints();
        }
        return totalRedeemPoints;
    }

    public static void removeOnGoing(int position)
    {
        listModelCartOrder.remove(position);
        adapterCartOrderOnGoing.notifyItemRemoved(position);
    }
    public static void addHistory(ModelCartOrder modelCartOrder)
    {
        listModelCartOrderHistory.add(modelCartOrder);
        adapterCartOrderHistory.notifyItemInserted(listModelCartOrderHistory.size()-1);
//        infoHistoryDoneAdapter.notifyDataSetChanged();
    }

    public static void addOnGoing(ModelCartOrder modelCartOrder)
    {
        listModelCartOrder.add(modelCartOrder);
        adapterCartOrderOnGoing.notifyItemInserted(listModelCartOrder.size()-1);
    }


}
