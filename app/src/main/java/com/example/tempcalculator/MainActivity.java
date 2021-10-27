package com.example.tempcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_calculate;
    EditText et_inputTemp;
    RadioButton rb_bttn_celcius, rb_bttn_fahrenhite;
    Float resultAnswer;
    TextView tv_calcultedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_inputTemp = findViewById(R.id.et_inputTemp);
        rb_bttn_celcius = findViewById(R.id.rb_bttn_celcius);
        rb_bttn_fahrenhite = findViewById(R.id.rb_bttn_fahrenhite);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_calcultedAmount = findViewById(R.id.tv_calcultedAmount);

    }

    protected float convertCelciusToFahrenheit(Float value){
        Float ans = (value * 9/5) + 32;
        return ans;
    }

    protected float convertFahrenheightToCelcius(Float value){
        Float ans = (value - 32) * 5/9;
        return ans;
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer(){

        String temp = et_inputTemp.getText().toString();

        if(TextUtils.isEmpty(temp)){
            //Toast.makeText(this, "Please add values", Toast.LENGTH_SHORT).show();

           Toast toast = Toast.makeText(this, "Enter value", Toast.LENGTH_SHORT);
           toast.setGravity(Gravity.TOP|Gravity.LEFT, 100,0);
           toast.show();
        }
        else{
            if(rb_bttn_celcius.isChecked()){
                resultAnswer = convertCelciusToFahrenheit(Float.valueOf(temp));
            }else if(rb_bttn_fahrenhite.isChecked()){
                resultAnswer = convertFahrenheightToCelcius(Float.valueOf(temp));
            }else{
                Toast.makeText(this, "Select temperature type", Toast.LENGTH_SHORT).show();
                resultAnswer = 0.0f;
            }

            tv_calcultedAmount.setText(new Float(resultAnswer).toString());

        }
    }
}