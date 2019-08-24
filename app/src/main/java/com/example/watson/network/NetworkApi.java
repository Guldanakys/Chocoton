package com.example.watson.network;

import com.example.watson.models.Doctor;
import com.example.watson.models.InsuranceItem;
import com.example.watson.models.Package;
import com.example.watson.models.Restaurant;
import com.example.watson.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface NetworkApi {

    @GET(NetworkConstants.GET_PROFILE_INFO)
    Call<User> getProfileInfo(@Header("Authorization") String token);

    @GET(NetworkConstants.GET_USER_PACKAGE)
    Call<Package> getUserPackage(@Header("Authorization") String token, @Path("id") int id);

    @GET(NetworkConstants.GET_PACKAGE_CATEGORY)
    Call<InsuranceItem> getCategory();

    @GET(NetworkConstants.GET_DOCTORS)
    Call<List<Doctor>> getDoctors(@Header("Authorization") String token);

    @GET(NetworkConstants.GET_DOCTOR)
    Call<Doctor> getDoctor(@Header("Authorization") String token, @Path("id") int id);

}
