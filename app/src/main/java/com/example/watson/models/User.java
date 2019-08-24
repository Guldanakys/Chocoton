package com.example.watson.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("surname")
    private String mSurname;

    @SerializedName("iin")
    private String mIin;

    @SerializedName("balance")
    private String mBalance;

    @SerializedName("avatar")
    private String mAvatar;

    @SerializedName("insurance_package")
    private int mPackage;

    public User() {
    }

    public User(int id, String name, String surname, String iin, String balance, String avatar, int aPackage) {
        mId = id;
        mName = name;
        mSurname = surname;
        mIin = iin;
        mBalance = balance;
        mAvatar = avatar;
        mPackage = aPackage;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public String getIin() {
        return mIin;
    }

    public void setIin(String iin) {
        mIin = iin;
    }

    public String getBalance() {
        return mBalance;
    }

    public void setBalance(String balance) {
        mBalance = balance;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public int getPackage() {
        return mPackage;
    }

    public void setPackage(int aPackage) {
        mPackage = aPackage;
    }
}
