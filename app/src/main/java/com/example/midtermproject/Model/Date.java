package com.example.midtermproject.Model;

public class Date {
    int day;
    String month;
    int hour;
    int min;

    public Date() {
    }

    public Date(int day, String month, int hour, int min) {
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.min = min;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
