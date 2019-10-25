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
        convertFrom = findViewById(R.id.timeForm1);
        convertTo = findViewById(R.id.timeForm2);
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

        return 0;
    }
    public double minToOther(Double timeToConvert, int toPos){

        return 0;
    }
    public double hrsToOther(Double timeToConvert, int toPos){

        return 0;
    }
    public double daysToOther(Double timeToConvert, int toPos){

        return 0;
    }
    public double monthsToOther(Double timeToConvert, int toPos){

        return 0;
    }
    public double yearsToOther(Double timeToConvert, int toPos){

        return 0;
    }
}
