package com.example.watson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.watson.adapters.HourAdapter;
import com.example.watson.adapters.WeekAdapter;
import com.example.watson.models.Day;
import com.example.watson.models.Doctor;
import com.example.watson.network.NetworkConnection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorActivity extends AppCompatActivity implements MyOnClickListener {

    private TextView mTvName;
    private TextView mTvType;
    private TextView mTvExperience;
    private TextView mTvPrice;
    private ImageView mImageView;
    private TextView mTvRecord;

    private Spinner mSpinner;
    private RecyclerView mRecycler;
    private WeekAdapter mAdapter;
    private RecyclerView mRecylerHour;
    private HourAdapter mHourAdapter;

    private List<String> mServiceList;
    private List<Day> mDayList;
    private List<String> mHourList;
    private String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        setTitle("Запись");

        int id = getIntent().getIntExtra("categoryId", 0);
        mToken = "token 0b23eea6fa605b9873d081d595b83ad7225f5c16";

        mTvName = (TextView) findViewById(R.id.doctor_name);
        mTvType = (TextView) findViewById(R.id.doctor_type);
        mTvExperience = (TextView) findViewById(R.id.experience);
        mTvPrice = (TextView) findViewById(R.id.price);
        mImageView = (ImageView) findViewById(R.id.image);
        mTvRecord = (TextView) findViewById(R.id.record);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        mRecycler = (RecyclerView) findViewById(R.id.week_recycler);
        mRecylerHour = (RecyclerView) findViewById(R.id.hour_recycler);

        loadDoctor();

        initServiceList();
        initDayList();
        initHourList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mServiceList);
        mSpinner.setAdapter(adapter);

        mRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new WeekAdapter(mDayList, this, this);
        mRecycler.setAdapter(mAdapter);

        mRecylerHour.setLayoutManager(new GridLayoutManager(this, 4));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.hour, mHourList);
        mHourAdapter = new HourAdapter(mHourList, this, this);
        mRecylerHour.setAdapter(mHourAdapter);

        mTvRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorActivity.this, ProfileActivity.class));
                finish();
            }
        });

    }

    private void loadDoctor() {
        /*NetworkConnection.getInstance()
                .getNetworkApi()
                .getDoctor(mToken, 1)
                .enqueue(new Callback<Doctor>() {
                    @Override
                    public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                        Doctor doctor = response.body();
                        mTvName.setText(doctor.getSurname() + " " + doctor.getName());
                        mTvType.setText(doctor.getType());
                        mTvExperience.setText("Опыт: " + doctor.getPrice().charAt(0) + "лет");
                        mTvPrice.setText("Стоимость приема: " + doctor.getPrice());
                        Picasso.with(context).load(doctor.getAvatar()).into(mImageView);
                    }

                    @Override
                    public void onFailure(Call<Doctor> call, Throwable t) {

                    }
                });*/
    }

    private void initHourList() {
        mHourList = new ArrayList<>();
        mHourList.add("9:00");
        mHourList.add("10:00");
        mHourList.add("11:00");
        mHourList.add("12:00");
        mHourList.add("13:00");
        mHourList.add("14:00");
        mHourList.add("15:00");
        mHourList.add("16:00");

    }

    private void initDayList() {
        mDayList = new ArrayList<>();
        mDayList.add(new Day("26", "Пн"));
        mDayList.add(new Day("27", "Вт"));
        mDayList.add(new Day("28", "Ср"));
        mDayList.add(new Day("29", "Чт"));
        mDayList.add(new Day("30", "Пт"));
        mDayList.add(new Day("26", "Пн"));
        mDayList.add(new Day("27", "Вт"));
        mDayList.add(new Day("28", "Ср"));
        mDayList.add(new Day("29", "Чт"));
        mDayList.add(new Day("30", "Пт"));
    }

    private void initServiceList() {
        mServiceList = new ArrayList<>();
        mServiceList.add("Осмотр");
        mServiceList.add("Прием");
        mServiceList.add("Консультация");
        mServiceList.add("Диагностика");
    }

    @Override
    public void onItemClick(View view, int id) {
        view.setBackgroundResource(R.drawable.day_green);
    }
}
