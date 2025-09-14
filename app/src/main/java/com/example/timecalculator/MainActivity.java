package com.example.timecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView timeCalculatorTV;

    private Toolbar toolbar;
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

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Калькулятор времени");
        getSupportActionBar().setSubtitle("Версия 1.0");

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.resetMenuMain) {
            firstOperandET.getText().clear();
            secondOperandET.getText().clear();
            resultTV.setText("Результат");
            resultTV.setTextColor(getResources().getColor(R.color.black));
            Toast.makeText(this, "Данные очищены", Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.exitMenuMain) {
            finish();
            Toast.makeText(this, "Приложение закрыто", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (firstOperandET.getText().isEmpty() || secondOperandET.getText().isEmpty()) return;
        String result = "";
        String first = firstOperandET.getText().toString();
        String second = secondOperandET.getText().toString();
        if (v.getId() == R.id.plusBTN) {
            result = new Operation().getSum(first, second);
        }
        if (v.getId() == R.id.minusBTN) {
            result = new Operation().getDiv(first, second);
        }
        resultTV.setText(result);
        resultTV.setTextColor(getResources().getColor(R.color.red));
        Toast.makeText(this, "Результат" + result, Toast.LENGTH_LONG).show();
    }
}