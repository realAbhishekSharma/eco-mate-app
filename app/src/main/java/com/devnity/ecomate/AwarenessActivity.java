package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class AwarenessActivity extends AppCompatActivity {

    ConstraintLayout tipsButton, energyCrisisButton, recentProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getColor(R.color.white));
        setContentView(R.layout.activity_awareness);

        tipsButton = findViewById(R.id.energySavingTipsButtonAware);
        energyCrisisButton = findViewById(R.id.energyCrisisAware);
        recentProjectButton = findViewById(R.id.projectButtonAware);

        tipsButton.setOnClickListener((view)->{
          startActivity(new Intent(getApplicationContext(), AwareOutScreenActivity.class).putExtra("title", "tips"));
        });

        energyCrisisButton.setOnClickListener((view)->{
          startActivity(new Intent(getApplicationContext(), AwareOutScreenActivity.class).putExtra("title", "crisis"));
        });

        recentProjectButton.setOnClickListener((view)->{
          startActivity(new Intent(getApplicationContext(), AwareOutScreenActivity.class).putExtra("title", "project"));
        });
    }
}