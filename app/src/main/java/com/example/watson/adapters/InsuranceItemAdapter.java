package com.example.watson.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watson.DoctorListActivity;
import com.example.watson.MyOnClickListener;
import com.example.watson.R;
import com.example.watson.models.InsuranceItem;

import java.util.List;

public class InsuranceItemAdapter extends RecyclerView.Adapter<InsuranceItemAdapter.InsuranceItemHolder> {

    private List<InsuranceItem> mList;

    private Context mContext;

    private MyOnClickListener mOnClickListener;

    public InsuranceItemAdapter(List<InsuranceItem> list, Context context, MyOnClickListener listener) {
        mList = list;
        mContext = context;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public InsuranceItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.insurance_type_item, viewGroup, false);
        return new InsuranceItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceItemHolder insuranceItemHolder, int i) {
        InsuranceItem item = mList.get(i);
        insuranceItemHolder.bind(item, mContext, mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class InsuranceItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvTitle;
        private TextView mTvDescription;
        private MyOnClickListener mListener;
        private int mId;

        public InsuranceItemHolder(@NonNull View itemView) {
            super(itemView);

            mTvTitle = itemView.findViewById(R.id.title);
            mTvDescription = itemView.findViewById(R.id.description);
           // mRecord = itemView.findViewById(R.id.record);
            itemView.setOnClickListener(this);
        }

        private void bind(final InsuranceItem item, final Context context, MyOnClickListener myOnClickListener) {
            mTvTitle.setText(item.getTitle());
            mTvDescription.setText(item.getDescription());
            mListener = myOnClickListener;
            mId = item.getId();
            /*mRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DoctorListActivity.class);
                    context.startActivity(intent);
                }
            });*/
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, mId);
        }
    }
}
