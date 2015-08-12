package com.vogella.android.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((RadioGroup) findViewById(R.id.radioGroup1)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                convertTemperature(group);
            }
        });
    }

    public void convertTemperature(View view)
    {
        EditText e = (EditText) findViewById(R.id.editText1);
        if(e.getText() != null && e.getText().length() > 0)
        {
            Float valueToConvert = Float.valueOf(e.getText().toString());
            RadioButton celsiusButton = (RadioButton) findViewById(R.id.celsiusButton);
            RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.fahrenheitButton);
            String result = "%.2f %s = %.2f %s";
            if(celsiusButton.isChecked()) {
                result = String.format(result, valueToConvert, "F",
                        ConverterUtil.convertFahrenheitToCelsius(valueToConvert), "C");
            }
            if(fahrenheitButton.isChecked()) {
                result = String.format(result, valueToConvert, "C",
                        ConverterUtil.convertCelsiusToFahrenheit(valueToConvert), "F");
            }
            ((TextView) findViewById(R.id.resultTextView)).setText(result);
        }
        else
        {
            Toast.makeText(MainActivity.this, R.string.invalidValue, Toast.LENGTH_SHORT).show();
        }
    }
}
