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
import com.example.bdfinance.databinding.FragmentLoanBinding;


public class LoanFragment extends Fragment {

    FragmentLoanBinding binding;
    DepositAdaptar depositAdaptar;
    Context context;
    int[] image;
    String[] title,des;

    public LoanFragment() {
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
        binding = FragmentLoanBinding.inflate(inflater, container, false);
        title=getResources().getStringArray(R.array.title);
        des=getResources().getStringArray(R.array.description);
        image= new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        binding.recyclarViewLoan.setLayoutManager(new LinearLayoutManager(getContext()));
        depositAdaptar=new DepositAdaptar(getContext(),title,des,image);
        binding.recyclarViewLoan.setAdapter(depositAdaptar);

        return binding.getRoot();
    }
}