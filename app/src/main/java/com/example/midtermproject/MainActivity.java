package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.midtermproject.Model.ModelCoffee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentCoffeeMenu, new FragmentCoffeeMenu());
        fragmentTransaction.commit();

    }

    public void goToDetailFragment(ModelCoffee modelCoffee)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        FragmentCoffeeDetail fragmentCoffeeDetail = new FragmentCoffeeDetail();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_coffee", modelCoffee);
        fragmentCoffeeDetail.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentCoffeeMenu, fragmentCoffeeDetail);
        fragmentTransaction.addToBackStack(FragmentCoffeeDetail.TAG);
        fragmentTransaction.commit();
    }

}