package com.example.jetpackdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {


    private SavedStateHandle savedStateHandle;

    public MyViewModel(SavedStateHandle savedStateHandle) {

        this.savedStateHandle = savedStateHandle;


    }

    public MutableLiveData<Integer> getValue() {
        if (!savedStateHandle.contains("value"))
            savedStateHandle.set("value",0);

        return savedStateHandle.getLiveData("value");
    }

    public void setValue(int value) {

        MutableLiveData<Integer> value1 = getValue();
        savedStateHandle.set("value", value1.getValue() + value);
    }
}
