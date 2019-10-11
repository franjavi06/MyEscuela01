package com.example.myescuela01.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myescuela01.entidad.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositorioDbImpl implements EstudianteRepositorio{

    private DbConexion dbConexion;

    public EstudianteRepositorioDbImpl(Context context){
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public long crear(Estudiante estudiante) {

        ContentValues cv = new ContentValues();
        cv.put("nombre", estudiante.getNombre());
        cv.put("matricula", estudiante.getMatricula());

        SQLiteDatabase db = dbConexion.getWritableDatabase();
        long id = db.insert("estudiante",null,cv);

        if (id <= 0){
            Log.i("EstudianteRepositorio","Error al crear estudiante");
        }else {
            Log.i("EstudianteRepositorio","El estudiante se ha creado exitosamente - "+"id: "+id);
        }

        return id;
    }

    @Override
    public void actualizar(Estudiante estudiante) {

    }

    @Override
    public void borrar(Estudiante estudiante) {

    }

    @Override
    public Estudiante buscar(int id) {
        return null;
    }

    @Override
    public List<Estudiante> buscar() {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from estudiante;",null);
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();

        //Nos aseguramos de que existe al menos un registro
        if (cursor.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                Integer id =cursor.getInt(0);
                String nombre= cursor.getString(1);
                String matricula = cursor.getString(2);
                estudiantes.add(new Estudiante(id,nombre,matricula));
            } while(cursor.moveToNext());
        }

        return estudiantes;
    }
}
