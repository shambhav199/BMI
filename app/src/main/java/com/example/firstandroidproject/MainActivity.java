package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView result;
        Button calculate;
        EditText edtwt,edtcm,edtf,edti;
        LinearLayout llmain;

        result = findViewById(R.id.result);
        calculate = findViewById(R.id.btncalculate);
        edtwt = findViewById(R.id.edtweight);
        edtf=findViewById(R.id.edtheight);
        edti=findViewById(R.id.edtheightin);
        llmain=findViewById(R.id.llmain);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(edtwt.getText().toString());
                int f=Integer.parseInt(edtf.getText().toString());
                int i=Integer.parseInt(edti.getText().toString());

                int totalin=f*12+i;
                double totalcm=totalin*2.53;
                double totalm=totalcm/100;
                double bmi=wt/(totalm*totalm);

                if(bmi>25){
                    result.setText("You are overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.over));
                }
                else if(bmi<18){
                    result.setText("You are underweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.under));
                }
                else{
                    result.setText("You are healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }

            }
        });
    }
}