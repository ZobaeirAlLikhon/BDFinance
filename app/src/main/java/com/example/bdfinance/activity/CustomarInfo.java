package com.example.bdfinance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.bdfinance.R;
import com.example.bdfinance.databinding.ActivityCustomarInfoBinding;
import com.example.bdfinance.databinding.ActivityCustomarVisitBinding;

public class CustomarInfo extends AppCompatActivity {
    private Bundle bundle;
    ActivityCustomarInfoBinding binding;
    String name,address,image,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomarInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        bundle = getIntent().getExtras();
        name=bundle.getString("name");
        address=bundle.getString("Address");
        image=bundle.getString("image");
        mobile=bundle.getString("mobile");
        binding.nameInfo.setText(name);
        binding.addressInfo.setText(address);
        binding.mobileCVINFO.setText(mobile);
        Glide.with(this).load(image).into(binding.pro);
        binding.expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.expandCard.getVisibility()==View.GONE)
                {
                    binding.expandCard.setVisibility(View.VISIBLE);
                }
                else {
                    binding.expandCard.setVisibility(View.GONE);
                }
            }
        });
    }
}