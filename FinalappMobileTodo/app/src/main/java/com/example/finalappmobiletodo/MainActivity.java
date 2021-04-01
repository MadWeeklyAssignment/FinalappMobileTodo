package com.example.finalappmobiletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.finalappmobiletodo.data.task;
import com.example.finalappmobiletodo.data.tododao;
import com.example.finalappmobiletodo.data.appdatabase;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}