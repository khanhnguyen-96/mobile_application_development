package com.nnkti.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher{
    Spinner spinnerInp, spinnerOut;
    ImageButton btnSwitch, btnCalculate, btnClear;
    EditText etInp;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Currency Converter by 1411768");

        etInp = findViewById(R.id.et_input);
        etInp.addTextChangedListener(this);
        tvResult = findViewById(R.id.tv_result);

        //Create spinner for currency type input
        spinnerInp = findViewById(R.id.spinner_input);
        ArrayAdapter<String> adapterInp = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Const.currencyName);
        adapterInp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInp.setAdapter(adapterInp);

        //Create spinner for currency type output
        spinnerOut = findViewById(R.id.spinner_output);
        ArrayAdapter<String> adapterOut = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Const.currencyName);
        adapterOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOut.setAdapter(adapterOut);
        spinnerOut.setSelection(2);

        //Create img buttons
        btnSwitch = findViewById(R.id.btn_switch);
        btnSwitch.setOnClickListener(this);
        btnCalculate = findViewById(R.id.btn_quit);
        btnCalculate.setOnClickListener(this);
        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
    }

    private void btnSwitchClicked() {
        int temp = spinnerInp.getSelectedItemPosition();
        spinnerInp.setSelection(spinnerOut.getSelectedItemPosition());
        spinnerOut.setSelection(temp);
    }

    private void btnClearClicked() {
        etInp.setText("");
        tvResult.setText("");
    }

    private void calculate() {
        if (!etInp.getText().toString().isEmpty()) {
            Double value = Double.valueOf(etInp.getText().toString());
            if (!Double.isNaN(value)) {
                double ratioInp = Const.currencyRatio[spinnerInp.getSelectedItemPosition()];
                double ratioOut = Const.currencyRatio[spinnerOut.getSelectedItemPosition()];
                Double result = value*ratioInp/ratioOut;
                tvResult.setText(String.format(Locale.US,"%.2f", result));
            }
        } else {
            tvResult.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_switch:
                btnSwitchClicked();
                break;
            case R.id.btn_clear:
                btnClearClicked();
                break;
            case R.id.btn_quit:
                btnQuitClicked();
                break;
        }
    }

    private void btnQuitClicked() {
        this.finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        calculate();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        calculate();
    }
}
