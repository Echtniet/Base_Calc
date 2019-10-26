package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Integer.parseInt;


public class Calulator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String answer;
    private String operator;
    private int base = 10;
    /*
        index 0: Num of items in current input buffer
        index 1: Keeps track of the current number being positive or negative
     */
    private int[] numCtrlInfo ={0, 0};

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
        int fromBase = base;
        if(pos == 0){
            base = 2;
        }else if(pos == 1){
            base = 8;
        }else if(pos == 2){
            base = 10;
        }else {
            base = 16;
        }
        Log.d("CALC-DEBUG", "onItemSelected: Converting the string " + displayText + " from " + fromBase + " to " + base);
        display.setText(BaseConverer.covertBase(displayText, base, fromBase));
//        recolorItems();
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

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();


        if(numCtrlInfo[0] == 0){
            outputText.setText("");
        }
        switch (viewId) {
            case (R.id.btn0):
                outputText.setText(outputText.getText().toString() + "0");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn1):
                outputText.setText(outputText.getText().toString() + "1");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn2):
                if(base == 2){ break; }
                outputText.setText(outputText.getText().toString() + "2");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn3):
                if(base == 2){ break; }
                outputText.setText(outputText.getText().toString() + "3");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn4):
                if(base == 2){ break; }
                outputText.setText(outputText.getText().toString() + "4");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn5):
                if(base == 2){ break; }
                outputText.setText(outputText.getText().toString() + "5");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn6):
                if(base == 2){ break; }
                outputText.setText(outputText.getText().toString() + "6");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn7):
                if(base == 2){ break; }
                outputText.setText(outputText.getText().toString() + "7");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn8):
                if(base == 2 || base == 8){ break; }
                outputText.setText(outputText.getText().toString() + "8");
                numCtrlInfo[0]++;
                break;
            case (R.id.btn9):
                if(base == 2 || base == 8){ break; }
                outputText.setText(outputText.getText().toString() + "9");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnA):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "a");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnB):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "b");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnC):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "c");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnD):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "d");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnE):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "e");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnF):
                if(base != 16){ break; }
                outputText.setText(outputText.getText().toString() + "f");
                numCtrlInfo[0]++;
                break;
            case (R.id.btnClear):
                outputText.setText("0");
                numCtrlInfo[0] = 0;
                break;
            case (R.id.btnPM):
                if (numCtrlInfo[1] == 0){
                    outputText.setText("- " + outputText.getText().toString());
                    numCtrlInfo[1] = 1;
                } else {
                    outputText.setText(outputText.getText().toString().replace("- ", ""));
                    numCtrlInfo[1] = 0;
                }
                break;
            case (R.id.btnPren):

                break;
            case (R.id.btnDivide):
                if (answer == null){
                    answer = outputText.getText().toString();
                }else{
                    answer = BaseConverer.divide(answer, outputText.getText().toString(), base);
                    outputText.setText(answer);
                    HitModel.getModel().myHitory.add(parseInt(answer));
                    try{
                        edit.putString("calculation",Serialization.toString(HitModel.getModel().myHitory));
                        edit.commit();
                    }catch(Exception e){

                    }
                }
                numCtrlInfo[0] = 0;
                operator = "/";
                break;
            case (R.id.btnMul):
                if (answer == null){
                    answer = outputText.getText().toString();
                }else{
                    answer = BaseConverer.mul(outputText.getText().toString(), answer, base);
                    outputText.setText(answer);
                    HitModel.getModel().myHitory.add(parseInt(answer));
                    try{
                        edit.putString("calculation",Serialization.toString(HitModel.getModel().myHitory));
                        edit.commit();
                    }catch(Exception e){

                    }
                }
                numCtrlInfo[0] = 0;
                operator = "*";
                break;
            case (R.id.btnMinus):
                if (answer == null){
                    answer = outputText.getText().toString();
                }else{
                    answer = BaseConverer.sub(outputText.getText().toString(), answer, base);
                    outputText.setText(answer);
                    HitModel.getModel().myHitory.add(parseInt(answer));
                    try{
                        edit.putString("calculation",Serialization.toString(HitModel.getModel().myHitory));
                        edit.commit();
                    }catch(Exception e){

                    }
                }
                numCtrlInfo[0] = 0;
                operator = "-";
                break;
            case (R.id.btnPlus):
                if (answer == null){
                    answer = outputText.getText().toString();
                }else{
                    answer = BaseConverer.add(answer, outputText.getText().toString(), base);
                    outputText.setText(answer);
                    HitModel.getModel().myHitory.add(parseInt(answer));
                    try{
                        edit.putString("calculation",Serialization.toString(HitModel.getModel().myHitory));
                        edit.commit();
                    }catch(Exception e){

                    }
                }
                numCtrlInfo[0] = 0;
                operator = "+";
                break;
            case (R.id.btnEquals):
                if (operator == null){ break; }
                switch (operator){
                    case("+"):
                        answer = BaseConverer.add(outputText.getText().toString(), answer, base);
                        break;
                    case("-"):
                        answer = BaseConverer.sub(outputText.getText().toString(), answer, base);
                        break;
                    case("/"):
                        answer = BaseConverer.divide(answer, outputText.getText().toString(), base);
                        break;
                    case("*"):
                        answer = BaseConverer.mul(answer, outputText.getText().toString(), base);
                        break;
                }
                outputText.setText(answer);
                HitModel.getModel().myHitory.add(parseInt(answer));
                try{
                    edit.putString("calculation",Serialization.toString(HitModel.getModel().myHitory));
                    edit.commit();
                }catch(Exception e){

                }
                operator = null;
                numCtrlInfo[0] = 0;
                numCtrlInfo[1] = 0;
                break;
            case (R.id.btnDot):

                break;
        }
    }
}
