package com.example.midtermproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class FragmentCoffeeDetail extends Fragment {

    private TextView coffeeName;
    private FloatingActionButton btnBack;

    private View mView;
    public FragmentCoffeeDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_coffee_detail, container, false);
        coffeeName = mView.findViewById(R.id.textCoffeeName);
        btnBack = mView.findViewById(R.id.buttonBack);

        return mView;
    }

    public void onViewCreated(View view, Bundle saveInstanceState)
    {
    }
}