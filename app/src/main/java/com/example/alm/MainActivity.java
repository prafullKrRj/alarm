package com.example.alm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private StartAlarm startAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.btn)).setOnClickListener(this::alarm);
        MySingleton mySingleton = new MySingleton(getApplicationContext());
    }

    private void alarm(View view) {
        startAlarm = new StartAlarm(getApplicationContext(), 18, 24, 0);
    }
}
