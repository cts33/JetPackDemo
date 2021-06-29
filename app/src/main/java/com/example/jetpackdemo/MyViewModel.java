package com.example.jetpackdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    MutableLiveData<Integer> liveData;

    public MutableLiveData getLiveData() {
        if (liveData==null){

            liveData  = new MutableLiveData<>();
            liveData.setValue(0);
        }

        return liveData;
    }

    public void setLiveData(int value) {
        if (liveData==null){

            liveData  = new MutableLiveData<>();
            liveData.setValue(0);
        }
        else{
            liveData.setValue(liveData.getValue()+value);

        }

    }
}
