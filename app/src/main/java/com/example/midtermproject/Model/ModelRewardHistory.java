package com.example.midtermproject.Model;

public class ModelRewardHistory {
    int points;
    Date orderDate;
    String coffeeNameHistoryReward;

    public ModelRewardHistory() {
    }

    public ModelRewardHistory(int points, Date orderDate, String coffeeNameHistoryReward) {
        this.points = points;
        this.orderDate = orderDate;
        this.coffeeNameHistoryReward = coffeeNameHistoryReward;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCoffeeNameHistoryReward() {
        return coffeeNameHistoryReward;
    }

    public void setCoffeeNameHistoryReward(String coffeeNameHistoryReward) {
        this.coffeeNameHistoryReward = coffeeNameHistoryReward;
    }
}
