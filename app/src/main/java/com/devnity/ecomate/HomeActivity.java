package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.devnity.ecomate.services.SharedDatabase;

public class HomeActivity extends AppCompatActivity {

    TextView settingButton, energyUsageView;
    ConstraintLayout energyButton, emissionButton, awarenessButton;
    SharedDatabase sharedDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setStatusBarColor(getColor(R.color.white));

        sharedDatabase = new SharedDatabase(this);

        settingButton = findViewById(R.id.settingButtonHomeScreen);
        energyUsageView = findViewById(R.id.energyUsageViewHome);
        energyButton = findViewById(R.id.energyButtonHome);
        emissionButton = findViewById(R.id.emissionButtonHome);
        awarenessButton = findViewById(R.id.awarenessButtonHome);

        setEnergyUsageView(180);


        energyUsageView.setOnClickListener((view)->{
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });
        settingButton.setOnClickListener((view)->{
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
            sharedDatabase.setToken(null);

        });

        energyButton.setOnClickListener((view)->{
            startActivity(new Intent(getApplicationContext(), EnergyActivity.class));
        });

        emissionButton.setOnClickListener((view)->{
            startActivity(new Intent(getApplicationContext(), EmissionActivity.class));
        });

        awarenessButton.setOnClickListener((view)->{
            startActivity(new Intent(getApplicationContext(), AwarenessActivity.class));
        });
    }

    private void setEnergyUsageView(int value){
        energyUsageView.setText(value+" kwh");
    }
}