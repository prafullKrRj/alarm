package com.example.alm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class CancelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "step4", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_cancel_activigy);
    }
}