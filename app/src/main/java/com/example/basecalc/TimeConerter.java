package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

public class TimeConerter extends AppCompatActivity {

    private Spinner convertFrom;
    private Spinner convertTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_conerter);
        convertFrom = findViewById(R.id.timeForm1);
        convertTo = findViewById(R.id.timeForm2);

        convertFrom.setSelection(0, false);
        convertTo.setSelection(1, false);

        EditText input = findViewById(R.id.txtToConvert2);

        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_DONE){
                    outputClicked();
                }
                return false;
            }
        });

    }
    public void outputClicked(View v){

        EditText input = findViewById(R.id.txtToConvert2);
        TextView output = findViewById(R.id.timeOutTV);
        Double converted = 0.0;


        switch(convertFrom.getSelectedItemPosition()){
            //Seconds
            case 0:
                converted = secToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Minutes
            case 1:
                converted = minToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Hours
            case 2:
                converted = hrsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Days
            case 3:
                converted = daysToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Months
            case 4:
                converted = monthsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Years
            case 5:
                converted = yearsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            default:
                //HOW DID YOU GET HERE!
        }
        output.setText(Double.toString(converted));
    }
    public double secToOther(Double timeToConvert, int toPos){
        Double answer = 0.0;

        switch(convertTo.getSelectedItemPosition()) {
            //Seconds
            case 0:
                answer = timeToConvert;
                break;
            //Minutes
            case 1:
                answer = timeToConvert/60;
                break;
            //Hours
            case 2:
                answer = timeToConvert/3600;
                break;
            //Days
            case 3:
                answer = timeToConvert/86400;
                break;
            //Months
            case 4:
                answer = timeToConvert/2.628e+6;
                break;
            //Years
            case 5:
                answer = timeToConvert/3.154e+7;
                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
    public double minToOther(Double timeToConvert, int toPos){
        Double answer = 0.0;
        switch(convertTo.getSelectedItemPosition()) {
            //Seconds
            case 0:
                answer = timeToConvert*60;
                break;
            //Minutes
            case 1:
                answer = timeToConvert;
                break;
            //Hours
            case 2:
                answer = timeToConvert/60;
                break;
            //Days
            case 3:
                answer = timeToConvert/1440;
                break;
            //Months
            case 4:
                answer = timeToConvert/43800.048;
                break;
            //Years
            case 5:
                answer = timeToConvert/525600;
                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
    public double hrsToOther(Double timeToConvert, int toPos){
        Double answer = 0.0;
        switch(convertTo.getSelectedItemPosition()) {
            //Seconds
            case 0:
                answer = timeToConvert*3600;
                break;
            //Minutes
            case 1:
                answer = timeToConvert*60;
                break;
            //Hours
            case 2:
                answer = timeToConvert;
                break;
            //Days
            case 3:
                answer = timeToConvert/24;
                break;
            //Months
            case 4:
                answer = timeToConvert/730.001;
                break;
            //Years
            case 5:
                answer = timeToConvert/8760;
                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
    public double daysToOther(Double timeToConvert, int toPos){
        Double answer = 0.0;
        switch(convertTo.getSelectedItemPosition()) {
            //Seconds
            case 0:
                answer = timeToConvert*86400;
                break;
            //Minutes
            case 1:
                answer = timeToConvert*1440;
                break;
            //Hours
            case 2:
                answer = timeToConvert*24;
                break;
            //Days
            case 3:
                answer = timeToConvert;
                break;
            //Months
            case 4:
                answer = timeToConvert/30.417;
                break;
            //Years
            case 5:
                answer = timeToConvert/365;
                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
    public double monthsToOther(Double timeToConvert, int toPos){
        Double answer = 0.0;
        switch(convertTo.getSelectedItemPosition()) {
            //Seconds
            case 0:
                answer = timeToConvert*2.628e+6;
                break;
            //Minutes
            case 1:
                answer = timeToConvert*43800.048;
                break;
            //Hours
            case 2:
                answer = timeToConvert*730.001;
                break;
            //Days
            case 3:
                answer = timeToConvert*30.417;
                break;
            //Months
            case 4:
                answer = timeToConvert;
                break;
            //Years
            case 5:
                answer = timeToConvert/12;
                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
    public double yearsToOther(Double timeToConvert, int toPos){
        Double answer = 0.0;
        switch(convertTo.getSelectedItemPosition()) {
            //Seconds
            case 0:
                answer = timeToConvert*3.154e+7;
                break;
            //Minutes
            case 1:
                answer = timeToConvert*525600;
                break;
            //Hours
            case 2:
                answer = timeToConvert*8760;
                break;
            //Days
            case 3:
                answer = timeToConvert*365;
                break;
            //Months
            case 4:
                answer = timeToConvert*12;
                break;
            //Years
            case 5:
                answer = timeToConvert;
                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
    public void outputClicked(){

        EditText input = findViewById(R.id.txtToConvert2);
        TextView output = findViewById(R.id.timeOutTV);
        Double converted = 0.0;


        switch(convertFrom.getSelectedItemPosition()){
            //Seconds
            case 0:
                converted = secToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Minutes
            case 1:
                converted = minToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Hours
            case 2:
                converted = hrsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Days
            case 3:
                converted = daysToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Months
            case 4:
                converted = monthsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            //Years
            case 5:
                converted = yearsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            default:
                //HOW DID YOU GET HERE!
        }
        output.setText(Double.toString(converted));
    }
}
