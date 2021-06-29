package com.example.jetpackdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {



    MyViewModel myViewModel;
    private ImageButton mZan;
    private Button mCai;
    private TextView mResult;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        myViewModel.getLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer o) {
                mResult.setText(o+"");
            }
        });

        initView();
    }

    private void initView() {
        mZan = (ImageButton) findViewById(R.id.zan);
        mCai = (Button) findViewById(R.id.cai);
        mResult = (TextView) findViewById(R.id.result);
        Log.d(TAG, "initView: ");
        //默认设置
        mResult.setText( myViewModel.getLiveData().getValue()+"");
        mZan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setLiveData(1);


            }
        });

    }
}