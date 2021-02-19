package com.example.bdfinance.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bdfinance.R;
import com.example.bdfinance.activity.Appoinment;
import com.example.bdfinance.activity.CustomarVisit;
import com.example.bdfinance.activity.CustomerDetails;
import com.example.bdfinance.activity.DepositActivity;
import com.example.bdfinance.activity.LoanActivity;
import com.example.bdfinance.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private Context context;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        changeActivity();
        return binding.getRoot();
    }

    private void changeActivity() {
        binding.depositCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DepositActivity.class);
                startActivity(intent);

            }
        });
        binding.loanCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoanActivity.class);
                startActivity(intent);

            }
        });
        binding.cusInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CustomerDetails.class);
                startActivity(intent);

            }
        });

        binding.allVisits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CustomarVisit.class);
                startActivity(intent);

            }
        });
        binding.appoinmentt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Appoinment.class);
                startActivity(intent);

            }
        });

    }
}