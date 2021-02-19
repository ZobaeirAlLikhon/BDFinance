package com.example.bdfinance.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.bdfinance.R;
import com.example.bdfinance.adaptar.CustomarVisitAdaptar;
import com.example.bdfinance.databinding.ActivityCustomarVisitBinding;
import com.example.bdfinance.databinding.ActivityCustomerDetailsBinding;
import com.example.bdfinance.model.VisitModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CustomarVisit extends AppCompatActivity {
    private ActivityCustomarVisitBinding binding;
    DatabaseReference databaseReference;
    ArrayList<VisitModel> list;
    CustomarVisitAdaptar adaptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomarVisitBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CustomarVisit");
        binding.cvRecy.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<VisitModel>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                    VisitModel ss=dataSnapshot1.getValue(VisitModel.class);
                    list.add(ss);
                }

                adaptar=new CustomarVisitAdaptar(CustomarVisit.this,list);
                binding.cvRecy.setAdapter(adaptar);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}