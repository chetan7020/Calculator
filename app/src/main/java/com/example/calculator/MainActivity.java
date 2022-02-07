package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText firstNumber  = findViewById(R.id.firstNumber);
        final EditText secondNumber  =  findViewById(R.id.secondNumber);
        final EditText operator  =  findViewById(R.id.operator);
        final TextView output  =  findViewById(R.id.output);
        final TextView ans =  findViewById(R.id.equals);
        ans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String op = String.valueOf(operator.getText());
                String num1 = String.valueOf(firstNumber.getText());
                String num2 = String.valueOf(secondNumber.getText());
                if(op.trim().equals("") || num1.trim().equals("") || num2.trim().equals("")){
                    makeToast("All fields are required");
                }else{
                    if(op.trim().equals("+") || op.trim().equals("-") || op.trim().equals("*") || op.trim().equals("/")){
                        int n1 = Integer.parseInt(String.valueOf(firstNumber.getText()));
                        int n2 = Integer.parseInt(String.valueOf(secondNumber.getText()));
                        if(op.equals("+")){
                            output.setText(String.valueOf(n1 + n2));
                        }else if(op.equals("-")){
                            output.setText(String.valueOf(n1 - n2));
                        }else if(op.equals("*")){
                            output.setText(String.valueOf(n1 * n2));
                        }else if(op.equals("/")){
                            output.setText(String.valueOf(n1 / n2));
                        }
                    }
                    else {
                        makeToast("Invalid Operator");
                    }
                }


            }
        });
//        secondNumber.setOnTouchListener(new View.OnTouchListener(){
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int inType = secondNumber.getInputType(); // backup the input type
//                secondNumber.setInputType(InputType.TYPE_NULL); // disable soft input
//                secondNumber.onTouchEvent(event); // call native handler
//                secondNumber.setInputType(inType); // restore input type
//                return true; // consume touch even
//            }
//        });

    }

    private void makeToast(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}