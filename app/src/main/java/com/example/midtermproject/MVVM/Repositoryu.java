package com.example.midtermproject.MVVM;

import android.graphics.ColorSpace;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.midtermproject.Model.ModelCoffee;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;

import java.sql.Array;
import java.util.ArrayList;

public class Repositoryu {

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    ArrayList<ModelCoffee> coffeeModelList = new ArrayList<>();

    CoffeeList interfaceCoffeeList;

    public Repositoryu(CoffeeList interfaceCoffeeList) {
        this.interfaceCoffeeList = interfaceCoffeeList;
    }

    public void getCoffee(){
        firebaseFirestore.collection("Coffee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    coffeeModelList.clear();
                    for(DocumentSnapshot ds: task.getResult().getDocuments())
                    {
                        ModelCoffee modelCoffee = ds.toObject(ModelCoffee.class);
                        coffeeModelList.add(modelCoffee);

                        interfaceCoffeeList.coffeeLists(coffeeModelList);

                    }
                }

            }
        });
    }

    public interface CoffeeList{
        void coffeeLists(ArrayList<ModelCoffee> modelCoffees);
    }
}
