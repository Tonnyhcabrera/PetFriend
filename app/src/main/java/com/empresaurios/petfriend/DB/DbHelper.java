package com.empresaurios.petfriend.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATA_VERSION= 1;
    private static final String DATABASE_NAME = "petfriend.db";
    public static final String TABLE_DATABASE = "MASCOTAS";
    public static final String TABLE_VACUNAS = "VACUNAS";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " +TABLE_DATABASE+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "raza TEXT NOT NULL," +
                "peso TEXT NOT NULL," +
                "edad TEXT NOT NULL)");


        db.execSQL("CREATE TABLE " +TABLE_VACUNAS+ "(" +
                "nombreVacuna TEXT NOT NULL," +
                "fechaVacuna TEXT NOT NULL," +
                "idMascota INTEGER NOT NULL)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //elimina la tabla que tenemos
        sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_DATABASE);

        //la crea con las modificaciones que ya se realizaron
        onCreate(sqLiteDatabase);

        //elimina la tabla que tenemos
        sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_VACUNAS);

        //la crea con las modificaciones que ya se realizaron
        onCreate(sqLiteDatabase);
    }
}
