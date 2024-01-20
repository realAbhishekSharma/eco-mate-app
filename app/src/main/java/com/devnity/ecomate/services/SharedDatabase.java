package com.devnity.ecomate.services;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedDatabase {

    SharedPreferences sharedPreferences;

    private final String USER_PREF = "Users";
    private final String TOKEN = "token";
    public SharedDatabase(Context context){
        this.sharedPreferences = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
    }

    public String getToken(){
        return sharedPreferences.getString(TOKEN, null);
    }

    public void setToken(String value){
        sharedPreferences.edit().putString(TOKEN, value).apply();
    }

}
