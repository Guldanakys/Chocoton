package com.example.watson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.watson.adapters.DoctorAdapter;
import com.example.watson.models.Doctor;
import com.example.watson.network.NetworkConnection;
import com.example.watson.network.NetworkConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DoctorAdapter mAdapter;
    private List<Doctor> mDoctorList;
    private String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        setTitle("Выберите доктора");

        int id = getIntent().getIntExtra("categoryId", 0);
        mToken = "token 0b23eea6fa605b9873d081d595b83ad7225f5c16";

        mRecyclerView = (RecyclerView) findViewById(R.id.doctor_list_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadDoctorList();

    }

    private void loadDoctorList() {
        NetworkConnection.getInstance()
                .getNetworkApi()
                .getDoctors(mToken)
                .enqueue(new Callback<List<Doctor>>() {
                    @Override
                    public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                        mDoctorList = response.body();
                        mAdapter = new DoctorAdapter(mDoctorList, DoctorListActivity.this);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Doctor>> call, Throwable t) {
                        Toast.makeText(DoctorListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
