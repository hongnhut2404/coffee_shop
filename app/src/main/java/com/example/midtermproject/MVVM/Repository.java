package com.example.midtermproject.MVVM;

import androidx.annotation.NonNull;

import com.example.midtermproject.AppController;
import com.example.midtermproject.Model.ModelCoffee;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Repository {

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    //ArrayList<ModelCoffee> coffeeModelList = new ArrayList<>();

    CoffeeList interfaceCoffeeList;

    public Repository(CoffeeList interfaceCoffeeList) {
        this.interfaceCoffeeList = interfaceCoffeeList;
    }

    public void getCoffee(){
        firebaseFirestore.collection("Coffee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    AppController.listModelCoffee.clear();
                    for(DocumentSnapshot ds: task.getResult().getDocuments())
                    {
                        ModelCoffee modelCoffee = ds.toObject(ModelCoffee.class);
                        AppController.listModelCoffee.add(modelCoffee);

                        interfaceCoffeeList.coffeeLists(AppController.listModelCoffee);

                    }
                }

            }
        });
    }

    public interface CoffeeList{
        void coffeeLists(ArrayList<ModelCoffee> modelCoffees);
    }
}
