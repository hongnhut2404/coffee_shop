package com.example.midtermproject.MVVM;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.midtermproject.Model.ModelCoffee;

import java.io.Closeable;
import java.util.ArrayList;

public class CoffeeViewModel extends ViewModel {

    MutableLiveData<ArrayList<ModelCoffee>> mutableLiveData = new MutableLiveData<ArrayList<ModelCoffee>>();
    Repositoryu repositoryu = new Repositoryu(this::coffeeLists);

    public CoffeeViewModel() {
        repositoryu.getCoffee();
    }

    public LiveData<ArrayList<ModelCoffee>> getCoffeeList(){
        return mutableLiveData;
    }

    public void coffeeLists(ArrayList<ModelCoffee> modelCoffees)
    {
        mutableLiveData.setValue(modelCoffees);
    }
}
