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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static java.lang.Integer.parseInt;


public class Calulator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String TAG = "CALC-DEBUG";
    // answer keeps track of the most recent item put into the calculator
    private String answer = null;
    // operator keeps track of the most recent operator used
    private String operator = null;
    // base holds the current base being used
    private int base = 10;
    private String in1 = null;
    boolean newValue = true;
    /*
        index 0: Num of items in current input buffer
        index 1: Keeps track of the current number being positive or negative
        index 2: Keeps track of if there has been a parenthesis used in the current string
     */
    private int[] numCtrlInfo ={0, 0, 0};

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


        if(answer != null){
            answer = BaseConverer.covertBase(answer, base, fromBase);
        }
        if(in1 != null){
            in1 = BaseConverer.covertBase(in1, base, fromBase);
        }


        display.setText(BaseConverer.covertBase(display.getText().toString(), base, fromBase));
        recolorItems();
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
                findViewById(R.id.btnF),
                findViewById(R.id.btnThisIsADumbFix)
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
                mergePoint = 14;
                break;
        }
        for(int bottom = 0; bottom < mergePoint; bottom++){
            btnArr[bottom].setEnabled(true);
            btnArr[bottom].setBackground(getDrawable(R.drawable.roundbuttongray));
        }
        for(int top = mergePoint; top < btnArr.length; top++){
            btnArr[top].setEnabled(false);
            btnArr[top].setBackground(getDrawable(R.drawable.roundbuttongrayhalf));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapter) {

    }

    public void onItemClick(View v) {
        try {
            TextView outputText = findViewById(R.id.txtResult);
            int viewId = v.getId();

            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();


            /*if (numCtrlInfo[0] == 0) {
                outputText.setText("");
            }*/
            switch (viewId) {
                case (R.id.btn0):
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "0");
                    else
                        outputText.setText("0");
                    break;
                case (R.id.btn1):
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "1");
                    else
                        outputText.setText("1");
                    break;
                case (R.id.btn2):
                    if (base == 2) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "2");
                    else
                        outputText.setText("2");
                    break;
                case (R.id.btn3):
                    if (base == 2) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "3");
                    else
                        outputText.setText("3");
                    break;
                case (R.id.btn4):
                    if (base == 2) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "4");
                    else
                        outputText.setText("4");
                    break;
                case (R.id.btn5):
                    if (base == 2) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "5");
                    else
                        outputText.setText("5");
                    break;
                case (R.id.btn6):
                    if (base == 2) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "6");
                    else
                        outputText.setText("6");
                    break;
                case (R.id.btn7):
                    if (base == 2) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "7");
                    else
                        outputText.setText("7");
                    break;
                case (R.id.btn8):
                    if (base == 2 || base == 8) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "8");
                    else
                        outputText.setText("8");
                    break;
                case (R.id.btn9):
                    if (base == 2 || base == 8) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "9");
                    else
                        outputText.setText("9");
                    break;
                case (R.id.btnA):
                    if (base != 16) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "A");
                    else
                        outputText.setText("A");
                    break;
                case (R.id.btnB):
                    if (base != 16) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "B");
                    else
                        outputText.setText("B");
                    break;
                case (R.id.btnC):
                    if (base != 16) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "C");
                    else
                        outputText.setText("C");
                    break;
                case (R.id.btnD):
                    if (base != 16) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "D");
                    else
                        outputText.setText("D");
                    break;
                case (R.id.btnE):
                    if (base != 16) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "E");
                    else
                        outputText.setText("E");
                    break;
                case (R.id.btnF):
                    if (base != 16) {
                        break;
                    }
                    if (!newValue)
                        outputText.setText(outputText.getText().toString() + "F");
                    else
                        outputText.setText("F");
                    break;
                case (R.id.btnClear):
                    outputText.setText("0");
                    numCtrlInfo[0] = 0;
                    numCtrlInfo[1] = 0;
                    answer = null;
                    operator = null;
                    in1 = null;
                    break;
                case (R.id.btnPM):
                    /*if (numCtrlInfo[1] == 0) {
                        outputText.setText("- " + outputText.getText().toString());
                        numCtrlInfo[1] = 1;
                    } else {
                        outputText.setText(outputText.getText().toString().replace("- ", ""));
                        numCtrlInfo[1] = 0;
                    }*/
                    break;
                case (R.id.btnPren):
                    /*if (numCtrlInfo[2] == 0) {
                        outputText.setText(outputText.getText() + " ( ");
                        numCtrlInfo[0]++;
                        numCtrlInfo[2]++;
                        break;
                    } else if (numCtrlInfo[2] == 1) {
                        outputText.setText(outputText.getText() + " ) ");
                        numCtrlInfo[0]++;
                        numCtrlInfo[2]++;
                        break;
                    } else {
                        break;
                    }*/
                    break;
                case (R.id.btnDivide):
                    if(newValue){
                        operator = "/";
                    }else {
                        if (answer == null) {
                            answer = outputText.getText().toString();
                            operator = "/";
                        } else {
                            in1 = outputText.getText().toString();
                            answer = calculate();
                            outputText.setText(answer);
                            operator = "/";
                            HitModel.getModel().myHitory.add(new CalcObject(answer, "" + base));
                        }
                    }
                    break;
                case (R.id.btnMul):
                    if(newValue){
                        operator = "*";
                    }else {
                        if (answer == null) {
                            answer = outputText.getText().toString();
                            operator = "*";
                        } else {
                            in1 = outputText.getText().toString();
                            answer = calculate();
                            outputText.setText(answer);
                            operator = "*";
                            HitModel.getModel().myHitory.add(new CalcObject(answer, "" + base));
                        }
                    }
                    break;
                case (R.id.btnMinus):
                    if(newValue){
                        operator = "-";
                    }else {
                        if (answer == null) {
                            answer = outputText.getText().toString();
                            operator = "-";
                        } else {
                            in1 = outputText.getText().toString();
                            answer = calculate();
                            outputText.setText(answer);
                            operator = "-";
                            HitModel.getModel().myHitory.add(new CalcObject(answer, "" + base));
                        }
                    }
                    break;
                case (R.id.btnPlus):
                    if(newValue){
                        operator = "+";
                    }else {
                        if (answer == null) {
                            answer = outputText.getText().toString();
                            operator = "+";
                        } else {
                            in1 = outputText.getText().toString();
                            answer = calculate();
                            outputText.setText(answer);
                            operator = "+";
                            HitModel.getModel().myHitory.add(new CalcObject(answer, "" + base));
                        }
                    }
                    break;
                case (R.id.btnEquals):
                    if(answer == null){
                        answer = outputText.getText().toString();
                    }else {
                        in1 = outputText.getText().toString();
                        answer = calculate().toUpperCase();
                        outputText.setText(answer);
                        HitModel.getModel().myHitory.add(new CalcObject(answer, "" + base));
                    }
                    break;
                case (R.id.btnDot):
                    numCtrlInfo[0]++;
                    if (outputText.getText().toString().matches("") || outputText.getText().toString().matches("0")) {
                        outputText.setText("0.");
                        break;
                    }
                    outputText.setText(outputText.getText().toString() + ".");
                    break;
            }
            switch (viewId){
                case R.id.btnDivide:
                case R.id.btnMinus:
                case R.id.btnMul:
                case R.id.btnPlus:
                case R.id.btnClear:
                    newValue = true;
                    break;
                default:
                    newValue = false;
            }

        } catch(Exception e){
            TextView output = findViewById(R.id.txtResult);
            output.setText("");
            numCtrlInfo[0] = 0;
        }

    }

    private String calculate(){
        switch (operator){
            case "+":
                return BaseConverer.add(answer, in1, base);
            case "-":
                return BaseConverer.sub(in1, answer, base);
            case "*":
                return BaseConverer.mul(answer, in1, base);
            case "/":
                return BaseConverer.divide(answer, in1, base);
            default:
                return "0";
        }
    }

    private boolean isOperator(String input){
        String[] opArr = {"+", "-", "*", "/"};
        for(String i:opArr){
            if(input.contains(i)){
                return true;
            }
        }
        return false;
    }
}
