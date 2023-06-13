package com.example.celsius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Button convertButton = findViewById(R.id.convert_button);

        convertButton.setOnClickListener(v -> {
            if(!celsiusDegrees.getText().toString().isEmpty()) {
                String celsius = celsiusDegrees.getText().toString();
                double degrees = setFahrenheitDegrees(celsius);
                String fahrenheit = String.valueOf(Math.ceil(degrees));
                openResultActivity(celsius, fahrenheit);
            } else {
                Toast.makeText(this,"Don't forget to type something",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double setFahrenheitDegrees(String celsius) {
        double degrees = Double.parseDouble(celsius);
        return (degrees * FORMULA_FRACTION) + 32;
    }

    private void openResultActivity(String celsius, String fahrenheit) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.CELSIUS, celsius);
        intent.putExtra(ResultActivity.FAHRENHEIT, fahrenheit);
        startActivity(intent);
    }

}