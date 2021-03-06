package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class CoversionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Conversion Activity", "Activity Creation Started");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coversion);

        final Button convertButton = findViewById(R.id.btnConvert);
        convertButton.setOnClickListener(this);

        Log.d("Conversion Activity", "Activity Creation Finished");
    }

    public void onClick(View v) {
        Spinner convertFrom = findViewById(R.id.sprFrom);
        Spinner convertTo = findViewById(R.id.sprFrom2);

        int from = base(convertFrom.getSelectedItemPosition());
        int to = base(convertTo.getSelectedItemPosition());

        if (v.getId() == R.id.btnConvert) {
            try {
                TextView outputText = findViewById(R.id.txtFrom3);
                EditText input = findViewById(R.id.etxtToConvert);
                outputText.setText(BaseConverer.covertBase(input.getText().toString(), to, from));
            }
            catch (Exception e) {
                TextView outputText = findViewById(R.id.txtFrom3);
                outputText.setText("Invalid base use");
            }
        }
    }

    public int base(int selectedBase){
        int base = 0;
        switch (selectedBase){
            case 0:
                base = 2;
                break;
            case 1:
                base = 8;
                break;
            case 2:
                base = 10;
                break;
            case 3:
                base = 16;
                break;
        }

        return base;
    }

}
