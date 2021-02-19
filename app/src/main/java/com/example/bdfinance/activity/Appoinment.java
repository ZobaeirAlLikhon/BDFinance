package com.example.bdfinance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bdfinance.R;
import com.example.bdfinance.databinding.ActivityAppoinmentBinding;
import com.example.bdfinance.databinding.ActivityCustomerDetailsBinding;

public class Appoinment extends AppCompatActivity {
    private ActivityAppoinmentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppoinmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Toast.makeText(Appoinment.this,"Under Development, Thank You",Toast.LENGTH_SHORT).show();
        binding.createVisitBT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Appoinment.this,"Do not submit on Database, Thank You",Toast.LENGTH_SHORT).show();
            }
        });
    }
}