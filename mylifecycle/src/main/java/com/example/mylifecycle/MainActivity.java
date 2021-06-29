package com.example.mylifecycle;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private MyChronometer mChronometer;
    private   TimeVM timeVM;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate: "+this);

        initView();
    }

    private void initView() {
        mChronometer = (MyChronometer) findViewById(R.id.chronometer);

        getLifecycle().addObserver(mChronometer);
    }
}