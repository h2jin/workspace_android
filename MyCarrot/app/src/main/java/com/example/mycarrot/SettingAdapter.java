package com.example.mycarrot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarrot.models.SettingList;

import java.util.ArrayList;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyViewHolder> {


    ArrayList<SettingList> list;
    Context context;


    public SettingAdapter(ArrayList<SettingList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.setting_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SettingList settingList = list.get(position);
        holder.iconImage.setImageDrawable(settingList.getIcon());
        holder.titleTextView.setText(settingList.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iconImage;
        TextView titleTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImage);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            itemView.setOnClickListener(view -> {

            });
        }
    }

}
