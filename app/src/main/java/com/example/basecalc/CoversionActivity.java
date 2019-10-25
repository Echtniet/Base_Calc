package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class CoversionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Conversion Activity", "Activity Creation Started");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coversion);

        Spinner convertFrom = findViewById(R.id.sprFrom);
        Spinner convertTo = findViewById(R.id.sprFrom2);

        Log.d("Conversion Activity", "Activity Creation Finished");

        final Button convertButton = findViewById(R.id.btnConvert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                
            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnConvert) {

        }
    }
}
