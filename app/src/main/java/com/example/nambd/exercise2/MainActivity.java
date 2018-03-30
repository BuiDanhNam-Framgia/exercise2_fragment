package com.example.nambd.exercise2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String DATA = "data";
    public static final String POSITIVE = "positive";
    public static final String BUNDLE = "bundle";
    private GridView gridView;
    private ArrayList<Integer> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gv_content);
        ImageAdapter arrayAdapter = new ImageAdapter(this, R.layout.item_gridview, data);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(R.drawable.addthis);
        data.add(R.drawable.android);
        data.add(R.drawable.image);
        data.add(R.drawable.appledroid);
        data.add(R.drawable.unnamed);
        data.add(R.drawable.ic_launcher_background);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATA, data);
        bundle.putInt(POSITIVE, i);
        intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }
}
