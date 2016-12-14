// Adapted from https://android--examples.blogspot.com.br/2015/05/how-to-use-numberpicker-in-android.html

package com.example.diego.imc;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.NumberPicker;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        final NumberPicker altura = (NumberPicker) findViewById(R.id.altura);
        final NumberPicker peso = (NumberPicker) findViewById(R.id.peso);

        //Set TextView text color
        tv.setTextColor(Color.parseColor("#ffd32b3b"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        altura.setMinValue(145);
        peso.setMinValue(30);
        //Specify the maximum value/number of NumberPicker
        altura.setMaxValue(250);
        peso.setMaxValue(200);
        //Set default value
        altura.setValue(170);
        peso.setValue(70);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        altura.setWrapSelectorWheel(true);
        peso.setWrapSelectorWheel(true);

        // Set scroll speed
        altura.setOnLongPressUpdateInterval(100);
        peso.setOnLongPressUpdateInterval(100);

        //Set a value change listener for NumberPicker
        altura.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override

            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                double alt = newVal;
                double pes = peso.getValue();
                double imc = Math.round((pes / Math.pow(alt, 2)) * 10000);
                //Display the newly selected number from picker
                tv.setText("IMC : " + imc );
            }
        });

        peso.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                double alt = altura.getValue();
                double pes = newVal;
                double imc = Math.round((pes / Math.pow(alt, 2)) * 10000);
                //Display the newly selected number from picker
                tv.setText("IMC : " + imc );
            }
        });

    }
}