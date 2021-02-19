package com.example.bdfinance.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.bdfinance.R;
import com.example.bdfinance.databinding.ActivityMainBinding;
import com.example.bdfinance.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Fragment selectedFragment;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
    private void buttomNav()
    {
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeBN:
                        selectedFragment=new HomeFragment();
                        initFragment(selectedFragment);
                        break;
                }
                return false;
            }
        };
    }
    private void initFragment(Fragment selectedFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFragmentContainer, selectedFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        buttomNav();
        selectedFragment = new HomeFragment();
        initFragment(selectedFragment);
    }
}