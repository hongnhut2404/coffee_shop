package com.example.midtermproject.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModelRewardHistory {
    int points;
    LocalDateTime orderDate;
    String coffeeNameHistoryReward;

    public ModelRewardHistory() {
    }

    public ModelRewardHistory(int points, String coffeeNameHistoryReward) {
        this.points = points;
        this.orderDate = LocalDateTime.now();
        this.coffeeNameHistoryReward = coffeeNameHistoryReward;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getCoffeeNameHistoryReward() {
        return coffeeNameHistoryReward;
    }

    public void setCoffeeNameHistoryReward(String coffeeNameHistoryReward) {
        this.coffeeNameHistoryReward = coffeeNameHistoryReward;
    }

    public String toStringDate()
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = orderDate.format(dateTimeFormatter);
        return formattedDateTime;
    }
}
