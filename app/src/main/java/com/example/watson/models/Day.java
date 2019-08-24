package com.example.watson.models;

public class Day {

    private String mNumber;

    private String mWeek;

    public Day() {
    }

    public Day(String number, String week) {
        mNumber = number;
        mWeek = week;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public String getWeek() {
        return mWeek;
    }

    public void setWeek(String week) {
        mWeek = week;
    }
}
