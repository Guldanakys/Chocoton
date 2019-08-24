package com.example.watson.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.watson.network.NetworkConstants.BASE_URL;

public class NetworkConnection {

    private static NetworkConnection sInstance;

    private Retrofit mRetrofit;

    private NetworkConnection() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkConnection getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkConnection();
        }
        return sInstance;
    }

    public NetworkApi getNetworkApi() {
        return mRetrofit.create(NetworkApi.class);
    }

}
