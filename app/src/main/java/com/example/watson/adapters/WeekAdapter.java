package com.example.watson.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.watson.MyOnClickListener;
import com.example.watson.R;
import com.example.watson.models.Day;

import java.util.List;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.WeekHolder> {

    private List<Day> mList;

    private Context mContext;

    private MyOnClickListener mListener;

    public WeekAdapter(List<Day> list, Context context, MyOnClickListener myOnClickListener) {
        mList = list;
        mContext = context;
        mListener = myOnClickListener;
    }

    @NonNull
    @Override
    public WeekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.week_day, viewGroup, false);
        return new WeekHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekHolder weekHolder, int i) {
        weekHolder.bind(mList.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class WeekHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvNumber;
        private TextView mTvDay;
        private MyOnClickListener mListener;

        public WeekHolder(@NonNull View itemView) {
            super(itemView);

            mTvDay = itemView.findViewById(R.id.day);
            mTvNumber = itemView.findViewById(R.id.number);
            itemView.setOnClickListener(this);
        }

        private void bind(Day day, MyOnClickListener myOnClickListener) {
            mTvNumber.setText(day.getNumber());
            mTvDay.setText(day.getWeek());
            mListener = myOnClickListener;
        }

        @Override
        public void onClick(View v) {
            mTvDay.setTextColor(Color.WHITE);
            mTvNumber.setTextColor(Color.WHITE);
            mListener.onItemClick(v, 1);
        }
    }
}
