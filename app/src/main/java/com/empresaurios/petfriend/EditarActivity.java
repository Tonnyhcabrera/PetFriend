package com.empresaurios.petfriend;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.empresaurios.petfriend.DB.DbMascotas;
import com.empresaurios.petfriend.entidades.Mascotas;

public class EditarActivity extends AppCompatActivity {

    EditText txtNombre, txtRaza, txtPeso, txtEdad;
    Button btnGuardar, btnModificar, btnEliminar;
    boolean correcto = false;
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
        btnModificar.setVisibility(View.INVISIBLE);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnEliminar.setVisibility(View.INVISIBLE);

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

        DbMascotas dbMascotas = new DbMascotas(EditarActivity.this);
        mascotas = dbMascotas.verMascota(id);

        if (mascotas != null){
            txtNombre.setText(mascotas.getNombre());
            txtRaza.setText(mascotas.getRaza());
            txtPeso.setText(mascotas.getPeso());
            txtEdad.setText(mascotas.getEdad());

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!txtNombre.getText().toString().equals("") && !txtRaza.getText().toString().equals("") && !txtPeso.getText().toString().equals("") && !txtRaza.getText().toString().equals("")){
                        correcto = dbMascotas.editarMascota(id,txtNombre.getText().toString(),txtRaza.getText().toString(),txtPeso.getText().toString(),txtRaza.getText().toString());
                    
                        if (correcto){
                            Toast.makeText(EditarActivity.this, "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                            verRegistro();
                        }
                        else{
                            Toast.makeText(EditarActivity.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(EditarActivity.this, "DEBE LLEGAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void verRegistro(){
        Intent intent = new Intent(this, EditarActivity.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
}