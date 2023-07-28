package com.example.midtermproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.Model.ModelUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ModelUser modelUser=ModelUser.getInstance();
    FragmentCoffeeMenu fragmentCoffeeMenu = new FragmentCoffeeMenu();
    FragmentReward fragmentReward = new FragmentReward();
    FragmentMyOrder fragmentMyOrder = new FragmentMyOrder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelUser.setFullName("Loki");
        modelUser.setPhoneNumber("1231512");
        modelUser.setAddress("Ho Chi Minh City");
        modelUser.setEmail("nhutth2404@gmail.com");

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentCoffeeMenu).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.menu)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentCoffeeMenu).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.reward)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentReward).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.order)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentMyOrder).commit();
                    return true;
                }
                return false;
            }
        });

    }

    public void goToDetailFragment(ModelCoffee modelCoffee)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        FragmentCoffeeDetail fragmentCoffeeDetail = new FragmentCoffeeDetail();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_coffee", modelCoffee);
        fragmentCoffeeDetail.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainerView, fragmentCoffeeDetail);
        fragmentTransaction.addToBackStack(FragmentCoffeeDetail.TAG);
        fragmentTransaction.commit();
    }



}