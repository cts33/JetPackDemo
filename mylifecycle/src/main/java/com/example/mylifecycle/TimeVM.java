package com.example.mylifecycle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimeVM extends ViewModel {

    MutableLiveData<Long> times;

    public TimeVM() {
        if (times==null){
            times = new MutableLiveData<>();
            times.setValue(0L);
        }
    }

    public MutableLiveData<Long> getTimes() {

        return times;
    }

    public void setTimes(long times) {
        this.times.setValue(times);
    }
}
