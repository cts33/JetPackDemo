package com.example.jetpackdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    private Button mZan;
    private Button mCai;
    private TextView mResult;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        initView();
    }

    private void initView() {
        mZan = (Button) findViewById(R.id.zan);
        mCai = (Button) findViewById(R.id.cai);
        mResult = (TextView) findViewById(R.id.result);
        Log.d(TAG, "initView: ");
        //默认设置
        mResult.setText(myViewModel.value+"");
        mZan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.value++;

                mResult.setText(myViewModel.value+"");
            }
        });

    }
}