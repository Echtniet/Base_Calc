package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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

    }
    public void outputClicked(View v){
//        convertFrom = findViewById(R.id.timeForm1);
//        convertTo = findViewById(R.id.timeForm2);
        EditText input = findViewById(R.id.txtToConvert2);

        /*
        0: Seconds
        1: Minutes
        2: Hours
        3: Days
        4: Months
        5: Years
         */
        switch(convertFrom.getSelectedItemPosition()){
            case 0:
                secToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            case 1:
                minToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            case 2:
                hrsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            case 3:
                daysToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            case 4:
                monthsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            case 5:
                yearsToOther(Double.parseDouble(input.getText().toString()), convertTo.getSelectedItemPosition());
                break;
            default:
                //HOW DID YOU GET HERE!
        }

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

                break;
            //Minutes
            case 1:

                break;
            //Hours
            case 2:

                break;
            //Days
            case 3:

                break;
            //Months
            case 4:

                break;
            //Years
            case 5:

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

                break;
            //Minutes
            case 1:

                break;
            //Hours
            case 2:

                break;
            //Days
            case 3:

                break;
            //Months
            case 4:

                break;
            //Years
            case 5:

                break;
            //How?
            default:
                //HOW DID YOU GET HERE!
        }
        return answer;
    }
}
