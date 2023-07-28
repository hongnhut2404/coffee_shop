package com.example.midtermproject.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.midtermproject.Model.ModelCoffee;

import java.util.ArrayList;

public class CoffeeViewModel extends ViewModel {

    MutableLiveData<ArrayList<ModelCoffee>> mutableLiveData = new MutableLiveData<ArrayList<ModelCoffee>>();
    Repository repository = new Repository(this::coffeeLists);

    public CoffeeViewModel() {
        repository.getCoffee();
    }

    public LiveData<ArrayList<ModelCoffee>> getCoffeeList(){
        return mutableLiveData;
    }

    public void coffeeLists(ArrayList<ModelCoffee> modelCoffees)
    {
        mutableLiveData.setValue(modelCoffees);
    }
}
