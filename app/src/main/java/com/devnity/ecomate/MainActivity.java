package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.devnity.ecomate.services.SharedDatabase;

public class MainActivity extends AppCompatActivity {

    int time = 1300;

    TextView mainSplashLogo;
    SharedDatabase sharedDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getColor(R.color.white));

        mainSplashLogo = findViewById(R.id.mainSplashLogo);
        sharedDatabase = new SharedDatabase(this);

        ScaleAnimation scaleDown = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleDown.setDuration(time+200);
        mainSplashLogo.setAnimation(scaleDown);



        new Handler().postDelayed(() -> {
            String tempToken = sharedDatabase.getToken();
            System.out.println(tempToken);
            if (tempToken != null) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(0,0);
                finish();
            }else {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                overridePendingTransition(0,0);
                finish();
            }

        },time);
    }
}