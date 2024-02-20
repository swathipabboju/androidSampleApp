package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {
    private RadioGroup rg_gender;
    private AppCompatButton submitButton;
    private EditText etName,etMobile;
    private  RadioButton selectedRadioVal;
    private ToggleButton tbWifi;
    private CheckBox cbEn,cbTe,cbHi;
    private AutoCompleteTextView actStates;

    private Spinner spDistrict;
    String[] districtList = {"Select District","Jangoan","Warangal","Karimnagar","Hyderabad"};
    String[] stateList = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala",
            "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha",
            "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
    };




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        rg_gender = findViewById(R.id.rg_gender);
        submitButton = findViewById(R.id.bt_submit);
        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mbl);
        tbWifi = findViewById(R.id.tb_wifi);
        cbEn = findViewById(R.id.cb_en);
        cbTe = findViewById(R.id.cb_te);
        cbHi = findViewById(R.id.cb_hi);
        spDistrict = findViewById(R.id.spinner);
        actStates = findViewById(R.id.act_states);
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 selectedRadioVal = findViewById(checkedId);
            }
        });
        tbWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tbWifi.getText();
            }
        });
        //AutocompleteTextview
        ArrayAdapter aaState = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,stateList);
        actStates.setThreshold(1);//will start working from first character
        actStates.setAdapter(aaState);
        //spinner
        ArrayAdapter aaDistrict = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,districtList);
        spDistrict.setAdapter(aaDistrict);

        spDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(validations()){
                   Toast.makeText(FormActivity.this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show();
               }
            }
        });


    }

    private boolean validations() {
        boolean isValid = false;
        if (etName.getText().toString().trim().isEmpty()) {
            etMobile.setError("Enter your name");
        } else if (etMobile.getText().toString().trim().isEmpty()) {
            etMobile.setError("Invalid mobile number");
        } else if (etMobile.getText().toString().trim().length() != 10) {
            etMobile.setError("Invalid mobile number");
        } else if (selectedRadioVal == null) {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
        } else if (!tbWifi.isChecked()) {
            Toast.makeText(this, "Please turn on your wifi", Toast.LENGTH_SHORT).show();
        } else if ((!cbEn.isChecked()) && (!cbHi.isChecked()) && (!cbTe.isChecked())) {
            Toast.makeText(this, "Please select at least one language", Toast.LENGTH_SHORT).show();
        } else if (spDistrict.getSelectedItem().equals(districtList[0])) {
            Toast.makeText(this, "Please select a district", Toast.LENGTH_SHORT).show();
        } else if(actStates.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Please enter your state", Toast.LENGTH_SHORT).show();
        }
        else {
            isValid = true;
        }

        return isValid;
    }



}