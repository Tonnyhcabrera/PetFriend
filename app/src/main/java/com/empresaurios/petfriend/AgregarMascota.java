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

        nom_mascota = findViewById(R.id.nombre_vacuna);
        raza = findViewById(R.id.fecha_vacuna);
        peso_mascota = findViewById(R.id.prox_vacuna);
        edad_mascota = findViewById(R.id.edad_mascota);

    }


    public void Agregar(View view) {
        DbHelper dbHelper = new DbHelper(AgregarMascota.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        if (db !=null ){
            DbMascotas dbMascotas = new DbMascotas(AgregarMascota.this);

            //Permite validar si el campo esta vacio o no
            if (!nom_mascota.getText().toString().isEmpty() && !raza.getText().toString().isEmpty() && !peso_mascota.getText().toString().isEmpty() && !edad_mascota.getText().toString().isEmpty()){

                long id = dbMascotas.insertarMascota(nom_mascota.getText().toString(),raza.getText().toString(),
                        peso_mascota.getText().toString(),edad_mascota.getText().toString());
                Toast.makeText(AgregarMascota.this, "REGISTRO GUARDADO.", Toast.LENGTH_SHORT).show();
                Limpiar();

                System.out.println("Si entre a la validacion!!!!!!!!!!!!!!!!");
            }else{
                Toast.makeText(AgregarMascota.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_SHORT).show();
            }


            //if(id > 0 ){
                //Toast.makeText(AgregarMascota.this, "REGISTRO GUARDADO.", Toast.LENGTH_SHORT).show();
                //Limpiar();

            //}else{

            //}
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