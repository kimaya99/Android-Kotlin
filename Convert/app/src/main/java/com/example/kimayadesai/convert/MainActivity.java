package com.example.kimayadesai.convert;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Gravity;


public class MainActivity extends AppCompatActivity {

    private Button convertButton;
    private EditText usd;
    private EditText inr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = (Button) findViewById(R.id.clickMe);
        usd = (EditText) findViewById(R.id.usdText);
        inr  = (EditText) findViewById(R.id.inrText);

        convertButton.setOnClickListener(handler);
        usd.setOnFocusChangeListener(focus);
        inr.setOnFocusChangeListener(focus);


    }

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

            if (usd.getText().toString().trim().length() <= 0 && inr.getText().toString().trim().length() <= 0){
                Toast toast = Toast.makeText(getApplicationContext(),"Please enter values", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM , 0, 600);
                toast.show();
            }

            if (usd.getText().toString().trim().length() > 0 ) {
                double inputvalue = Double.parseDouble(usd.getText().toString());
                double convertedvalue = inputvalue * 63.89;
                inr.setText(String.valueOf(convertedvalue));
                Toast toast = Toast.makeText(getApplicationContext(),"Converted USD -> INR", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM , 0, 600);
                toast.show();
            }

            else if  (inr.getText().toString().trim().length() > 0 ){
                double inputvalue = Double.parseDouble(inr.getText().toString());
                double convertedvalue = inputvalue / 0.016;
                usd.setText(String.valueOf(convertedvalue));
                Toast toast = Toast.makeText(getApplicationContext(),"Converted INR -> USD", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM , 0, 600);
                toast.show();
            }

        }
    };
}

