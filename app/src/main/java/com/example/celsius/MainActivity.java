package com.example.celsius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final double FORMULA_FRACTION = 1.8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText celsiusDegrees = findViewById(R.id.celsius_degrees);
        TextView fahrenheitDegrees = findViewById(R.id.fahrenheit_degrees);
        fahrenheitDegrees.setEnabled(false);
        Button convertButton = findViewById(R.id.convert_button);

        convertButton.setOnClickListener(v -> {
            if(!celsiusDegrees.getText().toString().isEmpty()) {
                double degrees = setFahrenheitDegrees(celsiusDegrees.getText().toString());
                String result = String.valueOf(Math.ceil(degrees));
                fahrenheitDegrees.setText(String.format("%s °F", result));
            } else {
                fahrenheitDegrees.setText("");
                Toast.makeText(this,"Don't forget to type something",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double setFahrenheitDegrees(String celsius) {
        double degrees = Double.parseDouble(celsius);
        return (degrees * FORMULA_FRACTION) + 32;
    }
}