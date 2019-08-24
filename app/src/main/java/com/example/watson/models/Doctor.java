package com.example.watson.models;

import com.google.gson.annotations.SerializedName;

public class Doctor {

    @SerializedName("name")
    private String mName;

    @SerializedName("surname")
    private String mSurname;

    @SerializedName("avatar")
    private String mAvatar;

    @SerializedName("position")
    private String mType;

    @SerializedName("visit_cost")
    private String mPrice;

    public Doctor() {
    }

    public Doctor(String name, String surname, String avatar, String type, String price) {
        mName = name;
        mSurname = surname;
        mAvatar = avatar;
        mType = type;
        mPrice = price;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }
}
