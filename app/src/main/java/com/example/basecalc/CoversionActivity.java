package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class CoversionActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Conversion Activity", "Activity Creation Started");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coversion);

        Spinner convertFrom = findViewById(R.id.sprFrom);
        Spinner convertTo = findViewById(R.id.sprFrom2);
    }


}
