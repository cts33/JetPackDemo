package com.example.jetpackdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpackdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    MyViewModel myViewModel;
    private ImageButton mZan;
    private Button mCai;
    private TextView mResult;

    private static final String TAG = "MainActivity";
    //一定对照当前界面名称
    private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        myViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);

//        设置数据绑定关系  生命周期的监听
        viewDataBinding.setData(myViewModel);
        viewDataBinding.setLifecycleOwner(this);



    }

}