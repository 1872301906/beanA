package com.example.data;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.data.adapter.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);

        initData();
    }

    private void initData() {

        fragments = new ArrayList<>();
        BlankFragment fragment = new BlankFragment();
        BlankFragment2 fragment2 = new BlankFragment2();
        fragments.add(fragment);
        fragments.add(fragment2);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(myAdapter);

        tab.setupWithViewPager(vp);

       initDay();
    }

    private void initDay() {

        tab.getTabAt(0).setText("首页").setIcon(R.drawable.selector);
        tab.getTabAt(1).setText("网址").setIcon(R.drawable.selector1);


    }
}
