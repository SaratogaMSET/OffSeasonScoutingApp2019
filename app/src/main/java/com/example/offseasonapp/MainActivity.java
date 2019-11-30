package com.example.offseasonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button scale2;
    private Button scale1;
    private Button switch1;
    private Stack<Integer> stack;
    public int x = 0;
    public int y = 0;
    public int z = 0;
    public int value = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scale1 = (Button) findViewById(R.id.scale1);
        scale2 = (Button) findViewById(R.id.scale2);
        switch1 = (Button) findViewById(R.id.switch1);
        stack = new Stack<Integer>();

    }

    public void undoclick(View v) {
        Button b = (Button) v;
        if (!stack.isEmpty()) {
            value = stack.pop();
            b = findViewById(value);
            String text = b.getText().toString();
            if(value == 2131165317){
                y--;
                int score = Integer.parseInt(text);
                score--;
                b.setText(Integer.toString(score));
            }
            if(value == 2131165349){
                x--;
                int score = Integer.parseInt(text);
                score--;
                b.setText(Integer.toString(score));
            }
            if(value == 2131165318){
                z--;
                int score = Integer.parseInt(text);
                score--;
                b.setText(Integer.toString(score));
            }
        }


    }

    public void click(View v) {
        Button b = (Button) v;
        x+=1;
        stack.push(b.getId());
        b.setText(Integer.toString(x));
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void change1(View v) {
        Button b = (Button) v;
        stack.push(b.getId());
        y+=1;
        b.setText(Integer.toString(y));
        Log.d("buttonId", Integer.toString(v.getId()));

    }

    public void change2(View v) {
        Button b = (Button) v;
        stack.push(b.getId());
        z+=1;
        b.setText(Integer.toString(z));
        Log.d("buttonId", Integer.toString(v.getId()));
    }


}
