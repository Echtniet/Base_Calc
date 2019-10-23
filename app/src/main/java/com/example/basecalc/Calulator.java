package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class Calulator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public int base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulator);
        String[] baseArray = {"Base 2", "Base 8", "Base 10", "Base 16"};
        Spinner mathBase = findViewById(R.id.sprBase);
        int layout = R.layout.support_simple_spinner_dropdown_item;
        ArrayAdapter<String> dropDown = new ArrayAdapter<>(this, layout, baseArray);
        mathBase.setOnItemSelectedListener(this);
        mathBase.setAdapter(dropDown);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {
        if(pos == 0){
            base = 2;
        }else if(pos == 1){
            base = 8;
        }else if(pos == 2){
            base = 10;
        }else {
            base = 16;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapter) {

    }

    public void onItemClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case (R.id.btn0):

                break;
            case (R.id.btn1):

                break;
            case (R.id.btn2):

                break;
            case (R.id.btn3):

                break;
            case (R.id.btn4):

                break;
            case (R.id.btn5):

                break;
            case (R.id.btn6):

                break;
            case (R.id.btn7):

                break;
            case (R.id.btn8):

                break;
            case (R.id.btn9):

                break;
            case (R.id.btnA):

                break;
            case (R.id.btnB):

                break;
            case (R.id.btnC):

                break;
            case (R.id.btnD):

                break;
            case (R.id.btnE):

                break;
            case (R.id.btnF):

                break;
            case (R.id.btnClear):

                break;
            case (R.id.btnPM):

                break;
            case (R.id.btnPren):

                break;
            case (R.id.btnDivide):

                break;
            case (R.id.btnMul):

                break;
            case (R.id.btnMinus):

                break;
            case (R.id.btnPlus):

                break;
            case (R.id.btnEquals):

                break;
            case (R.id.btnDot):

                break;
        }
    }
}
