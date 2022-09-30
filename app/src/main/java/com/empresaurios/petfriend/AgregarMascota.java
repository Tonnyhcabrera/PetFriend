package com.empresaurios.petfriend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.empresaurios.petfriend.DB.DbHelper;
import com.empresaurios.petfriend.DB.DbMascotas;

public class AgregarMascota extends AppCompatActivity {

    EditText nom_mascota,raza, peso_mascota, edad_mascota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);

        nom_mascota = findViewById(R.id.nombre_mascota);
        raza = findViewById(R.id.raza);
        peso_mascota = findViewById(R.id.peso_mascota);
        edad_mascota = findViewById(R.id.edad_mascota);

    }


    public void Agregar(View view) {
        DbHelper dbHelper = new DbHelper(AgregarMascota.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (db !=null){
            DbMascotas dbContactos = new DbMascotas(AgregarMascota.this);
            long id = dbContactos.insertarContacto(nom_mascota.getText().toString(),raza.getText().toString(),
                    peso_mascota.getText().toString(),edad_mascota.getText().toString());

            if(id > 0){
                Toast.makeText(AgregarMascota.this, "REGISTRO GUARDADO.", Toast.LENGTH_SHORT).show();
                Limpiar();
            }else{
                Toast.makeText(AgregarMascota.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(AgregarMascota.this, "BASE DE DATOS NO CREADA", Toast.LENGTH_SHORT).show();
        }

    }

    private void Limpiar() {
        nom_mascota.setText("");
        raza.setText("");
        peso_mascota.setText("");
        edad_mascota.setText("");
    }

    private void eliminarRegistro(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AgregarMascota.this);
        builder.setMessage("¿Desea eliminar esta mascota?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


}