package com.example.midtermproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.transition.Visibility;

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
import com.example.midtermproject.Model.ModelCoffeeOrder;
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

    private int quantity = 1, price = 0, totalPrice = 0, size = 0, ice = 0, select = 0, shot = 0;
    private double weight = 1;
    private ModelCoffee modelCoffee;
    private ModelCoffeeOrder modelCoffeeOrder;
    private Button btnAddToCart;
    private ImageButton btnBack;
    private ImageButton btnToCart;
    private ImageButton btnStay, btnAway, btnSmall, btnMedium, btnBig, btn1Ice, btn2Ice, btn3Ice;
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
        btnAddToCart = mView.findViewById(R.id.btnAddToCart);
        btnToCart = mView.findViewById(R.id.buttonCart);

        btnStay = mView.findViewById(R.id.buttonSelectStay);
        btnAway = mView.findViewById(R.id.buttonSelectAway);
        btnSingle = mView.findViewById(R.id.buttonSingleShot);
        btnDouble = mView.findViewById(R.id.buttonDoubleShot);
        btnSmall = mView.findViewById(R.id.buttonSelectSmall);
        btnMedium = mView.findViewById(R.id.buttonSelectMedium);
        btnBig = mView.findViewById(R.id.buttonSelectBig);
        btn1Ice = mView.findViewById(R.id.buttonSelect1Ice);
        btn2Ice = mView.findViewById(R.id.buttonSelect2Ice);
        btn3Ice = mView.findViewById(R.id.buttonSelect3Ice);

        modelCoffeeOrder = new ModelCoffeeOrder();

        btnToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), CartActivity.class);
                requireActivity().startActivity(intent);
            }
        });

        //Change activity
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelCoffeeOrder.setAttribute(modelCoffee, size, shot, quantity, ice, select);
                Intent intent = new Intent(getContext(), CartActivity.class);
                intent.putExtra("object_coffee_order", modelCoffeeOrder);
                getActivity().startActivity(intent);

            }
        });

        //get Arguments from Fragment Menu
        Bundle bundleReceive = getArguments();
        if (bundleReceive != null) {
            modelCoffee = (ModelCoffee) bundleReceive.get("object_coffee");
            if (modelCoffee != null) {
                coffeeName.setText(modelCoffee.getCoffeeName());
                coffeePrice.setText("$" + modelCoffee.getPrice());
                Glide.with(mView).load(modelCoffee.getImageURL()).into(coffeeImage);
                price = modelCoffee.getPrice();

            }
        }

        //Select Stay or Away
        btnStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStay.setAlpha(1.0f);
                btnAway.setAlpha(0.2f);
                select = 0; //0: stay and 1: away
            }
        });

        btnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStay.setAlpha(0.2f);
                btnAway.setAlpha(1.0f);
                select = 1; //0: stay and 1: away
            }
        });

        //Select Size
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSmall.setAlpha(1.0f);
                btnMedium.setAlpha(0.2f);
                btnBig.setAlpha(0.2f);
                weight = 1;
                size = 0; // 0:small, 1:medium, 2: large
                totalPrice = (int) (quantity * price * weight);
                coffeePrice.setText("$" + String.valueOf(totalPrice));
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSmall.setAlpha(0.2f);
                btnMedium.setAlpha(1.0f);
                btnBig.setAlpha(0.2f);
                weight = 1.5;
                size = 1; // 0:small, 1:medium, 2: large
                totalPrice = (int) (quantity * price * weight);
                coffeePrice.setText("$" + String.valueOf(totalPrice));
            }
        });

        btnBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSmall.setAlpha(0.2f);
                btnMedium.setAlpha(0.2f);
                btnBig.setAlpha(1.0f);
                weight = 2;
                size = 2; // 0:small, 1:medium, 2: large
                totalPrice = (int) (quantity * price * weight);
                coffeePrice.setText("$" + String.valueOf(totalPrice));
            }
        });

        //Select Ice
        btn1Ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Ice.setAlpha(1.0f);
                btn2Ice.setAlpha(0.2f);
                btn3Ice.setAlpha(0.2f);
                ice = 0; //0: one ice, 1: two ice, 2: three ice
            }
        });

        btn2Ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Ice.setAlpha(0.2f);
                btn2Ice.setAlpha(1.0f);
                btn3Ice.setAlpha(0.2f);
                ice = 1; //0: one ice, 1: two ice, 2: three ice
            }
        });

        btn3Ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Ice.setAlpha(0.2f);
                btn2Ice.setAlpha(0.2f);
                btn3Ice.setAlpha(1.0f);
                ice = 2; //0: one ice, 1: two ice, 2: three ice
            }
        });

        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSingle.setAlpha(1.0f);
                btnDouble.setAlpha(0.2f);
                shot = 0; //0: single and 1: double
            }
        });

        btnDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSingle.setAlpha(0.2f);
                btnDouble.setAlpha(1.0f);
                shot = 1; //0: single and 1: double
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
                totalPrice = (int) (quantity * price * weight);
                coffeePrice.setText("$" + String.valueOf(totalPrice));

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity = quantity - 1;
                    coffeeQuantity.setText(String.valueOf(quantity));
                    totalPrice = (int) (quantity * price * weight);
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