package com.morajavier.aviones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button jbtnRegistro, jbtnPista, jbtnHangar, jbtnVolar, jbtnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbtnRegistro = findViewById(R.id.btnRegistro);
        jbtnPista = findViewById(R.id.btnPista);
        jbtnHangar = findViewById(R.id.btnHangar);
        jbtnVolar = findViewById(R.id.btnVolar);
        jbtnSalir = findViewById(R.id.btnSalir);
        jbtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(i);

            }
        });

        jbtnPista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
            }
        });

        jbtnHangar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
            }
        });

        jbtnVolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
            }
        });

        jbtnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
            }
        });
    }
}
