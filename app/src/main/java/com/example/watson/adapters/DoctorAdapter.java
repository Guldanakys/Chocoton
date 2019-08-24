package com.example.watson.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watson.DoctorActivity;
import com.example.watson.R;
import com.example.watson.models.Doctor;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorHolder> {

    private List<Doctor> mList;

    private Context mContext;

    public DoctorAdapter(List<Doctor> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public DoctorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.doctor_item, viewGroup, false);
        return new DoctorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorHolder doctorHolder, int i) {
        Doctor doctor = mList.get(i);
        doctorHolder.bind(doctor, mContext);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class DoctorHolder extends RecyclerView.ViewHolder {

        private TextView mTvName;
        private TextView mTvType;
        private TextView mTvExperience;
        private TextView mTvPrice;
        private TextView mTvDetail;
        private ImageView mImageView;

        public DoctorHolder(@NonNull View itemView) {
            super(itemView);

            mTvName = itemView.findViewById(R.id.name);
            mTvType = itemView.findViewById(R.id.type);
            mTvExperience = itemView.findViewById(R.id.experience);
            mTvPrice = itemView.findViewById(R.id.price);
            mTvDetail = itemView.findViewById(R.id.detail);
            mImageView = itemView.findViewById(R.id.image);
        }

        private void bind(final Doctor doctor, final Context context) {
            mTvName.setText(doctor.getSurname() + " " + doctor.getName());
            mTvType.setText(doctor.getType());
            mTvExperience.setText("Опыт: " + doctor.getPrice().charAt(0) + "лет");
            mTvPrice.setText("Стоимость приема: " + doctor.getPrice());
            Picasso.with(context).load(doctor.getAvatar()).into(mImageView);
            mTvDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DoctorActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
