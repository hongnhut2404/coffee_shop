package com.example.midtermproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private Button btnAdd, btnMinus, btnDouble, btnSingle;
    private TextView coffeeQuantity;
    private int quantity = 1;
    private int totalPrice = 0;
    private int price = 0;

    private ImageButton btnBack;
    private ImageButton btnHot, btnCold, btnSmall, btnMedium, btnBig, btn1Ice, btn2Ice, btn3Ice;
    private View mView;

    public FragmentCoffeeDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_coffee_detail, container, false);
        coffeeName = mView.findViewById(R.id.textCoffeeName);
        coffeePrice = mView.findViewById(R.id.textCoffeePrice);
        coffeeImage = mView.findViewById(R.id.imageCoffeeDetail);
        btnBack = mView.findViewById(R.id.buttonBack);
        btnAdd = mView.findViewById(R.id.incrementCoffee);
        btnMinus = mView.findViewById(R.id.decrementCoffee);
        coffeeQuantity = mView.findViewById(R.id.textQuantity);

        btnHot = mView.findViewById(R.id.buttonSelectHot);
        btnCold = mView.findViewById(R.id.buttonSelectCold);
        btnSingle = mView.findViewById(R.id.buttonSingleShot);
        btnDouble = mView.findViewById(R.id.buttonDoubleShot);
        btnSmall = mView.findViewById(R.id.buttonSelectSmall);
        btnMedium = mView.findViewById(R.id.buttonSelectMedium);
        btnBig = mView.findViewById(R.id.buttonSelectBig);
        btn1Ice = mView.findViewById(R.id.buttonSelect1Ice);
        btn2Ice = mView.findViewById(R.id.buttonSelect2Ice);
        btn3Ice = mView.findViewById(R.id.buttonSelect3Ice);

        //get Arguments from Fragment Menu
        Bundle bundleReceive = getArguments();
        if (bundleReceive != null) {
            ModelCoffee modelCoffee = (ModelCoffee) bundleReceive.get("object_coffee");
            if (modelCoffee != null) {
                coffeeName.setText(modelCoffee.getCoffeeName());
                coffeePrice.setText("$" + modelCoffee.getPrice());
                Glide.with(mView).load(modelCoffee.getImageURL()).into(coffeeImage);
                price = modelCoffee.getPrice();

            }
        }

        //Select Cold or Hot
        btnHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHot.setAlpha(1.0f);
                btnCold.setAlpha(0.2f);
            }
        });

        btnCold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHot.setAlpha(0.2f);
                btnCold.setAlpha(1.0f);
            }
        });

        //Select Size
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSmall.setAlpha(1.0f);
                btnMedium.setAlpha(0.2f);
                btnBig.setAlpha(0.2f);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSmall.setAlpha(0.2f);
                btnMedium.setAlpha(1.0f);
                btnBig.setAlpha(0.2f);
            }
        });

        btnBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSmall.setAlpha(0.2f);
                btnMedium.setAlpha(0.2f);
                btnBig.setAlpha(1.0f);
            }
        });

        //Select Ice
        btn1Ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Ice.setAlpha(1.0f);
                btn2Ice.setAlpha(0.2f);
                btn3Ice.setAlpha(0.2f);
            }
        });

        btn2Ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Ice.setAlpha(0.2f);
                btn2Ice.setAlpha(1.0f);
                btn3Ice.setAlpha(0.2f);
            }
        });

        btn3Ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Ice.setAlpha(0.2f);
                btn2Ice.setAlpha(0.2f);
                btn3Ice.setAlpha(1.0f);
            }
        });



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = quantity + 1;
                coffeeQuantity.setText(String.valueOf(quantity));
                totalPrice = quantity * price;
                coffeePrice.setText("$" + String.valueOf(totalPrice));

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity = quantity - 1;
                    coffeeQuantity.setText(String.valueOf(quantity));
                    totalPrice = quantity * price;
                    coffeePrice.setText("$" + String.valueOf(totalPrice));
                } else {

                }
            }
        });


        return mView;
    }

    public void onViewCreated(View view, Bundle saveInstanceState) {
    }
}