package com.example.alm;

import android.content.Context;

public class MySingleton {
    private static MySingleton instance;
    private Context context;

    MySingleton(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new MySingleton(context);
        }
        return instance;
    }

    // Use the context reference as needed
    // ...
}


