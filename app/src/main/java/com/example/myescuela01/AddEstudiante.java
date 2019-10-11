package com.example.myescuela01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myescuela01.entidad.Estudiante;
import com.example.myescuela01.repositorio.EstudianteRepositorioDbImpl;
import com.google.android.material.snackbar.Snackbar;

public class AddEstudiante extends AppCompatActivity {

    EditText nombre;
    EditText matricula;
    Button guardar;
    EstudianteRepositorioDbImpl estudianteRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_estudiante);

        nombre = findViewById(R.id.editTextNombre);
        matricula = findViewById(R.id.editTextMatricula);
        guardar = findViewById(R.id.buttonGuardar);
        estudianteRepositorio = new EstudianteRepositorioDbImpl(this.getBaseContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensaje = "";
                Estudiante est1 = new Estudiante();
                est1.setNombre(nombre.getText().toString());
                est1.setMatricula(matricula.getText().toString());
                long respuesta = estudianteRepositorio.crear(est1);
                if (respuesta==-1)
                    mensaje = "Error al Crear Estudiante";
                else
                    mensaje = "Estudiante Creado! Id: "+respuesta;

                nombre.setText("");
                matricula.setText("");

                Toast toast1 = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
                toast1.show();

            }
        });
    }
}
