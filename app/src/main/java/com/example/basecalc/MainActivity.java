package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTimeConverter = findViewById(R.id.btnBaseConverter);
        btnTimeConverter.setOnClickListener(this);
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
