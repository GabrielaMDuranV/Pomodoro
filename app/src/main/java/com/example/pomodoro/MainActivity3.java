package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;
import java.util.TimerTask;

public class MainActivity3 extends AppCompatActivity {
    Button buttonvolver;
    Button buttonGuia;
    private static final long START_TIMER_IN_MILLIS = 600000;

    private TextView cuentaregresiva;
    private Button buttonIniciar_Pausa;
    private Button buttonReiniciar;
    private CountDownTimer countDownTimer;
    private  boolean TimerRunning;
    private long TimeLeftInMillis = START_TIMER_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        buttonvolver = (Button)findViewById(R.id.buttonvolver);
        buttonvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver1 = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(volver1);
            }
        });


        cuentaregresiva = findViewById(R.id.cuentaregresiva);
        buttonIniciar_Pausa = findViewById(R.id.buttonIniciar_Pausa);
        buttonReiniciar = findViewById(R.id.buttonReiniciar);

        buttonIniciar_Pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        buttonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(TimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished){
                TimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                TimerRunning = false;
                buttonIniciar_Pausa.setText("Iniciar");
                buttonIniciar_Pausa.setVisibility(View.INVISIBLE);
                buttonReiniciar.setVisibility(View.VISIBLE);
            }

            /*@Override
            public void onFinish(long millisUntilFinished){
                TimerRunning = false;
                buttonIniciar_Pausa.setText("Iniciar");
                buttonIniciar_Pausa.setVisibility(View.INVISIBLE);
                buttonReiniciar.setVisibility(View.VISIBLE);
            }*/
        }.start();
        TimerRunning = true;
        buttonIniciar_Pausa.setText("Pausa");
        buttonReiniciar.setVisibility(View.INVISIBLE);

    }
    private void pauseTimer(){
        countDownTimer.cancel();
        TimerRunning = false;
        buttonIniciar_Pausa.setText("Iniciar");
        buttonReiniciar.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        TimeLeftInMillis = START_TIMER_IN_MILLIS;
        updateCountDownText();
        buttonReiniciar.setVisibility(View.INVISIBLE);
        buttonIniciar_Pausa.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (TimeLeftInMillis / 400) / 60; //1000 para 20min
        int seconds = (int) (TimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        cuentaregresiva.setText(timeLeftFormatted);
    }
}