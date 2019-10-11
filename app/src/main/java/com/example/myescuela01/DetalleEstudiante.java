package com.example.myescuela01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleEstudiante extends AppCompatActivity {

    TextView id;
    TextView nombre;
    TextView matricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_estudiante);

        id = findViewById(R.id.textViewId_Detalle);
        nombre = findViewById(R.id.textViewNombre_Detalle);
        matricula = findViewById(R.id.textViewMatricula_Detalle);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            id.setText(b.getString("ID"));
            nombre.setText(b.getString("NOMBRE"));
            matricula.setText(b.getString("MATRICULA"));
        }

    }
}
