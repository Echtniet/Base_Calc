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
        Log.d("CALC-DEBUG", "onCreate: Entering");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulator);
        String[] baseArray = {"Base 2", "Base 8", "Base 10", "Base 16"};
        Spinner mathBase = findViewById(R.id.sprBase);
        int layout = R.layout.support_simple_spinner_dropdown_item;
        ArrayAdapter<String> dropDown = new ArrayAdapter<>(this, layout, baseArray);
        mathBase.setOnItemSelectedListener(this);
        mathBase.setAdapter(dropDown);
        Log.d("CALC-DEBUG", "onCreate: End");
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
        } recolorItems();
    }

    private void recolorItems(){
        switch (base) {
            case (2):

                break;
            case (8):

                break;
            case (10):

                break;
            case (16):

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapter) {

    }

    public void onItemClick(View v) {
        TextView outputText = findViewById(R.id.txtResult);
        int viewId = v.getId();
        switch (viewId) {
            case (R.id.btn0):
                outputText.setText(outputText.getText().toString() + "0");
                break;
            case (R.id.btn1):
                outputText.setText(outputText.getText().toString() + "1");
                break;
            case (R.id.btn2):
                outputText.setText(outputText.getText().toString() + "2");
                break;
            case (R.id.btn3):
                outputText.setText(outputText.getText().toString() + "3");
                break;
            case (R.id.btn4):
                outputText.setText(outputText.getText().toString() + "4");
                break;
            case (R.id.btn5):
                outputText.setText(outputText.getText().toString() + "5");
                break;
            case (R.id.btn6):
                outputText.setText(outputText.getText().toString() + "6");
                break;
            case (R.id.btn7):
                outputText.setText(outputText.getText().toString() + "7");
                break;
            case (R.id.btn8):
                outputText.setText(outputText.getText().toString() + "8");
                break;
            case (R.id.btn9):
                outputText.setText(outputText.getText().toString() + "9");
                break;
            case (R.id.btnA):
                outputText.setText(outputText.getText().toString() + "a");
                break;
            case (R.id.btnB):
                outputText.setText(outputText.getText().toString() + "b");
                break;
            case (R.id.btnC):
                outputText.setText(outputText.getText().toString() + "c");
                break;
            case (R.id.btnD):
                outputText.setText(outputText.getText().toString() + "d");
                break;
            case (R.id.btnE):
                outputText.setText(outputText.getText().toString() + "e");
                break;
            case (R.id.btnF):
                outputText.setText(outputText.getText().toString() + "f");
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
