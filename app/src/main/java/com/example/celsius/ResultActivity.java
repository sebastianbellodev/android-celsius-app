package com.example.celsius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.celsius.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    public static final String CELSIUS = "Celsius";
    public static final String FAHRENHEIT = "Fahrenheit";

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        String celsius = extras.getString(CELSIUS);
        String fahrenheit = extras.getString(FAHRENHEIT);
        binding.setCelsius(celsius);
        binding.setFahrenheit(fahrenheit);
        paintRow(Double.valueOf(celsius));
    }

    private void paintRow(double celsius){
        double normal = 9, tempered = 20;
        if(celsius <= normal){
            binding.cold.setBackgroundColor(getColor(R.color.purple_200));
        } else if (celsius > normal && celsius <= tempered) {
            binding.tempered.setBackgroundColor(getColor(R.color.purple_500));
        }else{
            binding.warm.setBackgroundColor(getColor(R.color.purple_700));
        }
    }
}

