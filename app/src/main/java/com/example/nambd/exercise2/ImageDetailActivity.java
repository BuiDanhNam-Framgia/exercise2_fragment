package com.example.nambd.exercise2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import static com.example.nambd.exercise2.MainActivity.BUNDLE;
import static com.example.nambd.exercise2.MainActivity.DATA;
import static com.example.nambd.exercise2.MainActivity.POSITIVE;

@RequiresApi(api = Build.VERSION_CODES.M)
public class ImageDetailActivity extends AppCompatActivity implements View.OnScrollChangeListener {
    private ViewPager viewPager;
    private ViewPagerAdapter mPagerAdapter;
    private ImageDetailAdapter imageAdapter;
    private ArrayList<Integer> data;
    private int pos;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Bundle bundle = getIntent().getBundleExtra(BUNDLE);
        data = (ArrayList<Integer>) bundle.getSerializable(DATA);
        pos = bundle.getInt(POSITIVE);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        recyclerView = findViewById(R.id.recyclerView);
        mPagerAdapter = new ViewPagerAdapter(this, data);
        imageAdapter = new ImageDetailAdapter(data);
        viewPager.setOnScrollChangeListener(this);
        layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(imageAdapter);
        viewPager.setAdapter(mPagerAdapter);
        if (pos <= data.size() - 2) {
            layoutManager.scrollToPosition(pos - 1);
        } else {
            layoutManager.scrollToPosition(pos);
        }
        viewPager.setCurrentItem(pos, true);
    }


    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        pos = viewPager.getCurrentItem();
        layoutManager.scrollToPosition(pos);
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            if (pos == i) {
                recyclerView.getChildAt(i).setBackgroundColor(Color.BLUE);
            } else {
                recyclerView.getChildAt(i).setAlpha((float) 0.4);
            }
        }
    }
}
