package com.example.midtermproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midtermproject.Adapter.AdapterViewPager;
import com.google.android.material.tabs.TabLayout;

import org.checkerframework.checker.units.qual.A;


public class FragmentMyOrder extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private AdapterViewPager mAdapterViewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_my_order, container, false);
        mTabLayout = mView.findViewById(R.id.tabLayoutMyOrder);
        mViewPager = mView.findViewById(R.id.viewPagerMyOrder);
        //Note
        mViewPager.setSaveEnabled(false);
        //mViewPager.setOffscreenPageLimit(1);


        mAdapterViewPager = new AdapterViewPager(this);
        mViewPager.setAdapter(mAdapterViewPager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTabLayout.getTabAt(position).select();
            }
        });

        return mView;
    }
}