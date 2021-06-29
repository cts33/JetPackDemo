package com.example.mylifecycle;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;

public class MyChronometer  extends Chronometer implements LifecycleObserver {


    private final TimeVM timeVM;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);

        timeVM = new ViewModelProvider((MainActivity)context).get(TimeVM.class);

    }
    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    private void resume(){
        MutableLiveData<Long> times = timeVM.getTimes();
        setBase(SystemClock.elapsedRealtime()-times.getValue());
        start();
    }
    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    private void pause(){
        //获取后台走过的时间差
        long elapsedTime  = SystemClock.elapsedRealtime()-getBase();

        timeVM.setTimes(elapsedTime);
    }
}
