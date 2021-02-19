package com.example.bdfinance.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bdfinance.R;
import com.example.bdfinance.adaptar.DepositAdaptar;
import com.example.bdfinance.databinding.FragmentDepositBinding;
import com.example.bdfinance.databinding.FragmentHomeBinding;


public class DepositFragment extends Fragment {
    FragmentDepositBinding binding;
    DepositAdaptar depositAdaptar;
    Context context;
    int[] image;
    String[] title,des;
    public DepositFragment() {
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
        binding = FragmentDepositBinding.inflate(inflater, container, false);
        title=getResources().getStringArray(R.array.title);
        des=getResources().getStringArray(R.array.description);
        image= new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};
        binding.recyclarView.setLayoutManager(new LinearLayoutManager(getContext()));
        depositAdaptar=new DepositAdaptar(getContext(),title,des,image);
        binding.recyclarView.setAdapter(depositAdaptar);

        return binding.getRoot();
    }
}