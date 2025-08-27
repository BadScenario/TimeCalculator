package com.example.timecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView timeCalculatorTV;
    private EditText firstOperandET;
    private EditText secondOperandET;
    private Button plusBTN;
    private Button minusBTN;
    private TextView resultTV;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeCalculatorTV = findViewById(R.id.timeCalculatorTV);
        firstOperandET = findViewById(R.id.firstOperandET);
        secondOperandET = findViewById(R.id.secondOperandET);

        plusBTN = findViewById(R.id.plusBTN);
        minusBTN = findViewById(R.id.minusBTN);
        plusBTN.setOnClickListener(this);
        minusBTN.setOnClickListener(this);

        resultTV = findViewById(R.id.resultTV);

    }

    @Override
    public void onClick(View v) {
        if (firstOperandET.getText().isEmpty() || secondOperandET.getText().isEmpty()) return;
        String result = "";
        String first = firstOperandET.getText().toString();
        String second = secondOperandET.getText().toString();
        if (v.getId() == R.id.plusBTN) {
            result = new Operation().getSum(first,second);
        }
        if (v.getId() == R.id.minusBTN) {
            result = new Operation().getDiv(first,second);
        }
        resultTV.setText(result.toString());
    }
}