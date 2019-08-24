package com.example.watson.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Package {

    @SerializedName("id")
    private int mId;

    @SerializedName("package_name")
    private String mName;

    @SerializedName("categories")
    private List<InsuranceItem> mList;

    public Package() {
    }

    public Package(int id, String name, List<InsuranceItem> list) {
        mId = id;
        mName = name;
        mList = list;
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

    public List<InsuranceItem> getList() {
        return mList;
    }

    public void setList(List<InsuranceItem> list) {
        mList = list;
    }
}
