package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmissionActivity extends AppCompatActivity {

    LinearLayout backButton;
    TextView calculateButton, calculationResult;
    EditText carbonCostInput;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getColor(R.color.white));
        setContentView(R.layout.activity_emission);

        backButton = findViewById(R.id.backButtonEmissionScreen);

        carbonCostInput = findViewById(R.id.carbonCostInput);
        calculateButton = findViewById(R.id.calculateButton);
        calculationResult = findViewById(R.id.calculationOutput);



        backButton.setOnClickListener((view)->{
            finish();
        });

        carbonCostInput.setText(0.7+"");
        calculationResult.setText(calculateFootprintCost(0.7F)+" kg CO2");
        calculateButton.setOnClickListener((view)->{
            float value = Float.parseFloat(carbonCostInput.getText().toString());

            calculationResult.setText(calculateFootprintCost(value)+" kg CO2");
        });

    }

    private float calculateFootprintCost(float value){
        return value*180;
    }
}