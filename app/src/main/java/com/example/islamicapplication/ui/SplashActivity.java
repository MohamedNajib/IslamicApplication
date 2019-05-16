package com.example.islamicapplication.ui;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.example.islamicapplication.R;

import static com.example.islamicapplication.helper.HelperMethod.*;
import static com.example.islamicapplication.helper.Constant.SPLASH_DISPLAY_LENGTH;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intentTo(SplashActivity.this, HomeActivity.class);

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
