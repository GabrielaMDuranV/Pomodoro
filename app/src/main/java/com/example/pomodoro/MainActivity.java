package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Declaracion de variable
    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Metodos para navegacion entre ventanas
        buttonStart = (Button)findViewById(R.id.buttonstart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
              Intent intent = new Intent(MainActivity.this, MainActivity2.class);
              startActivity(intent);
            }
        });

    }
}

