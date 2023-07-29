package com.example.midtermproject.Adapter;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.midtermproject.FragmentHistory;
import com.example.midtermproject.FragmentOnGoing;

public class AdapterViewPager extends FragmentStateAdapter {
    public AdapterViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public AdapterViewPager(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:{
                return new FragmentOnGoing();
            }
            case 1:{
                return new FragmentHistory();
            }
            default:{
                return new FragmentOnGoing();
            }
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
