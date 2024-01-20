package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class AwareOutScreenActivity extends AppCompatActivity {
    TextView titleView, contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware_out_screen);

        titleView = findViewById(R.id.titleAwareView);
        contentView = findViewById(R.id.awareContentView);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        setContentForTitle(title);
    }

    private void setContentForTitle(String title){

        if (Objects.equals(title, "tips")){
            titleView.setText(getString(R.string.tipsTitle));
            contentView.setText(getString(R.string.tipsContent));

        }else if(Objects.equals(title, "crisis")){

            titleView.setText(getString(R.string.crisisTitle));
            contentView.setText(getString(R.string.crisisContent));

        }else if (Objects.equals(title, "project")){
            titleView.setText(getString(R.string.projectTitle));
            contentView.setText(getString(R.string.projectContent));

        }
    }
}