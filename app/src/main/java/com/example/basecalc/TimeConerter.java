package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        
    }
    public void secToOther(Double time1, Double time2){

    }
    public void minToOther(Double time1, Double time2){

    }
    public void hrsToOther(Double time1, Double time2){

    }
    public void daysToOther(Double time1, Double time2){

    }
    public void monthsToOther(Float time1, Float time2){

    }
}
