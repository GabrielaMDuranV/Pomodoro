package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

       /* //Metodos para navegacion entre ventanas
        buttonListaTareas = (Button)findViewById(R.id.buttonBloquearApp);
        buttonListaTareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               // Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
               // startActivity(intent);
            }
        });*/
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                additem(view);
            }
        });
        items = new ArrayList<>();
        itemAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(itemAdapter);
        setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                items.remove(i);
                itemAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void additem(View view) {
        EditText imput = findViewById(R.id.editTextTextPersonName);
        String itemText = imput.getText().toString();

        if (!(itemText.equals(""))){
            itemAdapter.add(itemText);
            imput.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(), "Introduzca el texto", Toast.LENGTH_LONG).show();
        }
    }
}