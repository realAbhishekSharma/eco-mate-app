package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EnergyActivity extends AppCompatActivity {

    LinearLayout backButton;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getColor(R.color.white));
        setContentView(R.layout.activity_energy);

        backButton = findViewById(R.id.backButtonEnergyScreen);


        backButton.setOnClickListener((view)->{
            finish();
        });

    }
}