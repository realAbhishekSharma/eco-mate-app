package com.devnity.ecomate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devnity.ecomate.api.UserService;
import com.devnity.ecomate.services.SharedDatabase;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    TextView loginButton;

    final String TOKEN = "token";
    SharedDatabase sharedDatabase;
    EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getColor(R.color.white));
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        sharedDatabase = new SharedDatabase(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.ApiURL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);

        JsonObject userObject = new JsonObject();
        userObject.addProperty("email", "chek@gmail.com");
        userObject.addProperty("password", "123456");

        Call<Object> callPatientHistory = userService.loginUser(userObject);

        loginButton.setOnClickListener((view)->{

//            userObject.addProperty("email", emailInput.getText().toString().trim());
//            userObject.addProperty("password", passwordInput.getText().toString().trim());

            callPatientHistory.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    String tokenValue;

                    if (response.isSuccessful()){
                        Gson gson = new Gson();
                        JsonElement jsonElement = gson.toJsonTree(response.body());
                        JsonObject jsonObject = jsonElement.getAsJsonObject();

                        tokenValue = "Bearer "+jsonObject.get("token").getAsString();
//                        forgetPassword.setText(tokenValue);
//                            System.out.println(jsonObject.get("token"));
                        sharedDatabase.setToken(tokenValue);
                        System.out.println(tokenValue);

                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                        finish();
                    }else if (response.code()== 400){
                        Toast.makeText(getApplicationContext(), "Credential not found.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {

                }
            });

        });
    }
}