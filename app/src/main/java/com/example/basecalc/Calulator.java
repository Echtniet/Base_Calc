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

import org.w3c.dom.Text;

public class Calulator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int base;
    private int[] ctrlInfo ={0};

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
        mathBase.setSelection(2);
        Log.d("CALC-DEBUG", "onCreate: End");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {
        TextView display = findViewById(R.id.txtResult);
        String displayText = display.getText().toString();
        if(pos == 0){
            switch (base){
                case (8):

                    break;
                case (10):
            }
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
        Button[] btnArr = {
                findViewById(R.id.btn2),
                findViewById(R.id.btn3),
                findViewById(R.id.btn4),
                findViewById(R.id.btn5),
                findViewById(R.id.btn6),
                findViewById(R.id.btn7),
                findViewById(R.id.btn8),
                findViewById(R.id.btn9),
                findViewById(R.id.btnA),
                findViewById(R.id.btnB),
                findViewById(R.id.btnC),
                findViewById(R.id.btnD),
                findViewById(R.id.btnE),
                findViewById(R.id.btnF)
        };
        int mergePoint = 0;
        switch (base) {
            case (2):
                mergePoint = 0;
                break;
            case (8):
                mergePoint = 6;
                break;
            case (10):
                mergePoint = 8;
                break;
            case (16):
                mergePoint = 13;
                break;
        }
        for(int bottom = 0; bottom < mergePoint; bottom++){

        }
        for(int top = mergePoint; top < btnArr.length; top++){

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapter) {

    }

    public void onItemClick(View v) {
        TextView outputText = findViewById(R.id.txtResult);
        int viewId = v.getId();
        if(ctrlInfo[0] == 0){
            outputText.setText("");
        }
        switch (viewId) {
            case (R.id.btn0):
                outputText.setText(outputText.getText().toString() + "0");
                ctrlInfo[0]++;
                break;
            case (R.id.btn1):
                outputText.setText(outputText.getText().toString() + "1");
                ctrlInfo[0]++;
                break;
            case (R.id.btn2):
                if(base == 2){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "2");
                ctrlInfo[0]++;
                break;
            case (R.id.btn3):
                if(base == 2){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "3");
                ctrlInfo[0]++;
                break;
            case (R.id.btn4):
                if(base == 2){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "4");
                ctrlInfo[0]++;
                break;
            case (R.id.btn5):
                if(base == 2){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "5");
                ctrlInfo[0]++;
                break;
            case (R.id.btn6):
                if(base == 2){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "6");
                ctrlInfo[0]++;
                break;
            case (R.id.btn7):
                if(base == 2){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "7");
                ctrlInfo[0]++;
                break;
            case (R.id.btn8):
                if(base == 2 || base == 8){
                    break;
                }
                outputText.setText(outputText.getText().toString() + "8");
                ctrlInfo[0]++;
                break;
            case (R.id.btn9):
                if(base == 2 || base == 8){ break; }
                outputText.setText(outputText.getText().toString() + "9");
                ctrlInfo[0]++;
                break;
            case (R.id.btnA):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "a");
                ctrlInfo[0]++;
                break;
            case (R.id.btnB):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "b");
                ctrlInfo[0]++;
                break;
            case (R.id.btnC):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "c");
                ctrlInfo[0]++;
                break;
            case (R.id.btnD):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "d");
                ctrlInfo[0]++;
                break;
            case (R.id.btnE):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "e");
                ctrlInfo[0]++;
                break;
            case (R.id.btnF):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "f");
                ctrlInfo[0]++;
                break;
            case (R.id.btnClear):
                outputText.setText("0");
                ctrlInfo[0] = 0;
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
