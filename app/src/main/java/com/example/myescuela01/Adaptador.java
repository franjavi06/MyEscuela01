package com.example.myescuela01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myescuela01.entidad.Estudiante;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    List<Estudiante> estudiantes;

    public Adaptador(Context conexto, List<Estudiante> estudiantes)
    {
        this.contexto = conexto;
        this.estudiantes = estudiantes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return estudiantes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.row, null);
        TextView nombre = vista.findViewById(R.id.textViewnombre);
        TextView matricula = vista.findViewById(R.id.textViewmatricula);

        nombre.setText(estudiantes.get(position).getNombre());
        matricula.setText(estudiantes.get(position).getMatricula());

        return vista;
    }
}
