package br.ifsp.edu.dmo.conversormonetario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final double DOLLAR_VALUE = 4.92;
    private EditText inputEditText;
    private Button toDollarButton;
    private Button toRealButton;
    private TextView outputTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        setClick();
    }

    private void setClick() {

        toDollarButton.setOnClickListener(this);
        toRealButton.setOnClickListener(this);
    }

    private void findById() {
        inputEditText = findViewById(R.id.edittext_value);
        toDollarButton = findViewById(R.id.button_calculate_dolar);
        toRealButton = findViewById(R.id.button_calculate_real);
        outputTextView = findViewById(R.id.textview_output);
    }

    @Override
    public void onClick(View v) {
        if (v == toDollarButton){
            convertRealForDollar();
        }
        if (v == toRealButton){
            convertDollarForReal();
        }
    }

    private void convertRealForDollar() {
        double value = getInputValue();

        value = value / DOLLAR_VALUE;
        outputTextView.setText(String.format("U$ %.2f", value));
    }

    private void convertDollarForReal() {
        double value = getInputValue();

        value = value * DOLLAR_VALUE;
        outputTextView.setText(String.format("R$ %.2f", value));
    }

    private double getInputValue(){
        double value = 0.0;
        String stringValue;

        stringValue = inputEditText.getText().toString();
        try {
            value = Double.valueOf(stringValue);
        } catch (NumberFormatException exception){
            value = 0;
        }
        return value;
    }

}