package com.example.islamicapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.islamicapplication.R;
import com.example.islamicapplication.adapter.VersesAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.islamicapplication.helper.Constant.FILE_NAME;
import static com.example.islamicapplication.helper.HelperMethod.readFileFromAssets;

public class SuraDetailsActivity extends AppCompatActivity {


    @BindView(R.id.SuraDetailsRecyclerView)
    RecyclerView SuraDetailsRecyclerView;

    //var
    private ArrayList<String> verses;
    private VersesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String suraName = intent.getStringExtra(FILE_NAME);

        verses = readFileFromAssets(this, suraName);

        layoutManager = new LinearLayoutManager(this);
        adapter = new VersesAdapter(verses);
        SuraDetailsRecyclerView.setLayoutManager(layoutManager);
        SuraDetailsRecyclerView.setAdapter(adapter);

    }
}
