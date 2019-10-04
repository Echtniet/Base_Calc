package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        }

        startActivity(ini);
    }
}
