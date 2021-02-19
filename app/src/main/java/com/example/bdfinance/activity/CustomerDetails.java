package com.example.bdfinance.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bdfinance.R;
import com.example.bdfinance.databinding.ActivityCustomerDetailsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

public class CustomerDetails extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener ,DatePickerDialog.OnDateSetListener{
    private ActivityCustomerDetailsBinding binding;
    DatePickerDialog datePickerDialog;
    StorageReference imageName,storageReference;
    private static final int PIC_IMAGE_REQ=1;
    private Uri imageUri,imageURL;
    String[] country = { "Doctor", "Engineer", "Police", "Army", "RAB"};
    String prof,date,key;
    final Calendar myCalendar = Calendar.getInstance();
    DatabaseReference databaseReference,dbRef;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CustomarVisit");
        key=databaseReference.push().getKey();
        dbRef= FirebaseDatabase.getInstance().getReference().child("CustomarVisit").child(key);
        storageReference= FirebaseStorage.getInstance().getReference().child("Pro");
        binding.profesionSp.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        binding.profesionSp.setAdapter(aa);
        initialization();

    }

    private void initialization() {
        binding.textField5.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartDatePicker();
            }
        });
        binding.createVisitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(CustomerDetails.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                createVisit();

            }
        });
        binding.uploadeIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageUploade();
            }
        });
    }
    private void createVisit() {
        String name=binding.textField.getEditText().getText().toString();
        String mobile=binding.textField2.getEditText().getText().toString();
        String add=binding.textField3.getEditText().getText().toString();
        String profesion=prof;
        String amount=binding.textField4.getEditText().getText().toString();
        String birthDate=date;
        imageName=storageReference.child(imageUri.getLastPathSegment());
        imageName.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(CustomerDetails.this,"uploaded",Toast.LENGTH_LONG).show();

                imageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        imageURL=uri;
                        HashMap<String, Object> result = new HashMap<>();
                        result.put("name", name);
                        result.put("mobile", mobile);
                        result.put("address", add);
                        result.put("profetion", profesion);
                        result.put("amount", amount);
                        result.put("birthDate", birthDate);
                        result.put("image",String.valueOf(imageURL));
                        databaseReference.child(key).updateChildren(result);
                        Toast.makeText(CustomerDetails.this,"Save Database",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(CustomerDetails.this,CustomarVisit.class);
                        progressDialog.dismiss();
                        startActivity(intent);

                    }
                });

            }
        });

    }

    private void imageUploade() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PIC_IMAGE_REQ);
    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PIC_IMAGE_REQ && resultCode==RESULT_OK &&data!=null && data.getData()!=null)
        {
            imageUri=data.getData();
            String path=imageUri.getPath();
            File f = new File(String.valueOf(path));
            String imageN = f.getName();

            binding.imagename.setText(imageN);
//            Glide.with(this).load(imageN).into(binding.imagename);
        }

    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
        prof=country[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void openStartDatePicker() {
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        );
        datePickerDialog.show();

    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        date=(dayOfMonth+1)+"/"+month+"/"+year;
        binding.textField5.getEditText().setText((dayOfMonth+1)+"/"+month+"/"+year);
    }
}