package com.empresaurios.petfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.empresaurios.petfriend.DB.DbHelper;
import com.empresaurios.petfriend.DB.DbVacunas;

import java.util.Calendar;

public class AgregarVacuna extends AppCompatActivity {

    EditText nombreVacuna;
    TextView fechaVacuna, proxVacuna;
    ImageButton buttFecha, buttProximaV;
    DatePickerDialog.OnDateSetListener setListener;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_vacuna);

        nombreVacuna = findViewById(R.id.nombre_vacuna);
        proxVacuna = findViewById(R.id.prox_vacuna);
        fechaVacuna = findViewById(R.id.fecha_vacuna);

        buttFecha = findViewById(R.id.vacu_fecha_ico);
        buttProximaV = findViewById(R.id.prox_Vacuna_ico);

        Calendar calendar = Calendar.getInstance();
        final  int year = calendar.get(Calendar.YEAR);
        final  int month = calendar.get(Calendar.MONTH);
        final  int day = calendar.get(Calendar.DAY_OF_MONTH);


        buttFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AgregarVacuna.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day +"/" + month + "/"+year;
                        fechaVacuna.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        buttProximaV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AgregarVacuna.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day +"/" + month + "/"+year;
                        proxVacuna.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }


    //Se necesita optener el ID de la mascota por lo que se debe agregar un apartado
    // para intent.putExtra para mandar los valores entre actividades
    public void AgregarVacuna(View view){
        DbHelper dbHelper = new DbHelper(AgregarVacuna.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (db != null){
            Bundle datos = getIntent().getExtras();
            int datosObtenidos = datos.getInt("IDmascota");
            System.out.println(datosObtenidos+"---------------------------------------");
            DbVacunas dbVacunas = new DbVacunas(AgregarVacuna.this);
            long id = dbVacunas.insertarVacuna(nombreVacuna.getText().toString(),
                    fechaVacuna.getText().toString(),proxVacuna.getText().toString(),datosObtenidos);
            if(id > 0){
                Toast.makeText(AgregarVacuna.this, "REGISTRO GUARDADO EXITOSAMENTE", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(AgregarVacuna.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(AgregarVacuna.this, "BASE DE DATOS NO CREADA", Toast.LENGTH_SHORT).show();
        }
    }
}