package com.example.bdfinance.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.bdfinance.R;
import com.example.bdfinance.adaptar.PagerAdapter;
import com.example.bdfinance.databinding.ActivityDepositBinding;
import com.example.bdfinance.databinding.ActivityLoanBinding;
import com.example.bdfinance.fragment.DepositFragment;
import com.example.bdfinance.fragment.LoanFragment;

public class LoanActivity extends AppCompatActivity {
    private ActivityLoanBinding binding;
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoanBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new LoanFragment(),"Loan");
        pagerAdapter.addFragment(new DepositFragment(),"Deposit");
        viewPager=binding.viewPager1;
        viewPager.setAdapter(pagerAdapter);
        binding.simpleTabLayout1.setupWithViewPager(viewPager);
    }
}