package com.example.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        setTitle("Area Calculator");


        final TextView tv1 = findViewById(R.id.selectshape);
        final EditText et1 = findViewById(R.id.editText1);
        final EditText et2 = findViewById(R.id.editText2);
        final TextView tv2 = findViewById(R.id.textView3);
        final TextView tv3 = findViewById(R.id.textView);

        ImageView triangle = findViewById(R.id.triangleimg);
        triangle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv1.setText("Triangle");
                tv1.setError(null);
                tv3.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);

            }
        });

        ImageView square = findViewById(R.id.squareimg);
        square.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv1.setText("Square");
                tv1.setError(null);
                tv3.setVisibility(View.INVISIBLE);
                et2.setVisibility(View.INVISIBLE);

            }
        });

        ImageView circle = findViewById(R.id.circleimg);
        circle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv1.setText("Circle");
                tv1.setError(null);
                tv3.setVisibility(View.INVISIBLE);
                et2.setVisibility(View.INVISIBLE);
            }
        });


        Button calculate = findViewById(R.id.calcbutton);
        final EditText answer = findViewById(R.id.editText3);
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(tv1.getText().toString() != "Triangle" || tv1.getText().toString() != "Square" ||
                        tv1.getText().toString() != "Circle"){
                    tv1.setError("Kindly Select shape first");
                }
                if(tv1.getText().toString() == "Triangle"){
                    tv1.setError(null);
                    if(!et1.getText().toString().equals("") && !et2.getText().toString().equals("") ) {
                        Double a = Double.parseDouble(et1.getText().toString()) *
                                Double.parseDouble(et2.getText().toString()) * 0.5;
                        answer.setText(a.toString());
                        et1.setError(null);
                        et2.setError(null);
                    }
                    else {
                        et1.setError("Enter a value");
                        et2.setError("Enter a value");
                    }
                }
                if(tv1.getText().toString() == "Square"){
                    tv1.setError(null);
                    if(!et1.getText().toString().equals("")){
                    Double a = Double.parseDouble(et1.getText().toString()) *
                            Double.parseDouble(et1.getText().toString());
                    answer.setText(a.toString());
                    et1.setError(null); }
                    else{
                        et1.setError("Enter a value");
                    }
                }
                if(tv1.getText().toString() == "Circle"){
                    tv1.setError(null);
                    if(!et1.getText().toString().equals("")){
                    Double a = Double.parseDouble(et1.getText().toString()) *
                            Double.parseDouble(et1.getText().toString()) * 3.1416 ;
                    answer.setText(a.toString());
                    et1.setError(null);}
                    else{
                        et1.setError("Enter a value");
                    }
                }

            }
        });

        Button clear = findViewById(R.id.clrbutton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setError(null);
                et1.setError(null);
                et2.setError(null);
                et1.setText("");
                et2.setText("");
                tv1.setText(R.string.selectshape);
                answer.setText("");


            }
        });



    }
}
