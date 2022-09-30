package com.empresaurios.petfriend.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATA_VERSION= 1;
    private static final String DATABASE_NAME = "petfriend.db";
    public static final String TABLE_DATABASE = "MASCOTAS";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("si llama al onCreate");
        db.execSQL("CREATE TABLE " +TABLE_DATABASE+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "raza TEXT NOT NULL," +
                "peso TEXT NOT NULL," +
                "edad TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //elimina la tabla que tenemos
        sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_DATABASE);

        //la crea con las modificaciones que ya se realizaron
        onCreate(sqLiteDatabase);
    }
}
