package com.example.bdfinance.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.bdfinance.R;
import com.example.bdfinance.adaptar.PagerAdapter;
import com.example.bdfinance.databinding.ActivityDepositBinding;
import com.example.bdfinance.databinding.ActivityMainBinding;
import com.example.bdfinance.fragment.DepositFragment;
import com.example.bdfinance.fragment.LoanFragment;

public class DepositActivity extends AppCompatActivity {
    private ActivityDepositBinding binding;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepositBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new DepositFragment(),"Deposit");
        pagerAdapter.addFragment(new LoanFragment(),"Loan");
        viewPager=binding.viewPager;
        viewPager.setAdapter(pagerAdapter);
        binding.simpleTabLayout.setupWithViewPager(viewPager);

//        binding.simpleTabLayout.addTab(binding.simpleTabLayout.newTab().setText("Deposit"));
//        binding.simpleTabLayout.addTab(binding.simpleTabLayout.newTab().setText("Loan"));

    }
}