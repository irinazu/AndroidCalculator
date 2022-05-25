package com.example.firstlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calculator;
    private TextView input;
    private TextView inputRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator=new Calculator();

        int nums[]=new int[]{
                R.id.comma,
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine
        };

        int signs[]=new int[]{
                R.id.plus,
                R.id.minus,
                R.id.division,
                R.id.multipl,
                R.id.c,
                //R.id.change,
                //R.id.x,
                //R.id.result,
                //R.id.sqrt
        };

        input=findViewById(R.id.input);
        inputRes=findViewById(R.id.textView);

        View.OnClickListener onNumClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.numTrigger(view.getId());
                input.setText(calculator.getText());
            }
        };

        View.OnClickListener onActionClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.actionTrigger(view.getId());
                calculator.setTextFromInput(input.getText().toString());
                inputRes.setText(calculator.getTextForInpRes());
                input.setText("");
               //calculator.actionTrigger(view.getId());


            }
        };

        View.OnClickListener onResClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.actionTrigger(view.getId());
                input.setText(calculator.getText());
                inputRes.setText("");
            }
        };

        View.OnClickListener onChacneClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.actionTrigger(view.getId());
                input.setText(calculator.getText());
            }
        };

        for (int i=0;i<nums.length;i++){
            findViewById(nums[i]).setOnClickListener(onNumClickListener);
        }

        for (int i=0;i<signs.length;i++){
            findViewById(signs[i]).setOnClickListener(onActionClickListener);
        }
        findViewById(R.id.result).setOnClickListener(onResClickListener);
        findViewById(R.id.change).setOnClickListener(onChacneClickListener);
        findViewById(R.id.x).setOnClickListener(onChacneClickListener);
        findViewById(R.id.sqrt).setOnClickListener(onChacneClickListener);


    }




}