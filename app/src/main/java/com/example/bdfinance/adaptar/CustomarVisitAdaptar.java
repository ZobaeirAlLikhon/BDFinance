package com.example.bdfinance.adaptar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bdfinance.R;
import com.example.bdfinance.activity.CustomarInfo;
import com.example.bdfinance.model.VisitModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomarVisitAdaptar extends RecyclerView.Adapter<CustomarVisitAdaptar.MyVIewHolder>{
    Context context;
    ArrayList<VisitModel> list;

    public CustomarVisitAdaptar(Context context, ArrayList<VisitModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_customar_visit, parent, false);

        return new MyVIewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomarVisitAdaptar.MyVIewHolder holder, int position) {
        holder.name.setText(list.get(position).getName().toString().trim());
        holder.details.setText(list.get(position).getAddress().toString().trim());
        Glide.with(context).load(list.get(position).getImage()).into(holder.circleImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, CustomarInfo.class);
                intent.putExtra("name",list.get(position).getName().toString().trim());
                intent.putExtra("Address",list.get(position).getAddress().toString().trim());
                intent.putExtra("image",list.get(position).getImage().toString().trim());
                intent.putExtra("mobile",list.get(position).getMobile().toString().trim());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVIewHolder extends RecyclerView.ViewHolder {
        TextView name,details;
        CircleImageView circleImageView;
        public MyVIewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.pNameV);
            details=itemView.findViewById(R.id.detailsV);
            circleImageView=itemView.findViewById(R.id.cIMAGEV);
        }
    }
}
