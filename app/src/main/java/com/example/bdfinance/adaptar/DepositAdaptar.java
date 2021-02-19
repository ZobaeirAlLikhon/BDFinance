package com.example.bdfinance.adaptar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bdfinance.R;
import com.example.bdfinance.activity.CustomerDetails;

import de.hdodenhof.circleimageview.CircleImageView;

public class DepositAdaptar extends RecyclerView.Adapter<DepositAdaptar.MyVIewHolder> {
    Context context;
    String[] title,des;
    int[] image;

    public DepositAdaptar(Context context, String[] title, String[] des, int[] image) {
        this.context = context;
        this.title = title;
        this.des = des;
        this.image = image;
    }

    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyVIewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVIewHolder holder, int position) {
        holder.name.setText(title[position]);
        holder.details.setText(des[position]);
        holder.circleImageView.setImageResource(image[position]);
        holder.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, CustomerDetails.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyVIewHolder extends RecyclerView.ViewHolder {
        TextView name,details;
        CircleImageView circleImageView;
        Button butt;
        public MyVIewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.pName);
            details=itemView.findViewById(R.id.details);
            circleImageView=itemView.findViewById(R.id.cIMAGE);
            butt=itemView.findViewById(R.id.button);

        }
    }
}
