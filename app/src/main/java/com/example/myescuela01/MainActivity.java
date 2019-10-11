package com.example.myescuela01;

import android.content.Intent;
import android.os.Bundle;

import com.example.myescuela01.entidad.Estudiante;
import com.example.myescuela01.repositorio.EstudianteRepositorioDbImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EstudianteRepositorioDbImpl estudianteRepositorio;
    ListView lv;
    List<Estudiante> estudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addEstudiante = new Intent(view.getContext(),AddEstudiante.class);
                startActivity(addEstudiante);
            }
        });

        estudianteRepositorio = new EstudianteRepositorioDbImpl(this.getBaseContext());

        lv = findViewById(R.id.lvestudiantes);

        estudiantes = estudianteRepositorio.buscar();

        if (estudiantes.size()>0){
            lv.setAdapter(new Adaptador(this, estudiantes));
        }
        else {
            Toast toast1 = Toast.makeText(getApplicationContext(), "No hay estudiantes registrados", Toast.LENGTH_SHORT);
            toast1.show();
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalleEstudiante = new Intent(view.getContext(), DetalleEstudiante.class);
                detalleEstudiante.putExtra("ID", estudiantes.get(position).getId().toString());
                detalleEstudiante.putExtra("NOMBRE", estudiantes.get(position).getNombre());
                detalleEstudiante.putExtra("MATRICULA", estudiantes.get(position).getMatricula());
                startActivity(detalleEstudiante);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
        estudiantes = estudianteRepositorio.buscar();

        if (estudiantes.size()>0){
            lv.setAdapter(new Adaptador(this, estudiantes));
        }
        else {
            Toast toast1 = Toast.makeText(getApplicationContext(), "No hay estudiantes registrados", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
