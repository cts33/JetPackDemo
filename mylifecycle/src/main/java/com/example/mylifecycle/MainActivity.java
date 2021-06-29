package com.example.mylifecycle;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyChronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mChronometer = (MyChronometer) findViewById(R.id.chronometer);

        getLifecycle().addObserver(mChronometer);
    }
}