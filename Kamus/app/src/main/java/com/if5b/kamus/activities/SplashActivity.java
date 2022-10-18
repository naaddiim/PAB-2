package com.if5b.kamus.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.if5b.kamus.R;
import com.if5b.kamus.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}