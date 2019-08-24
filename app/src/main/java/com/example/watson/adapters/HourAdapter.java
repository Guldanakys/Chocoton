package com.example.watson.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.watson.MyOnClickListener;
import com.example.watson.R;
import com.example.watson.models.Day;

import java.util.List;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.WeekHolder> {

    private List<String> mList;

    private Context mContext;

    private MyOnClickListener mListener;

    public HourAdapter(List<String> list, Context context, MyOnClickListener listener) {
        mList = list;
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public WeekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.hour, viewGroup, false);
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
        private MyOnClickListener mListener;

        public WeekHolder(@NonNull View itemView) {
            super(itemView);

            mTvNumber = itemView.findViewById(R.id.hour);
            itemView.setOnClickListener(this);
        }

        private void bind(String hour, MyOnClickListener myOnClickListener) {
            mTvNumber.setText(hour);
            mListener = myOnClickListener;
        }

        @Override
        public void onClick(View v) {
            mTvNumber.setTextColor(Color.WHITE);
            mListener.onItemClick(v, 1);
        }
    }
}
