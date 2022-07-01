package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button buttonpomo;
    Button buttonListaTareas;
    Button buttonGuia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Metodos para navegacion entre ventanas
        buttonpomo = (Button)findViewById(R.id.buttonpomo);
        buttonpomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Objeto tipo Intent de accion para solicitar acccion de otro componente
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                //Uso del metodod startActivity colocando el objeto que permite hacer el cambio de pantalla
                startActivity(intent);
            }
        });

        buttonListaTareas = (Button)findViewById(R.id.buttonListaTareas);
        buttonListaTareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Objeto tipo Intent de accion para solicitar acccion de otro componente
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                //Uso del metodod startActivity colocando el objeto que permite hacer el cambio de pantalla
                startActivity(intent);
            }
        });

        buttonGuia = (Button)findViewById(R.id.buttonGuia);
        buttonGuia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }
        });
    }
}