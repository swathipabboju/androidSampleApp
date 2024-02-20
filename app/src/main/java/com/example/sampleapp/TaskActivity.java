package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TaskActivity extends AppCompatActivity {
    private  CardView cardView,cvTaskDashbaord,cvForm;
    private   Intent intentRegistration,intentTaskDashboard,intentForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
         intentRegistration = new Intent(TaskActivity.this, loginAcitvity.class);
         intentTaskDashboard = new Intent(TaskActivity.this,TaskActivity.class);
         intentForm = new Intent(TaskActivity.this,FormActivity.class);
         cardView = findViewById(R.id.cv_registration);
         cvTaskDashbaord = findViewById(R.id.cv_task_dashboard);
         cvForm= findViewById(R.id.cv_form);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentRegistration);
            }
        });
        cvTaskDashbaord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentTaskDashboard);
            }
        });
        cvForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentForm);
            }
        });

    }
}