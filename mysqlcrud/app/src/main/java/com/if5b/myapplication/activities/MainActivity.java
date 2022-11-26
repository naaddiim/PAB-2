package com.if5b.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.if5b.myapplication.databinding.ActivityMainBinding;
import com.if5b.myapplication.retrofit.ApiService;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static final String KEY_USERNAME = "xUsername";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(!ApiService.checkValue(MainActivity.this, KEY_USERNAME)) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }

        binding.tvTes.setText(ApiService.getValue(MainActivity.this, KEY_USERNAME));

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService.deleteValue(MainActivity.this);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}