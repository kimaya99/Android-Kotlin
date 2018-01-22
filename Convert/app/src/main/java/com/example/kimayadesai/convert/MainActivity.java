package com.example.kimayadesai.convert;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Gravity;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity {

    private Button convertbutton;
    private EditText usd;
    private EditText inr;
    int fieldselected = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertbutton = (Button) findViewById(R.id.clickMe);
        usd = (EditText) findViewById(R.id.usdText);
        inr  = (EditText) findViewById(R.id.inrText);

        convertbutton.setOnClickListener(handler);
        usd.setOnFocusChangeListener(focus);
        inr.setOnFocusChangeListener(focus);

        usd.setOnTouchListener(touch1);
        inr.setOnTouchListener(touch2);

    }

    View.OnTouchListener touch1 = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        fieldselected=1;
        return false;
        }
    };

    View.OnTouchListener touch2 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            fieldselected=2;
            return false;
        }
    };

    View.OnFocusChangeListener focus = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                usd.setText("");
                inr.setText("");
            }
        }
    };

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (usd.getText().toString().trim().length() <= 0 && inr.getText().toString().trim().length() <= 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Please enter values", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 600);
                toast.show();
            }


            else {


                if (fieldselected == 1) {
                    double inputvalue = Double.parseDouble(usd.getText().toString());
                    double convertedvalue = inputvalue * 63.89;
                    inr.setText(String.valueOf(convertedvalue));
                    Toast toast = Toast.makeText(getApplicationContext(), "Converted USD -> INR", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 600);
                    toast.show();
                }

                if (fieldselected == 2){
                    double inputvalue2 = Double.parseDouble(inr.getText().toString());
                    double convertedvalue2 = inputvalue2 * 0.016;
                    usd.setText(String.valueOf(convertedvalue2));
                    Toast toast = Toast.makeText(getApplicationContext(), "Converted INR -> USD", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 600);
                    toast.show();
                }

            }
        }
    };
}

