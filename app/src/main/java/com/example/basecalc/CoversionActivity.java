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

public class CoversionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Conversion Activity", "Activity Creation Started");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coversion);

        Spinner convertFrom = findViewById(R.id.sprFrom);
        Spinner convertTo = findViewById(R.id.sprFrom2);
        int layout = R.layout.support_simple_spinner_dropdown_item;

        convertFrom.setSelection(0, false);
        convertTo.setSelection(1, false);
        
        convertFrom.setOnItemSelectedListener(this);
        convertTo.setOnItemSelectedListener(this);


        Log.d("Conversion Activity", "Activity Creation Finished");

    }

    @Override
    public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {
        TextView display = findViewById(R.id.txtFrom3);
        String displayText = display.getText().toString();



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapter) {

    }
}
