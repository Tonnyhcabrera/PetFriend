package com.empresaurios.petfriend.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.empresaurios.petfriend.AgregarMascota;
import com.empresaurios.petfriend.entidades.Mascotas;

import java.util.ArrayList;

public class DbMascotas extends DbHelper {

    Context context;


    public DbMascotas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarMascota(String nombre, String raza, String peso,String edad){


        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();



                System.out.println("SI pasa el if de validacion de campos vacion ");
                ContentValues values = new ContentValues();
                values.put("nombre", nombre);
                values.put("raza", raza);
                values.put("peso", peso);
                values.put("edad", edad);

                id = db.insert(TABLE_DATABASE, null,values);

        }catch(Exception ex){
            ex.toString();
        }
        return id;

        }

        public ArrayList<Mascotas> mostrarMascotas(){

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ArrayList<Mascotas> listaMascotas = new ArrayList<>();
            Mascotas mascotas = null;
            Cursor cursorMascotas = null;

            cursorMascotas = db.rawQuery("SELECT * FROM " + TABLE_DATABASE,null);

            if(cursorMascotas.moveToFirst()){
                do {
                    mascotas = new Mascotas();
                    mascotas.setId(cursorMascotas.getInt(0));
                    mascotas.setNombre(cursorMascotas.getString(1));
                    mascotas.setRaza("Raza: " +cursorMascotas.getString(2));
                    mascotas.setPeso("Peso: "+cursorMascotas.getString(3) + "  Kg");
                    if (cursorMascotas.getString(4) == "1"){
                        mascotas.setEdad("Edad: "+cursorMascotas.getString(4)+ "  Año");
                    }else{
                        mascotas.setEdad("Edad: "+cursorMascotas.getString(4)+ "  Años");
                    }
                    listaMascotas.add(mascotas);
                }while(cursorMascotas.moveToNext());
            }
            cursorMascotas.close();
            return listaMascotas;
        }

    public Mascotas verMascota(int id){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Mascotas mascotas = null;
        Cursor cursorMascotas = null;

        cursorMascotas = db.rawQuery("SELECT * FROM " + TABLE_DATABASE + " WHERE id = " + id + " LIMIT 1 " ,null);

        if(cursorMascotas.moveToFirst()){

                mascotas = new Mascotas();
                mascotas.setId(cursorMascotas.getInt(0));
                mascotas.setNombre(cursorMascotas.getString(1));
                mascotas.setRaza("Raza: " +cursorMascotas.getString(2));
                mascotas.setPeso("Peso: "+cursorMascotas.getString(3) + "  Kg");
                if (cursorMascotas.getString(4) == "1"){
                    mascotas.setEdad("Edad: "+cursorMascotas.getString(4)+ "  Año");
                }else{
                    mascotas.setEdad("Edad: "+cursorMascotas.getString(4)+ "  Años");
                }

        }
        cursorMascotas.close();
        return mascotas;
    }


    public boolean editarMascota(int id, String nombre, String raza, String peso,String edad){

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try{
             db.execSQL(" UPDATE " + TABLE_DATABASE + " SET nombre = '"+nombre+" ', raza = '"+ raza +" ', nombre = '"+peso+" ', edad = '"+edad+" ' WHERE id = '" + id + "' "  );

             correcto = true;
        }catch(Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }
        return correcto;

    }

    public boolean eliminarMascota(int id){

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try{
            db.execSQL(" DELETE FROM " + TABLE_DATABASE + " WHERE id = '" + id + "'");
            correcto = true;
        }catch(Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }
        return correcto;

    }



}
