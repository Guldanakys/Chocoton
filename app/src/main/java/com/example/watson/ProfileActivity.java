package com.example.watson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watson.adapters.InsuranceItemAdapter;
import com.example.watson.models.InsuranceItem;
import com.example.watson.models.Package;
import com.example.watson.models.User;
import com.example.watson.network.NetworkConnection;
import com.example.watson.network.NetworkConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity implements MyOnClickListener {

    public static final String TAG = "ProfileActivity";

    private ImageView mIvImage;
    private TextView mTvUserName;
    private TextView mTvIin;
    private TextView mTvBalance;
    private ProgressBar mProgressBar;
    private LinearLayout mLayout;

    private RecyclerView mRecyclerView;
    private InsuranceItemAdapter mAdapter;

    private String mToken;
    private int mPackageId;
    private List<InsuranceItem> mInsuranceItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle("Профиль");
        mToken = "token 0b23eea6fa605b9873d081d595b83ad7225f5c16";

        mIvImage = findViewById(R.id.profile_image);
        mTvUserName = findViewById(R.id.profile_username);
        mTvIin = findViewById(R.id.profile_iin);
        mTvBalance = findViewById(R.id.profile_balance);
        mProgressBar = findViewById(R.id.progressbar);
        mLayout = findViewById(R.id.profile_layout);

        loadProfileData();

        mRecyclerView = (RecyclerView) findViewById(R.id.profile_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadProfileData() {
        NetworkConnection.getInstance()
                .getNetworkApi()
                .getProfileInfo(mToken)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        mProgressBar.setVisibility(View.GONE);
                        mLayout.setVisibility(View.VISIBLE);
                        mTvUserName.setText(user.getSurname() + " " + user.getName());
                        mTvIin.setText(user.getIin());
                        mTvBalance.setText("Баланс: " + user.getBalance());
                        mPackageId = user.getPackage();
                        Picasso.with(ProfileActivity.this)
                                .load(user.getAvatar())
                                .into(mIvImage);
                        loadPackage(mPackageId);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(ProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadPackage(int packageId) {
        NetworkConnection.getInstance()
                .getNetworkApi()
                .getUserPackage(mToken, packageId)
                .enqueue(new Callback<Package>() {
                    @Override
                    public void onResponse(Call<Package> call, Response<Package> response) {
                        Log.d(TAG, response.body().getName());
                        mInsuranceItemList = response.body().getList();
                        loadCategories();
                    }

                    @Override
                    public void onFailure(Call<Package> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }

    private void loadCategories() {
        mAdapter = new InsuranceItemAdapter(mInsuranceItemList, this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(View view, int id) {
        Intent intent = new Intent(this, DoctorListActivity.class);
        intent.putExtra("categoryId", id);
        startActivity(intent);
    }
}
