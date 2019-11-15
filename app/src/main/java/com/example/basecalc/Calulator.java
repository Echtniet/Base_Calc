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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static java.lang.Integer.parseInt;


public class Calulator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String TAG = "CALC-DEBUG";
    // answer keeps track of the most recent item put into the calculator
    private String answer;
    // operator keeps track of the most recent operator used
    private String operator;
    // base holds the current base being used
    private int base = 10;
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
        String displayText = display.getText().toString();
        if(displayText.matches("")){
            displayText = "0";
        }
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
            btnArr[bottom].setEnabled(true);
        }
        for(int top = mergePoint; top < btnArr.length; top++){
            btnArr[top].setEnabled(false);
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
                numCtrlInfo[1] = 0;
                answer = null;
                operator = null;
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
                if(numCtrlInfo[2] == 0){
                    outputText.setText(outputText.getText() + " ( ");
                    numCtrlInfo[0]++;
                    numCtrlInfo[2]++;
                    break;
                }
                else if(numCtrlInfo[2] == 1){
                    outputText.setText(outputText.getText() + " ) ");
                    numCtrlInfo[0]++;
                    numCtrlInfo[2]++;
                    break;
                }
                else {
                    break;
                }
            case (R.id.btnDivide):
                if(outputText.getText().toString().matches("")) {
                    outputText.setText("0");
                    break;
                }
                outputText.setText(outputText.getText() + " / ");
                break;
            case (R.id.btnMul):
                if(outputText.getText().toString().matches("")) {
                    outputText.setText("0");
                    break;
                }
                outputText.setText(outputText.getText() + " * ");
                break;
            case (R.id.btnMinus):
                if(outputText.getText().toString().matches("")) {
                    outputText.setText("0");
                    break;
                }
                outputText.setText(outputText.getText() + " - ");
                break;
            case (R.id.btnPlus):
                if(outputText.getText().toString().matches("")) {
                    outputText.setText("0");
                    break;
                }
                outputText.setText(outputText.getText() + " + ");
                break;
            case (R.id.btnEquals):
                if(outputText.getText().toString().matches("")){outputText.setText("0"); break;}
                int temp = parseExp(outputText.getText().toString().split(" "));
                Log.d(TAG, "onItemClick: in equals " + temp);
                outputText.setText("" + temp);
                Log.d(TAG, "onItemClick: Out of Equals");
                break;
            case (R.id.btnDot):
                numCtrlInfo[0]++;
                if(outputText.getText().toString().matches("") || outputText.getText().toString().matches("0")) {
                    outputText.setText("0.");
                    break;
                } outputText.setText(outputText.getText().toString() + ".");
                break;
        }
    }

    // Implementation of the Shuntington-Yard Algo
    private int parseExp(String[] calculation){
        Log.d(TAG, "parseExp: start");
        Stack<String> output = new Stack<>();
        Stack<String> operator = new Stack<>();
        try{
        for(String token:calculation){
            if(isOperator(token)){
                if(operator.size() == 0){operator.push(token); continue;}
                while(!precidence(operator.peek(), token) || !operator.peek().contains("(")){
                    output.push(operator.pop());
                }
                operator.push(token);
                continue;
            }
            else if(token.contains("(")){
                operator.push(token);
                continue;
            }
            else if(token.contains(")")) {
                while(!operator.peek().contains("(")){
                    output.push(operator.pop());
                }
                operator.pop();
                continue;
            }
            output.push(token);
        }
        while(!operator.empty()){
            output.push(operator.pop());
        }}
        catch(Exception e){
            Log.d(TAG, "parseExp: Exception" + e);
        }
        int temp = parseStack(output);
        Log.d(TAG, "parseExp: temp: " + temp);
        return temp;
    }

    // why did i do this to myself
    private int parseStack(Stack<String> math){
        Log.d(TAG, "parseStack: start");
        String[] strArr = new String[math.size()];
        math.copyInto(strArr);
        ArrayList<String> stack = new ArrayList<>();
        stack.addAll(Arrays.asList(strArr));

        while(stack.size() > 1){
            for(int i = 2; i < stack.size(); i++){
                if(isOperator(stack.get(i))){
                    if(stack.get(i).contains("*")){
                        String temp = BaseConverer.mul(stack.get(i-1), stack.get(i-2), base);
                        stack.add(i+1, temp);
                        stack.remove(i);
                        stack.remove(i-1);
                        stack.remove(i-2);
                    }
                    else if(stack.get(i).contains("/")){
                        String temp = BaseConverer.divide(stack.get(i-1), stack.get(i-2), base);
                        stack.add(i+1, temp);
                        stack.remove(i);
                        stack.remove(i-1);
                        stack.remove(i-2);
                    }
                    else if(stack.get(i).contains("+")){
                        String temp = BaseConverer.add(stack.get(i-1), stack.get(i-2), base);
                        stack.add(i+1, temp);
                        stack.remove(i);
                        stack.remove(i-1);
                        stack.remove(i-2);
                    }
                    else if(stack.get(i).contains("-")){
                        String temp = BaseConverer.sub(stack.get(i-1), stack.get(i-2), base);
                        stack.add(i+1, temp);
                        stack.remove(i);
                        stack.remove(i-1);
                        stack.remove(i-2);
                    }
                }
            }
        }
        Log.d(TAG, "parseStack: " + Integer.parseInt(stack.get(0)));
        return Integer.parseInt(stack.get(0));
    }

    private boolean precidence(String topOfStack, String token){
        byte top = 0, tok = 0;
        String[] operators = {"-", "+", "/", "*"};
        for(byte i = 0; i < operators.length; i++){
            if(operators[i].contains(topOfStack)){
                top = i;
            }
            if(operators[i].contains(token)){
                tok = i;
            }
        }
        return top <= tok;
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
