package com.example.midtermproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.midtermproject.Model.ModelCoffee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class FragmentCoffeeDetail extends Fragment {

    public static final String TAG = FragmentCoffeeDetail.class.getName();

    private TextView coffeeName;
    private ImageView coffeeImage;
    private TextView coffeePrice;

    private ImageButton btnBack;
    private View mView;
    public FragmentCoffeeDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_coffee_detail, container, false);
        coffeeName = mView.findViewById(R.id.textCoffeeName);
        coffeePrice = mView.findViewById(R.id.textCoffeePrice);
        coffeeImage = mView.findViewById(R.id.imageCoffeeDetail);
        btnBack = mView.findViewById(R.id.buttonBack);

        Bundle bundleReceive = getArguments();
        if (bundleReceive != null)
        {
            ModelCoffee modelCoffee = (ModelCoffee) bundleReceive.get("object_coffee");
            if (modelCoffee != null)
            {
                coffeeName.setText(modelCoffee.getCoffeeName());
                coffeePrice.setText("$" + modelCoffee.getPrice());
                Glide.with(mView).load(modelCoffee.getImageURL()).into(coffeeImage);

            }
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager()!= null)
                {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });


        return mView;
    }

    public void onViewCreated(View view, Bundle saveInstanceState)
    {
    }
}