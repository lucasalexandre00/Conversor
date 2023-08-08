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
    private Button button;
    private TextView outputTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        setClick();
    }

    private void setClick() {
        button.setOnClickListener(this);
    }

    private void findById() {
        inputEditText = findViewById(R.id.edittext_value);
        button = findViewById(R.id.button_calculate);
        outputTextView = findViewById(R.id.textview_output);
    }

    @Override
    public void onClick(View v) {
        if (v == button){
            converter();
        }
    }

    private void converter() {
        double value = 0.0;
        String stringValue;

        stringValue = inputEditText.getText().toString();
        try {
            value = Double.valueOf(stringValue);
        } catch (NumberFormatException exception){
            value = 0;
        }

        value = value/DOLLAR_VALUE;
        outputTextView.setText(String.valueOf(value));
    }

}