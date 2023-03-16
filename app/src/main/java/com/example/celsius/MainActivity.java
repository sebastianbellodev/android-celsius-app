package com.example.celsius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final double FORMULA_FRACTION = 1.8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText celsiusDegrees = findViewById(R.id.celsius_degrees);
        EditText fahrenheitDegrees = findViewById(R.id.farenheit_degrees);
        fahrenheitDegrees.setEnabled(false);
        Button convertButton = findViewById(R.id.convert_button);

        convertButton.setOnClickListener(v -> {
            String result = String.valueOf(setFahrenheitDegrees(celsiusDegrees.getText().toString()));
            fahrenheitDegrees.setText(String.format("%s °F", result));
        });
    }

    private double setFahrenheitDegrees(String celsius) {
        double degrees = Double.parseDouble(celsius);
        return (degrees * FORMULA_FRACTION) + 32;
    }
}