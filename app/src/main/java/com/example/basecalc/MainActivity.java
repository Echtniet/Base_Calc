package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTimeConverter = findViewById(R.id.btnTimeConverter);
        btnTimeConverter.setOnClickListener(this);

        Button btnBaseConverter = findViewById(R.id.btnBaseConverter);
        btnBaseConverter.setOnClickListener(this);

        Button btnCalculator = findViewById(R.id.btnCalculator);
        btnCalculator.setOnClickListener(this);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        try{
            HitModel.getModel().myHitory = (CalcHitory) Serialization.fromString(sp.getString("calculation", null));
        }catch(Exception e){
            
        }
    }

    @Override
    public void onClick(View v) {
        Intent ini = null;
        switch (v.getId()){
            case R.id.btnTimeConverter:
                ini = new Intent(this, TimeConerter.class);
                break;
            case R.id.btnBaseConverter:
                ini = new Intent(this, CoversionActivity.class);
                break;
            case R.id.btnCalculator:
                ini = new Intent(this, Calulator.class);
                break;
        }

        startActivity(ini);
    }
}
