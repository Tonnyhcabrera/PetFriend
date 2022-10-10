package com.empresaurios.petfriend.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbVacunas extends DbHelper{

    Context context;

    public DbVacunas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarVacuna(String nombreVacuna, String fechaVacuna, String proxVacuna, int idMascota){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombreVacuna", nombreVacuna);
            values.put("fechaVacuna", fechaVacuna);
            values.put("proxVacuna", proxVacuna);
            values.put("idMascota", idMascota);

            id = db.insert(TABLE_VACUNAS, null,values);

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
