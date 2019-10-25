package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class CoversionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Conversion Activity", "Activity Creation Started");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coversion);

        String[] bases = {"Base 2", "Base 8", "Base 10", "Base 16"};

        Spinner convertFrom = findViewById(R.id.sprFrom);
        Spinner convertTo = findViewById(R.id.sprFrom2);
        int layout = R.layout.support_simple_spinner_dropdown_item;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, bases);

        convertFrom.setOnItemSelectedListener(this);
        convertTo.setOnItemSelectedListener(this);

        convertFrom.setAdapter(adapter);
        convertTo.setAdapter(adapter);

        Log.d("Conversion Activity", "Activity Creation Finished");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapter) {

    }
}
