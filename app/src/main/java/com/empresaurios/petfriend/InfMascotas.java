package com.empresaurios.petfriend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.empresaurios.petfriend.DB.DbMascotas;
import com.empresaurios.petfriend.entidades.Mascotas;

public class InfMascotas extends AppCompatActivity {

    EditText txtNombre, txtRaza, txtPeso, txtEdad;
    Button btnGuardar, btnModificar, btnEliminar;
    Mascotas mascotas;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_mascotas);

        txtNombre = findViewById(R.id.nombre_mascota);
        txtRaza = findViewById(R.id.raza);
        txtEdad = findViewById(R.id.edad_mascota);
        txtPeso = findViewById(R.id.peso_mascota);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnModificar = findViewById(R.id.btnModificar);
        btnEliminar = findViewById(R.id.btnEliminar);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbMascotas dbMascotas = new DbMascotas(InfMascotas.this);
        mascotas = dbMascotas.verMascota(id);

        if (mascotas != null){
            txtNombre.setText(mascotas.getNombre());
            txtRaza.setText(mascotas.getRaza());
            txtPeso.setText(mascotas.getPeso());
            txtEdad.setText(mascotas.getEdad());
            //Momentaneo para que no muestre el boton ni saque el teclado

            btnGuardar.setVisibility(View.INVISIBLE);
            txtNombre.setInputType(InputType.TYPE_NULL);// NO MUESTRA EL TECLADO EN LOS CAMPOS DE TEXTO
            txtRaza.setInputType(InputType.TYPE_NULL);
            txtPeso.setInputType(InputType.TYPE_NULL);
            txtEdad.setInputType(InputType.TYPE_NULL);
        }

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfMascotas.this, EditarActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(InfMascotas.this);
                builder.setMessage("¿Desea elimiar esta mascota?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                if (dbMascotas.eliminarMascota(id)){
                                    lista();
                                }
                    }
                })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
    }
    private  void lista(){
        Intent intent = new Intent(this, ListaMascotas.class);
        startActivity(intent);
    }
}